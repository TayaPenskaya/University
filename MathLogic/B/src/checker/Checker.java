package checker;

import expression.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Checker {

    private final Expression statement;
    private final List<Expression> hyps;
    private final List<Expression> proof;
    private final List<Expression> axioms = new AxiomsProvider().getAxioms();


    private int counter = 0;
    private final Map<Expression, Integer> numByExpr = new HashMap<>();
    private final Map<Integer, Expression> exprByNum = new HashMap<>();
    private final Map<Expression, List<Integer>> exprByRightPart = new HashMap<>();
    private boolean proved = false;

    public Checker(Expression statement, List<Expression> hyps, List<Expression> proof) {
        this.statement = statement;
        this.hyps = hyps;
        this.proof = proof;
    }

    private boolean checkMatches(Expression axPart, Expression toCheck, Map<Expression, Expression> varToExpr) {
        if (axPart.isVariable()) {
            Expression expression = varToExpr.get(axPart);
            if (expression == null) {
                varToExpr.put(axPart, toCheck);
                return true;
            }
            return toCheck.equals(expression);
        }

        if (axPart.getClass() == toCheck.getClass()) {

            if (axPart.isBinary()) {
                return axPart.asBinary().getOperator().equals(toCheck.asBinary().getOperator()) &&
                        checkMatches(axPart.asBinary().getLeft(), toCheck.asBinary().getLeft(), varToExpr) &&
                        checkMatches(axPart.asBinary().getRight(), toCheck.asBinary().getRight(), varToExpr);
            }
            if (axPart.isUnary()) {
                return axPart.asUnary().getOperator().equals(toCheck.asUnary().getOperator()) &&
                        checkMatches(axPart.asUnary().getExpression(), toCheck.asUnary().getExpression(), varToExpr);
            }
        }
        return false;
    }

    private ProvedExpression checkAxiom(Expression toCheck) {
        for (int i = 0; i < axioms.size(); ++i) {
            if (checkMatches(axioms.get(i), toCheck, new HashMap<>())) {
                return new ProvedExpression(toCheck, new Axiom(counter, i));
            }
        }
        return null;
    }

    private ProvedExpression checkHyp(Expression toCheck) {
        for (int i = 0; i < hyps.size(); ++i) {
            if (hyps.get(i).equals(toCheck)) {
                return new ProvedExpression(toCheck, new Hypothesis(counter, i));
            }
        }
        return null;
    }

    private ProvedExpression checkMP(Expression toCheck) {
        List<Integer> byRightPart = exprByRightPart.get(toCheck);
        if (byRightPart == null) {
            return null;
        }

        for (int from : byRightPart) {
            Integer to = numByExpr.get(exprByNum.get(from).asBinary().getLeft());
            if (to == null) {
                continue;
            }
            return new ProvedExpression(toCheck, new ModusPonens(counter, from, to));
        }
        return null;
    }

    private void updMaps(Expression expression) {
        exprByNum.put(counter, expression);
        numByExpr.put(expression, counter);
        if (expression.isImplication()) {
            Expression rightPart = expression.asBinary().getRight();
            exprByRightPart.putIfAbsent(rightPart, new ArrayList<>());
            exprByRightPart.computeIfPresent(rightPart, (e, l) -> {
                l.add(counter);
                return l;
            });
        }
        ++counter;
    }

    public List<ProvedExpression> checkAll() {
        List<ProvedExpression> ans = new ArrayList<>();
        for (Expression expression : proof) {

            if (numByExpr.get(expression) != null && !expression.equals(statement)) {
                continue;
            }

            ProvedExpression provedExpression = checkHyp(expression);
            if (provedExpression != null) {
                updMaps(expression);
                if (!proved) {
                    ans.add(provedExpression);
                }
                continue;
            }

            provedExpression = checkAxiom(expression);
            if (provedExpression != null) {
                updMaps(expression);
                if (!proved) {
                    ans.add(provedExpression);
                }
                continue;
            }


            provedExpression = checkMP(expression);

            if (provedExpression == null) {
                return null;
            }

            updMaps(expression);
            if (!proved) {
                ans.add(provedExpression);
            }
            if (expression.equals(statement)) {
                proved = true;
            }
        }
        return ans;
    }

}
