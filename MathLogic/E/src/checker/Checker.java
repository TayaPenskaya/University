package checker;

import expression.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Checker {

    private final Expression statement;
    private final Map<Expression, Integer> hyps;
    private final List<Expression> proof;
    private final List<Expression> axioms = new AxiomsProvider().getAxioms();

    private final Map<Expression, List<Expression>> exprByRightPart = new HashMap<>();
    private final List<Expression> provedExpr = new ArrayList<>();

    public Checker(Expression statement, Map<Expression, Integer> hyps, List<Expression> proof) {
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
            if (axPart.isFoo()) {
                boolean res = true;
                for (int i = 0; i < axPart.asFoo().getArgs().size(); ++i) {
                    res &= checkMatches(axPart.asFoo().getArgs().get(i), toCheck.asFoo().getArgs().get(i), varToExpr);
                }
                return res && checkMatches(axPart.asFoo().getVariable(), toCheck.asFoo().getVariable(), varToExpr);
            }
            if (axPart.isQuantifier()) {
                return axPart.asQuantifier().getQuantifier().equals(toCheck.asQuantifier().getQuantifier()) &&
                        checkMatches(axPart.asQuantifier().getExpression(), toCheck.asQuantifier().getExpression(), varToExpr) &&
                        checkMatches(axPart.asQuantifier().getVariable(), toCheck.asQuantifier().getVariable(), varToExpr);
            }
        }
        return false;
    }

    private boolean checkAxiom(Expression toCheck) {
        for (int i = 0; i <= 9; ++i) {
            if (checkMatches(axioms.get(i), toCheck, new HashMap<>())) {
                add(toCheck);
                return true;
            }
        }
        for (int i = 10; i < axioms.size(); ++i){
            if (equalsByVars(axioms.get(i), toCheck)) {
                add(toCheck);
                return true;
            }
        }
        return false;
    }


    private boolean equalsByVars(Expression axPart, Expression toCheck) {
        if (axPart.isVariable()) {
            return toCheck.equals(axPart);
        }

        if (axPart.getClass() == toCheck.getClass()) {

            if (axPart.isBinary()) {
                return axPart.asBinary().getOperator().equals(toCheck.asBinary().getOperator()) &&
                        equalsByVars(axPart.asBinary().getLeft(), toCheck.asBinary().getLeft()) &&
                        equalsByVars(axPart.asBinary().getRight(), toCheck.asBinary().getRight());
            }
            if (axPart.isUnary()) {
                return axPart.asUnary().getOperator().equals(toCheck.asUnary().getOperator()) &&
                        equalsByVars(axPart.asUnary().getExpression(), toCheck.asUnary().getExpression());
            }
            if (axPart.isFoo()) {
                boolean res = true;
                for (int i = 0; i < axPart.asFoo().getArgs().size(); ++i) {
                    res &= equalsByVars(axPart.asFoo().getArgs().get(i), toCheck.asFoo().getArgs().get(i));
                }
                return res && equalsByVars(axPart.asFoo().getVariable(), toCheck.asFoo().getVariable());
            }
            if (axPart.isQuantifier()) {
                return axPart.asQuantifier().getQuantifier().equals(toCheck.asQuantifier().getQuantifier()) &&
                        equalsByVars(axPart.asQuantifier().getExpression(), toCheck.asQuantifier().getExpression()) &&
                        equalsByVars(axPart.asQuantifier().getVariable(), toCheck.asQuantifier().getVariable());
            }
        }
        return false;

    }

    private boolean checkForFree(Expression axPart, Expression toCheck, Map<Expression, Expression> varToExpr, Set<Expression> quantVars) {

        if (axPart.isVariable()) {
            Expression expression = varToExpr.get(axPart);
            boolean b = quantVars.contains(axPart);
            if (expression == null && (!b)) {
                varToExpr.put(axPart, toCheck);
                return true;
            }
            if (b) {
                return toCheck.equals(axPart);
            }
            return toCheck.equals(expression);
        }

        if (axPart.getClass() == toCheck.getClass()) {

            if (axPart.isBinary()) {
                return axPart.asBinary().getOperator().equals(toCheck.asBinary().getOperator()) &&
                        checkForFree(axPart.asBinary().getLeft(), toCheck.asBinary().getLeft(), varToExpr, quantVars) &&
                        checkForFree(axPart.asBinary().getRight(), toCheck.asBinary().getRight(), varToExpr, quantVars);
            }
            if (axPart.isUnary()) {
                return axPart.asUnary().getOperator().equals(toCheck.asUnary().getOperator()) &&
                        checkForFree(axPart.asUnary().getExpression(), toCheck.asUnary().getExpression(), varToExpr, quantVars);
            }
            if (axPart.isFoo()) {
                boolean res = true;
                for (int i = 0; i < axPart.asFoo().getArgs().size(); ++i) {
                    res &= checkForFree(axPart.asFoo().getArgs().get(i), toCheck.asFoo().getArgs().get(i), varToExpr, quantVars);
                }
                return res && checkForFree(axPart.asFoo().getVariable(), toCheck.asFoo().getVariable(), varToExpr, quantVars);
            }
            if (axPart.isQuantifier()) {
                quantVars.add(axPart.asQuantifier().getVariable());
                return axPart.asQuantifier().getQuantifier().equals(toCheck.asQuantifier().getQuantifier()) &&
                        checkForFree(axPart.asQuantifier().getExpression(), toCheck.asQuantifier().getExpression(), varToExpr, quantVars) &&
                        checkForFree(axPart.asQuantifier().getVariable(), toCheck.asQuantifier().getVariable(), varToExpr, quantVars);
            }
        }
        return false;
    }

    private boolean checkHyp(Expression toCheck) {
        Integer number = hyps.get(toCheck);
        if (number == null) {
            return false;
        }
        add(toCheck);
        return true;
    }

    private boolean checkMP(Expression toCheck) {
        List<Expression> byRightPart = exprByRightPart.get(toCheck);
        if (byRightPart == null) {
            return false;
        }

        for (Expression from : byRightPart) {
            if (from.isImplication() && provedExpr.contains(from.asImplication().getLeft())) {
                add(toCheck);
                return true;
            }
        }
        return false;
    }

    private void add(Expression expression) {
        if (expression.isImplication()) {
            Expression rightPart = expression.asBinary().getRight();
            exprByRightPart.putIfAbsent(rightPart, new ArrayList<>());
            exprByRightPart.get(rightPart).add(expression);
        }
        provedExpr.add(expression);
    }



    private Set<String> freeVars(Expression expression, Set<String> visScope) {
        if (expression.isVariable()) {
            String var = expression.asVariable().print();
            if (visScope.contains(var)) {
                return new HashSet<>();
            }
            return Stream.of(var).collect(Collectors.toSet());
        }

        if (expression.isBinary()) {
            BinaryOperator binaryOperator = expression.asBinary();
            return Stream.of(freeVars(binaryOperator.getRight(), visScope), freeVars(binaryOperator.getLeft(), visScope))
                    .flatMap(Collection::stream)
                    .collect(Collectors.toSet());
        }

        if (expression.isUnary()) {
            UnaryOperator unaryOperator = expression.asUnary();
            return freeVars(unaryOperator.getExpression(), visScope);
        }

        if (expression.isFoo()) {
            return expression.asFoo()
                    .getArgs()
                    .stream()
                    .map(arg -> freeVars(arg, visScope))
                    .flatMap(Collection::stream)
                    .collect(Collectors.toSet());
        }

        if (expression.isQuantifier()) {
            Quantifier quantifier = expression.asQuantifier();
            visScope.add(quantifier.getVariable().print());
            Set<String> ans = freeVars(quantifier.getExpression(), visScope);
            visScope.remove(quantifier.getVariable().print());
            return ans;
        }
        return new HashSet<>();
    }

    private Set<String> visScopes(Expression expression, String variable, Set<String> visScope) {
        if (expression.isVariable()) {
            String var = expression.asVariable().print();
            if (variable.equals(var)) {
                return new HashSet<>(visScope);
            }
        }

        if (expression.isBinary()) {
            BinaryOperator binaryOperator = expression.asBinary();
            return Stream.of(visScopes(binaryOperator.getRight(), variable, visScope), visScopes(binaryOperator.getLeft(), variable, visScope))
                    .flatMap(Collection::stream)
                    .collect(Collectors.toSet());
        }

        if (expression.isUnary()) {
            UnaryOperator unaryOperator = expression.asUnary();
            return visScopes(unaryOperator.getExpression(), variable, visScope);
        }

        if (expression.isFoo()) {
            return expression.asFoo()
                    .getArgs()
                    .stream()
                    .map(arg -> visScopes(arg, variable, visScope))
                    .flatMap(Collection::stream)
                    .collect(Collectors.toSet());
        }
        if (expression.isQuantifier()) {
            Quantifier quantifier = expression.asQuantifier();
            visScope.add(quantifier.getVariable().print());
            Set<String> ans = visScopes(quantifier.getExpression(), variable, visScope);
            visScope.remove(quantifier.getVariable().print());
            return ans;
        }
        return new HashSet<>();
    }

    //A[x := T]
    private boolean canSubstitute(Expression A, Variable x, Expression T) {
        Set<String> fromT = freeVars(T, new HashSet<>());
        Set<String> fromA = visScopes(A, x.print(), new HashSet<>());
        for (String t : fromT) {
            if (fromA.contains(t)) {
                return false;
            }
        }
        return true;
    }

    //@xA -> A[x := T]
    private boolean check11(Expression toCheck) {
        if (toCheck.isImplication()) {
            Expression leftPart = toCheck.asBinary().getLeft();
            if (leftPart.isAny()) {
                Variable x = leftPart.asQuantifier().getVariable();
                Expression A = leftPart.asQuantifier().getExpression();
                Expression rightPart = toCheck.asBinary().getRight();
                HashMap<Expression, Expression> map = new HashMap<>();
                Set<Expression> q = new HashSet<>();
                if (checkForFree(A, rightPart, map, q)) {
                    Expression T = map.get(x);
                    if ((T == null) && (A.equals(rightPart))) {
                        add(toCheck);
                        return true;
                    }
                    if ((canSubstitute(A, x, T)) || (T.equals(x))) {
                        add(toCheck);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //A[x := T] -> ?xA
    private boolean check12(Expression toCheck) {
        if (toCheck.isImplication()) {
            Expression rightPart = toCheck.asBinary().getRight();
            if (rightPart.isExists()) {
                Variable x = rightPart.asQuantifier().getVariable();
                Expression A = rightPart.asQuantifier().getExpression();
                Expression leftPart = toCheck.asBinary().getLeft();
                HashMap<Expression, Expression> map = new HashMap<>();
                Set<Expression> q = new HashSet<>();
                if (checkForFree(A, leftPart, map, q)) {
                    Expression T = map.get(x);
                    if ((T == null) && (A.equals(leftPart))) {
                        add(toCheck);
                        return true;
                    }
                    if ((canSubstitute(A, x, T)) || (T.equals(x))) {
                        add(toCheck);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //A[x := 0] && @x(A -> A[x := x']) -> A; x входит свободно в A
    private boolean checkInduction(Expression toCheck) {
        if (toCheck.isImplication()) {
            Expression leftPart = toCheck.asBinary().getLeft();
            Expression A = toCheck.asBinary().getRight();
            if (leftPart.isConjunction()) {
                Expression llPart = leftPart.asBinary().getLeft();
                Expression lrPart = leftPart.asBinary().getRight();
                if (lrPart.isAny()) {
                    Variable x = lrPart.asQuantifier().getVariable();
                    Set<String> free = freeVars(A, new HashSet<>());
                    if (!(free.contains(x.print()))) {
                        return false;
                    }
                    Expression impl = lrPart.asQuantifier().getExpression();
                    if (impl.isImplication()) {
                        Expression nextA = impl.asBinary().getRight();
                        HashMap<Expression, Expression> map = new HashMap<>();
                        if (checkMatches(A, nextA, map)) {
                            Expression nextX = map.get(x);
                            if (nextX.equals(new Next(x))) {
                                map = new HashMap<>();
                                if (checkMatches(A, llPart, map)) {
                                    Expression zero = map.get(x);
                                    if (zero.equals(new Zero())) {
                                        add(toCheck);
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    // A -> B =>  A -> @xB ; x не входит свободно в A
    private boolean ruleAny(Expression toCheck) {
        if (toCheck.isImplication()) {
            Expression rightPart = toCheck.asBinary().getRight();
            if (rightPart.isAny()) {
                Expression leftPart = toCheck.asBinary().getLeft();
                Set<String> free = freeVars(leftPart, new HashSet<>());
                if (free.contains(rightPart.asQuantifier().getVariable().print())) {
                    return false;
                }
                Expression expr = rightPart.asQuantifier().getExpression();
                Implication impl = new Implication(toCheck.asBinary().getLeft(), expr);
                if (provedExpr.contains(impl)) {
                    add(toCheck);
                    return true;
                }
            }
        }
        return false;
    }

    // B -> A => ?xB -> A ; x не входит свободно в A
    private boolean ruleExists(Expression toCheck) {
        if (toCheck.isImplication()) {
            Expression leftPart = toCheck.asBinary().getLeft();
            if (leftPart.isExists()) {
                Expression rightPart = toCheck.asBinary().getRight();
                Set<String> free = freeVars(rightPart, new HashSet<>());
                if (free.contains(leftPart.asQuantifier().getVariable().print())) {
                    return false;
                }
                Expression expr = leftPart.asQuantifier().getExpression();
                Implication impl = new Implication(expr, toCheck.asBinary().getRight());
                if (provedExpr.contains(impl)) {
                    add(toCheck);
                    return true;
                }
            }
        }
        return false;
    }

    public void checkAll() {
        int index = -1;
        for (Expression p : proof) {
            if (checkHyp(p)) continue;
            if (checkAxiom(p)) continue;
            if (check11(p)) continue;
            if (check12(p)) continue;
            if (checkInduction(p)) continue;
            if (checkMP(p)) continue;
            if (ruleAny(p)) continue;
            if (ruleExists(p)) continue;

            index = proof.indexOf(p);
            break;
        }

        if (index != -1) {
            System.out.println("Line #" + (index + 1) + " can’t be obtained");
        } else if (!(proof.get(proof.size() - 1).equals(statement))) {
            System.out.println("Required hasn’t been proven");
        } else {
            System.out.println("Proof is correct");
        }
    }

}
