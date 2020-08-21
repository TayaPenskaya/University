package provider;

import expression.*;

import java.util.*;

public class ProofProvider {

    private final Expression statement;
    private final List<Expression> hyps;
    private final List<Expression> proof;
    private final List<Expression> axioms = new AxiomsProvider().getAxioms();

    private final Map<Expression, List<Expression>> exprByRightPart = new HashMap<>();
    private final List<Expression> provedExpr = new ArrayList<>();
    private final List<Expression> ans = new ArrayList<>();

    public ProofProvider(Expression statement, List<Expression> hyps, List<Expression> proof) {
        this.statement = statement;
        this.hyps = hyps;
        this.proof = proof;
    }

    public Expression getNewStatement() {
        return getDoubleNegation(statement);
    }

    private Expression getDoubleNegation(Expression expression) {
        return new Negation(new Negation(expression));
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

    private Expression checkAxiom(Expression toCheck) {
        for (int i = 0; i < axioms.size(); ++i) {
            if (checkMatches(axioms.get(i), toCheck, new HashMap<>())) {
                if(i != 9){
                    deduceNegation(toCheck);
                    return toCheck;
                } else {
                    deduce10Axiom(toCheck);
                    return toCheck;
                }
            }
        }
        return null;
    }

    private Expression checkHyp(Expression toCheck) {
        for (int i = 0; i < hyps.size(); ++i) {
            if (hyps.get(i).equals(toCheck)) {
                return toCheck;
            }
        }
        return null;
    }

    private void checkMP(Expression toCheck) {
        List<Expression> byRightPart = exprByRightPart.get(toCheck);
        for (Expression from : byRightPart) {
            if (from.isImplication() && provedExpr.contains(from.asImplication().getLeft())) {
                deduceMP(from.asImplication().getLeft(), toCheck);
                updMP(toCheck);
            }
        }
    }

    private void updMP(Expression expression) {
        if (expression.isImplication()) {
            Expression rightPart = expression.asBinary().getRight();
            exprByRightPart.putIfAbsent(rightPart, new ArrayList<>());
            exprByRightPart.get(rightPart).add(expression);
        }
        provedExpr.add(expression);
    }

    public List<Expression> getProof() {
        for (Expression expression : proof) {

            Expression expr = checkHyp(expression);
            if (expr != null) {
                deduceNegation(expr);
                updMP(expr);
                continue;
            }

            expr = checkAxiom(expression);
            if (expr != null) {
                updMP(expr);
                continue;
            }

            checkMP(expression);

        }
        return ans;
    }


    private void deduceNegation(Expression expression) {
        ans.add(expression);
        ans.add(new Implication(expression, new Implication(new Negation(expression), expression)));
        ans.add(new Implication(new Negation(expression), expression));
        ans.add(new Implication(new Negation(expression), new Implication(new Negation(expression), new Negation(expression))));
        ans.add(new Implication(new Implication(new Negation(expression), new Implication(new Negation(expression), new Negation(expression))), new Implication(new Implication(new Negation(expression), new Implication(new Implication(new Negation(expression), new Negation(expression)), new Negation(expression))), new Implication(new Negation(expression), new Negation(expression)))));
        ans.add(new Implication(new Implication(new Negation(expression), new Implication(new Implication(new Negation(expression), new Negation(expression)), new Negation(expression))), new Implication(new Negation(expression), new Negation(expression))));
        ans.add(new Implication(new Negation(expression), new Implication(new Implication(new Negation(expression), new Negation(expression)), new Negation(expression))));
        ans.add(new Implication(new Negation(expression), new Negation(expression)));
        ans.add(new Implication(new Implication(new Negation(expression), expression), new Implication(new Implication(new Negation(expression), new Negation(expression)), getDoubleNegation(expression))));
        ans.add(new Implication(new Implication(new Negation(expression), new Negation(expression)), getDoubleNegation(expression)));
        ans.add(getDoubleNegation(expression));
    }


    private void deduce10Axiom(Expression expression) {
        Expression right = (expression.asImplication()).getRight();
        ans.add(new Implication(new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Negation(right)), new Implication(new Implication(new Negation(new Implication(getDoubleNegation(right), right)), getDoubleNegation(right)), getDoubleNegation(expression))));
        ans.add(new Implication(new Implication(right, new Implication(getDoubleNegation(right), right)), new Implication(new Implication(right, new Negation(new Implication(getDoubleNegation(right), right))), new Negation(right))));
        ans.add(new Implication(new Implication(new Implication(right, new Implication(getDoubleNegation(right), right)), new Implication(new Implication(right, new Negation(new Implication(getDoubleNegation(right), right))), new Negation(right))), new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Implication(new Implication(right, new Implication(getDoubleNegation(right), right)), new Implication(new Implication(right, new Negation(new Implication(getDoubleNegation(right), right))), new Negation(right))))));
        ans.add(new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Implication(new Implication(right, new Implication(getDoubleNegation(right), right)), new Implication(new Implication(right, new Negation(new Implication(getDoubleNegation(right), right))), new Negation(right)))));
        ans.add(new Implication(right, new Implication(getDoubleNegation(right), right)));
        ans.add(new Implication(new Implication(right, new Implication(getDoubleNegation(right), right)), new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Implication(right, new Implication(getDoubleNegation(right), right)))));
        ans.add(new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Implication(right, new Implication(getDoubleNegation(right), right))));
        ans.add(new Implication(new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Implication(right, new Implication(getDoubleNegation(right), right))), new Implication(new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Implication(new Implication(right, new Implication(getDoubleNegation(right), right)), new Implication(new Implication(right, new Negation(new Implication(getDoubleNegation(right), right))), new Negation(right)))), new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Implication(new Implication(right, new Negation(new Implication(getDoubleNegation(right), right))), new Negation(right))))));
        ans.add(new Implication(new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Implication(new Implication(right, new Implication(getDoubleNegation(right), right)), new Implication(new Implication(right, new Negation(new Implication(getDoubleNegation(right), right))), new Negation(right)))), new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Implication(new Implication(right, new Negation(new Implication(getDoubleNegation(right), right))), new Negation(right)))));
        ans.add(new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Implication(new Implication(right, new Negation(new Implication(getDoubleNegation(right), right))), new Negation(right))));
        ans.add(new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Negation(new Implication(getDoubleNegation(right), right)))));
        ans.add(new Implication(new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Negation(new Implication(getDoubleNegation(right), right)))), new Implication(new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Implication(new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Negation(new Implication(getDoubleNegation(right), right))), new Negation(new Implication(getDoubleNegation(right), right)))), new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Negation(new Implication(getDoubleNegation(right), right))))));
        ans.add(new Implication(new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Implication(new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Negation(new Implication(getDoubleNegation(right), right))), new Negation(new Implication(getDoubleNegation(right), right)))), new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Negation(new Implication(getDoubleNegation(right), right)))));
        ans.add(new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Implication(new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Negation(new Implication(getDoubleNegation(right), right))), new Negation(new Implication(getDoubleNegation(right), right)))));
        ans.add(new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Negation(new Implication(getDoubleNegation(right), right))));
        ans.add(new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Implication(right, new Negation(new Implication(getDoubleNegation(right), right)))));
        ans.add(new Implication(new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Implication(right, new Negation(new Implication(getDoubleNegation(right), right)))), new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Implication(right, new Negation(new Implication(getDoubleNegation(right), right)))))));
        ans.add(new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Implication(right, new Negation(new Implication(getDoubleNegation(right), right))))));
        ans.add(new Implication(new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Negation(new Implication(getDoubleNegation(right), right))), new Implication(new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Implication(right, new Negation(new Implication(getDoubleNegation(right), right))))), new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Implication(right, new Negation(new Implication(getDoubleNegation(right), right)))))));
        ans.add(new Implication(new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Implication(right, new Negation(new Implication(getDoubleNegation(right), right))))), new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Implication(right, new Negation(new Implication(getDoubleNegation(right), right))))));
        ans.add(new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Implication(right, new Negation(new Implication(getDoubleNegation(right), right)))));
        ans.add(new Implication(new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Implication(right, new Negation(new Implication(getDoubleNegation(right), right)))), new Implication(new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Implication(new Implication(right, new Negation(new Implication(getDoubleNegation(right), right))), new Negation(right))), new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Negation(right)))));
        ans.add(new Implication(new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Implication(new Implication(right, new Negation(new Implication(getDoubleNegation(right), right))), new Negation(right))), new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Negation(right))));
        ans.add(new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Negation(right)));
        ans.add(new Implication(new Implication(new Negation(right), new Implication(getDoubleNegation(right), right)), new Implication(new Implication(new Negation(right), new Negation(new Implication(getDoubleNegation(right), right))), getDoubleNegation(right))));
        ans.add(new Implication(new Implication(new Implication(new Negation(right), new Implication(getDoubleNegation(right), right)), new Implication(new Implication(new Negation(right), new Negation(new Implication(getDoubleNegation(right), right))), getDoubleNegation(right))), new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Implication(new Implication(new Negation(right), new Implication(getDoubleNegation(right), right)), new Implication(new Implication(new Negation(right), new Negation(new Implication(getDoubleNegation(right), right))), getDoubleNegation(right))))));
        ans.add(new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Implication(new Implication(new Negation(right), new Implication(getDoubleNegation(right), right)), new Implication(new Implication(new Negation(right), new Negation(new Implication(getDoubleNegation(right), right))), getDoubleNegation(right)))));
        ans.add(new Implication(new Negation(right), new Implication(getDoubleNegation(right), right)));
        ans.add(new Implication(new Implication(new Negation(right), new Implication(getDoubleNegation(right), right)), new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Implication(new Negation(right), new Implication(getDoubleNegation(right), right)))));
        ans.add(new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Implication(new Negation(right), new Implication(getDoubleNegation(right), right))));
        ans.add(new Implication(new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Implication(new Negation(right), new Implication(getDoubleNegation(right), right))), new Implication(new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Implication(new Implication(new Negation(right), new Implication(getDoubleNegation(right), right)), new Implication(new Implication(new Negation(right), new Negation(new Implication(getDoubleNegation(right), right))), getDoubleNegation(right)))), new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Implication(new Implication(new Negation(right), new Negation(new Implication(getDoubleNegation(right), right))), getDoubleNegation(right))))));
        ans.add(new Implication(new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Implication(new Implication(new Negation(right), new Implication(getDoubleNegation(right), right)), new Implication(new Implication(new Negation(right), new Negation(new Implication(getDoubleNegation(right), right))), getDoubleNegation(right)))), new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Implication(new Implication(new Negation(right), new Negation(new Implication(getDoubleNegation(right), right))), getDoubleNegation(right)))));
        ans.add(new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Implication(new Implication(new Negation(right), new Negation(new Implication(getDoubleNegation(right), right))), getDoubleNegation(right))));
        ans.add(new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Negation(new Implication(getDoubleNegation(right), right)))));
        ans.add(new Implication(new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Negation(new Implication(getDoubleNegation(right), right)))), new Implication(new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Implication(new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Negation(new Implication(getDoubleNegation(right), right))), new Negation(new Implication(getDoubleNegation(right), right)))), new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Negation(new Implication(getDoubleNegation(right), right))))));
        ans.add(new Implication(new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Implication(new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Negation(new Implication(getDoubleNegation(right), right))), new Negation(new Implication(getDoubleNegation(right), right)))), new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Negation(new Implication(getDoubleNegation(right), right)))));
        ans.add(new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Implication(new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Negation(new Implication(getDoubleNegation(right), right))), new Negation(new Implication(getDoubleNegation(right), right)))));
        ans.add(new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Negation(new Implication(getDoubleNegation(right), right))));
        ans.add(new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Implication(new Negation(right), new Negation(new Implication(getDoubleNegation(right), right)))));
        ans.add(new Implication(new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Implication(new Negation(right), new Negation(new Implication(getDoubleNegation(right), right)))), new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Implication(new Negation(right), new Negation(new Implication(getDoubleNegation(right), right)))))));
        ans.add(new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Implication(new Negation(right), new Negation(new Implication(getDoubleNegation(right), right))))));
        ans.add(new Implication(new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Negation(new Implication(getDoubleNegation(right), right))), new Implication(new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Implication(new Negation(right), new Negation(new Implication(getDoubleNegation(right), right))))), new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Implication(new Negation(right), new Negation(new Implication(getDoubleNegation(right), right)))))));
        ans.add(new Implication(new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Implication(new Negation(right), new Negation(new Implication(getDoubleNegation(right), right))))), new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Implication(new Negation(right), new Negation(new Implication(getDoubleNegation(right), right))))));
        ans.add(new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Implication(new Negation(right), new Negation(new Implication(getDoubleNegation(right), right)))));
        ans.add(new Implication(new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Implication(new Negation(right), new Negation(new Implication(getDoubleNegation(right), right)))), new Implication(new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Implication(new Implication(new Negation(right), new Negation(new Implication(getDoubleNegation(right), right))), getDoubleNegation(right))), new Implication(new Negation(new Implication(getDoubleNegation(right), right)), getDoubleNegation(right)))));
        ans.add(new Implication(new Implication(new Negation(new Implication(getDoubleNegation(right), right)), new Implication(new Implication(new Negation(right), new Negation(new Implication(getDoubleNegation(right), right))), getDoubleNegation(right))), new Implication(new Negation(new Implication(getDoubleNegation(right), right)), getDoubleNegation(right))));
        ans.add(new Implication(new Negation(new Implication(getDoubleNegation(right), right)), getDoubleNegation(right)));
        ans.add(new Implication(new Implication(new Negation(new Implication(getDoubleNegation(right), right)), getDoubleNegation(right)), getDoubleNegation(expression)));
        ans.add(getDoubleNegation(expression));
    }

    private void deduceMP(Expression A, Expression B) {         //!!A,!!(A->B)|-!!B
        ans.add(getDoubleNegation(new Implication(A, B)));
        ans.add(new Implication(new Negation(B), new Implication(new Implication(A, B), new Negation(B))));
        ans.add(new Implication(new Negation(B), new Implication(A, new Negation(B))));
        ans.add(new Implication(new Implication(new Negation(B), new Implication(A, new Negation(B))), new Implication(new Negation(B), new Implication(new Negation(B), new Implication(A, new Negation(B))))));
        ans.add(new Implication(new Negation(B), new Implication(new Negation(B), new Implication(A, new Negation(B)))));
        ans.add(new Implication(new Implication(new Negation(B), new Implication(A, new Negation(B))), new Implication(new Implication(A, B), new Implication(new Negation(B), new Implication(A, new Negation(B))))));
        ans.add(new Implication(new Implication(new Implication(new Negation(B), new Implication(A, new Negation(B))), new Implication(new Implication(A, B), new Implication(new Negation(B), new Implication(A, new Negation(B))))), new Implication(new Negation(B), new Implication(new Implication(new Negation(B), new Implication(A, new Negation(B))), new Implication(new Implication(A, B), new Implication(new Negation(B), new Implication(A, new Negation(B))))))));
        ans.add(new Implication(new Negation(B), new Implication(new Implication(new Negation(B), new Implication(A, new Negation(B))), new Implication(new Implication(A, B), new Implication(new Negation(B), new Implication(A, new Negation(B)))))));
        ans.add(new Implication(new Implication(new Negation(B), new Implication(new Negation(B), new Implication(A, new Negation(B)))), new Implication(new Implication(new Negation(B), new Implication(new Implication(new Negation(B), new Implication(A, new Negation(B))), new Implication(new Implication(A, B), new Implication(new Negation(B), new Implication(A, new Negation(B)))))), new Implication(new Negation(B), new Implication(new Implication(A, B), new Implication(new Negation(B), new Implication(A, new Negation(B))))))));
        ans.add(new Implication(new Implication(new Negation(B), new Implication(new Implication(new Negation(B), new Implication(A, new Negation(B))), new Implication(new Implication(A, B), new Implication(new Negation(B), new Implication(A, new Negation(B)))))), new Implication(new Negation(B), new Implication(new Implication(A, B), new Implication(new Negation(B), new Implication(A, new Negation(B)))))));
        ans.add(new Implication(new Negation(B), new Implication(new Implication(A, B), new Implication(new Negation(B), new Implication(A, new Negation(B))))));
        ans.add(new Implication(new Implication(new Implication(A, B), new Negation(B)), new Implication(new Implication(new Implication(A, B), new Implication(new Negation(B), new Implication(A, new Negation(B)))), new Implication(new Implication(A, B), new Implication(A, new Negation(B))))));
        ans.add(new Implication(new Implication(new Implication(new Implication(A, B), new Negation(B)), new Implication(new Implication(new Implication(A, B), new Implication(new Negation(B), new Implication(A, new Negation(B)))), new Implication(new Implication(A, B), new Implication(A, new Negation(B))))), new Implication(new Negation(B), new Implication(new Implication(new Implication(A, B), new Negation(B)), new Implication(new Implication(new Implication(A, B), new Implication(new Negation(B), new Implication(A, new Negation(B)))), new Implication(new Implication(A, B), new Implication(A, new Negation(B))))))));
        ans.add(new Implication(new Negation(B), new Implication(new Implication(new Implication(A, B), new Negation(B)), new Implication(new Implication(new Implication(A, B), new Implication(new Negation(B), new Implication(A, new Negation(B)))), new Implication(new Implication(A, B), new Implication(A, new Negation(B)))))));
        ans.add(new Implication(new Implication(new Negation(B), new Implication(new Implication(A, B), new Negation(B))), new Implication(new Implication(new Negation(B), new Implication(new Implication(new Implication(A, B), new Negation(B)), new Implication(new Implication(new Implication(A, B), new Implication(new Negation(B), new Implication(A, new Negation(B)))), new Implication(new Implication(A, B), new Implication(A, new Negation(B)))))), new Implication(new Negation(B), new Implication(new Implication(new Implication(A, B), new Implication(new Negation(B), new Implication(A, new Negation(B)))), new Implication(new Implication(A, B), new Implication(A, new Negation(B))))))));
        ans.add(new Implication(new Implication(new Negation(B), new Implication(new Implication(new Implication(A, B), new Negation(B)), new Implication(new Implication(new Implication(A, B), new Implication(new Negation(B), new Implication(A, new Negation(B)))), new Implication(new Implication(A, B), new Implication(A, new Negation(B)))))), new Implication(new Negation(B), new Implication(new Implication(new Implication(A, B), new Implication(new Negation(B), new Implication(A, new Negation(B)))), new Implication(new Implication(A, B), new Implication(A, new Negation(B)))))));
        ans.add(new Implication(new Negation(B), new Implication(new Implication(new Implication(A, B), new Implication(new Negation(B), new Implication(A, new Negation(B)))), new Implication(new Implication(A, B), new Implication(A, new Negation(B))))));
        ans.add(new Implication(new Implication(new Negation(B), new Implication(new Implication(A, B), new Implication(new Negation(B), new Implication(A, new Negation(B))))), new Implication(new Implication(new Negation(B), new Implication(new Implication(new Implication(A, B), new Implication(new Negation(B), new Implication(A, new Negation(B)))), new Implication(new Implication(A, B), new Implication(A, new Negation(B))))), new Implication(new Negation(B), new Implication(new Implication(A, B), new Implication(A, new Negation(B)))))));
        ans.add(new Implication(new Implication(new Negation(B), new Implication(new Implication(new Implication(A, B), new Implication(new Negation(B), new Implication(A, new Negation(B)))), new Implication(new Implication(A, B), new Implication(A, new Negation(B))))), new Implication(new Negation(B), new Implication(new Implication(A, B), new Implication(A, new Negation(B))))));
        ans.add(new Implication(new Negation(B), new Implication(new Implication(A, B), new Implication(A, new Negation(B)))));
        ans.add(new Implication(new Implication(A, B), new Implication(new Implication(A, new Negation(B)), new Negation(A))));
        ans.add(new Implication(new Implication(new Implication(A, B), new Implication(new Implication(A, new Negation(B)), new Negation(A))), new Implication(new Negation(B), new Implication(new Implication(A, B), new Implication(new Implication(A, new Negation(B)), new Negation(A))))));
        ans.add(new Implication(new Negation(B), new Implication(new Implication(A, B), new Implication(new Implication(A, new Negation(B)), new Negation(A)))));
        ans.add(new Implication(new Implication(new Implication(A, B), new Implication(A, new Negation(B))), new Implication(new Implication(new Implication(A, B), new Implication(new Implication(A, new Negation(B)), new Negation(A))), new Implication(new Implication(A, B), new Negation(A)))));
        ans.add(new Implication(new Implication(new Implication(new Implication(A, B), new Implication(A, new Negation(B))), new Implication(new Implication(new Implication(A, B), new Implication(new Implication(A, new Negation(B)), new Negation(A))), new Implication(new Implication(A, B), new Negation(A)))), new Implication(new Negation(B), new Implication(new Implication(new Implication(A, B), new Implication(A, new Negation(B))), new Implication(new Implication(new Implication(A, B), new Implication(new Implication(A, new Negation(B)), new Negation(A))), new Implication(new Implication(A, B), new Negation(A)))))));
        ans.add(new Implication(new Negation(B), new Implication(new Implication(new Implication(A, B), new Implication(A, new Negation(B))), new Implication(new Implication(new Implication(A, B), new Implication(new Implication(A, new Negation(B)), new Negation(A))), new Implication(new Implication(A, B), new Negation(A))))));
        ans.add(new Implication(new Implication(new Negation(B), new Implication(new Implication(A, B), new Implication(A, new Negation(B)))), new Implication(new Implication(new Negation(B), new Implication(new Implication(new Implication(A, B), new Implication(A, new Negation(B))), new Implication(new Implication(new Implication(A, B), new Implication(new Implication(A, new Negation(B)), new Negation(A))), new Implication(new Implication(A, B), new Negation(A))))), new Implication(new Negation(B), new Implication(new Implication(new Implication(A, B), new Implication(new Implication(A, new Negation(B)), new Negation(A))), new Implication(new Implication(A, B), new Negation(A)))))));
        ans.add(new Implication(new Implication(new Negation(B), new Implication(new Implication(new Implication(A, B), new Implication(A, new Negation(B))), new Implication(new Implication(new Implication(A, B), new Implication(new Implication(A, new Negation(B)), new Negation(A))), new Implication(new Implication(A, B), new Negation(A))))), new Implication(new Negation(B), new Implication(new Implication(new Implication(A, B), new Implication(new Implication(A, new Negation(B)), new Negation(A))), new Implication(new Implication(A, B), new Negation(A))))));
        ans.add(new Implication(new Negation(B), new Implication(new Implication(new Implication(A, B), new Implication(new Implication(A, new Negation(B)), new Negation(A))), new Implication(new Implication(A, B), new Negation(A)))));
        ans.add(new Implication(new Implication(new Negation(B), new Implication(new Implication(A, B), new Implication(new Implication(A, new Negation(B)), new Negation(A)))), new Implication(new Implication(new Negation(B), new Implication(new Implication(new Implication(A, B), new Implication(new Implication(A, new Negation(B)), new Negation(A))), new Implication(new Implication(A, B), new Negation(A)))), new Implication(new Negation(B), new Implication(new Implication(A, B), new Negation(A))))));
        ans.add(new Implication(new Implication(new Negation(B), new Implication(new Implication(new Implication(A, B), new Implication(new Implication(A, new Negation(B)), new Negation(A))), new Implication(new Implication(A, B), new Negation(A)))), new Implication(new Negation(B), new Implication(new Implication(A, B), new Negation(A)))));
        ans.add(new Implication(new Negation(B), new Implication(new Implication(A, B), new Negation(A))));
        ans.add(getDoubleNegation(A));
        ans.add(new Implication(getDoubleNegation(A), new Implication(new Negation(B), getDoubleNegation(A))));
        ans.add(new Implication(new Negation(B), getDoubleNegation(A)));
        ans.add(new Implication(getDoubleNegation(A), new Implication(new Implication(A, B), getDoubleNegation(A))));
        ans.add(new Implication(new Implication(getDoubleNegation(A), new Implication(new Implication(A, B), getDoubleNegation(A))), new Implication(new Negation(B), new Implication(getDoubleNegation(A), new Implication(new Implication(A, B), getDoubleNegation(A))))));
        ans.add(new Implication(new Negation(B), new Implication(getDoubleNegation(A), new Implication(new Implication(A, B), getDoubleNegation(A)))));
        ans.add(new Implication(new Implication(new Negation(B), getDoubleNegation(A)), new Implication(new Implication(new Negation(B), new Implication(getDoubleNegation(A), new Implication(new Implication(A, B), getDoubleNegation(A)))), new Implication(new Negation(B), new Implication(new Implication(A, B), getDoubleNegation(A))))));
        ans.add(new Implication(new Implication(new Negation(B), new Implication(getDoubleNegation(A), new Implication(new Implication(A, B), getDoubleNegation(A)))), new Implication(new Negation(B), new Implication(new Implication(A, B), getDoubleNegation(A)))));
        ans.add(new Implication(new Negation(B), new Implication(new Implication(A, B), getDoubleNegation(A))));
        ans.add(new Implication(new Negation(A), new Implication(getDoubleNegation(A), B)));
        ans.add(new Implication(new Implication(new Negation(A), new Implication(getDoubleNegation(A), B)), new Implication(new Negation(B), new Implication(new Negation(A), new Implication(getDoubleNegation(A), B)))));
        ans.add(new Implication(new Negation(B), new Implication(new Negation(A), new Implication(getDoubleNegation(A), B))));
        ans.add(new Implication(new Implication(new Negation(A), new Implication(getDoubleNegation(A), B)), new Implication(new Implication(A, B), new Implication(new Negation(A), new Implication(getDoubleNegation(A), B)))));
        ans.add(new Implication(new Implication(new Implication(new Negation(A), new Implication(getDoubleNegation(A), B)), new Implication(new Implication(A, B), new Implication(new Negation(A), new Implication(getDoubleNegation(A), B)))), new Implication(new Negation(B), new Implication(new Implication(new Negation(A), new Implication(getDoubleNegation(A), B)), new Implication(new Implication(A, B), new Implication(new Negation(A), new Implication(getDoubleNegation(A), B)))))));
        ans.add(new Implication(new Negation(B), new Implication(new Implication(new Negation(A), new Implication(getDoubleNegation(A), B)), new Implication(new Implication(A, B), new Implication(new Negation(A), new Implication(getDoubleNegation(A), B))))));
        ans.add(new Implication(new Implication(new Negation(B), new Implication(new Negation(A), new Implication(getDoubleNegation(A), B))), new Implication(new Implication(new Negation(B), new Implication(new Implication(new Negation(A), new Implication(getDoubleNegation(A), B)), new Implication(new Implication(A, B), new Implication(new Negation(A), new Implication(getDoubleNegation(A), B))))), new Implication(new Negation(B), new Implication(new Implication(A, B), new Implication(new Negation(A), new Implication(getDoubleNegation(A), B)))))));
        ans.add(new Implication(new Implication(new Negation(B), new Implication(new Implication(new Negation(A), new Implication(getDoubleNegation(A), B)), new Implication(new Implication(A, B), new Implication(new Negation(A), new Implication(getDoubleNegation(A), B))))), new Implication(new Negation(B), new Implication(new Implication(A, B), new Implication(new Negation(A), new Implication(getDoubleNegation(A), B))))));
        ans.add(new Implication(new Negation(B), new Implication(new Implication(A, B), new Implication(new Negation(A), new Implication(getDoubleNegation(A), B)))));
        ans.add(new Implication(new Implication(new Implication(A, B), new Negation(A)), new Implication(new Implication(new Implication(A, B), new Implication(new Negation(A), new Implication(getDoubleNegation(A), B))), new Implication(new Implication(A, B), new Implication(getDoubleNegation(A), B)))));
        ans.add(new Implication(new Implication(new Implication(new Implication(A, B), new Negation(A)), new Implication(new Implication(new Implication(A, B), new Implication(new Negation(A), new Implication(getDoubleNegation(A), B))), new Implication(new Implication(A, B), new Implication(getDoubleNegation(A), B)))), new Implication(new Negation(B), new Implication(new Implication(new Implication(A, B), new Negation(A)), new Implication(new Implication(new Implication(A, B), new Implication(new Negation(A), new Implication(getDoubleNegation(A), B))), new Implication(new Implication(A, B), new Implication(getDoubleNegation(A), B)))))));
        ans.add(new Implication(new Negation(B), new Implication(new Implication(new Implication(A, B), new Negation(A)), new Implication(new Implication(new Implication(A, B), new Implication(new Negation(A), new Implication(getDoubleNegation(A), B))), new Implication(new Implication(A, B), new Implication(getDoubleNegation(A), B))))));
        ans.add(new Implication(new Implication(new Negation(B), new Implication(new Implication(A, B), new Negation(A))), new Implication(new Implication(new Negation(B), new Implication(new Implication(new Implication(A, B), new Negation(A)), new Implication(new Implication(new Implication(A, B), new Implication(new Negation(A), new Implication(getDoubleNegation(A), B))), new Implication(new Implication(A, B), new Implication(getDoubleNegation(A), B))))), new Implication(new Negation(B), new Implication(new Implication(new Implication(A, B), new Implication(new Negation(A), new Implication(getDoubleNegation(A), B))), new Implication(new Implication(A, B), new Implication(getDoubleNegation(A), B)))))));
        ans.add(new Implication(new Implication(new Negation(B), new Implication(new Implication(new Implication(A, B), new Negation(A)), new Implication(new Implication(new Implication(A, B), new Implication(new Negation(A), new Implication(getDoubleNegation(A), B))), new Implication(new Implication(A, B), new Implication(getDoubleNegation(A), B))))), new Implication(new Negation(B), new Implication(new Implication(new Implication(A, B), new Implication(new Negation(A), new Implication(getDoubleNegation(A), B))), new Implication(new Implication(A, B), new Implication(getDoubleNegation(A), B))))));
        ans.add(new Implication(new Negation(B), new Implication(new Implication(new Implication(A, B), new Implication(new Negation(A), new Implication(getDoubleNegation(A), B))), new Implication(new Implication(A, B), new Implication(getDoubleNegation(A), B)))));
        ans.add(new Implication(new Implication(new Negation(B), new Implication(new Implication(A, B), new Implication(new Negation(A), new Implication(getDoubleNegation(A), B)))), new Implication(new Implication(new Negation(B), new Implication(new Implication(new Implication(A, B), new Implication(new Negation(A), new Implication(getDoubleNegation(A), B))), new Implication(new Implication(A, B), new Implication(getDoubleNegation(A), B)))), new Implication(new Negation(B), new Implication(new Implication(A, B), new Implication(getDoubleNegation(A), B))))));
        ans.add(new Implication(new Implication(new Negation(B), new Implication(new Implication(new Implication(A, B), new Implication(new Negation(A), new Implication(getDoubleNegation(A), B))), new Implication(new Implication(A, B), new Implication(getDoubleNegation(A), B)))), new Implication(new Negation(B), new Implication(new Implication(A, B), new Implication(getDoubleNegation(A), B)))));
        ans.add(new Implication(new Negation(B), new Implication(new Implication(A, B), new Implication(getDoubleNegation(A), B))));
        ans.add(new Implication(new Implication(new Implication(A, B), getDoubleNegation(A)), new Implication(new Implication(new Implication(A, B), new Implication(getDoubleNegation(A), B)), new Implication(new Implication(A, B), B))));
        ans.add(new Implication(new Implication(new Implication(new Implication(A, B), getDoubleNegation(A)), new Implication(new Implication(new Implication(A, B), new Implication(getDoubleNegation(A), B)), new Implication(new Implication(A, B), B))), new Implication(new Negation(B), new Implication(new Implication(new Implication(A, B), getDoubleNegation(A)), new Implication(new Implication(new Implication(A, B), new Implication(getDoubleNegation(A), B)), new Implication(new Implication(A, B), B))))));
        ans.add(new Implication(new Negation(B), new Implication(new Implication(new Implication(A, B), getDoubleNegation(A)), new Implication(new Implication(new Implication(A, B), new Implication(getDoubleNegation(A), B)), new Implication(new Implication(A, B), B)))));
        ans.add(new Implication(new Implication(new Negation(B), new Implication(new Implication(A, B), getDoubleNegation(A))), new Implication(new Implication(new Negation(B), new Implication(new Implication(new Implication(A, B), getDoubleNegation(A)), new Implication(new Implication(new Implication(A, B), new Implication(getDoubleNegation(A), B)), new Implication(new Implication(A, B), B)))), new Implication(new Negation(B), new Implication(new Implication(new Implication(A, B), new Implication(getDoubleNegation(A), B)), new Implication(new Implication(A, B), B))))));
        ans.add(new Implication(new Implication(new Negation(B), new Implication(new Implication(new Implication(A, B), getDoubleNegation(A)), new Implication(new Implication(new Implication(A, B), new Implication(getDoubleNegation(A), B)), new Implication(new Implication(A, B), B)))), new Implication(new Negation(B), new Implication(new Implication(new Implication(A, B), new Implication(getDoubleNegation(A), B)), new Implication(new Implication(A, B), B)))));
        ans.add(new Implication(new Negation(B), new Implication(new Implication(new Implication(A, B), new Implication(getDoubleNegation(A), B)), new Implication(new Implication(A, B), B))));
        ans.add(new Implication(new Implication(new Negation(B), new Implication(new Implication(A, B), new Implication(getDoubleNegation(A), B))), new Implication(new Implication(new Negation(B), new Implication(new Implication(new Implication(A, B), new Implication(getDoubleNegation(A), B)), new Implication(new Implication(A, B), B))), new Implication(new Negation(B), new Implication(new Implication(A, B), B)))));
        ans.add(new Implication(new Implication(new Negation(B), new Implication(new Implication(new Implication(A, B), new Implication(getDoubleNegation(A), B)), new Implication(new Implication(A, B), B))), new Implication(new Negation(B), new Implication(new Implication(A, B), B))));
        ans.add(new Implication(new Negation(B), new Implication(new Implication(A, B), B)));
        ans.add(new Implication(new Implication(new Implication(A, B), B), new Implication(new Implication(new Implication(A, B), new Negation(B)), new Negation(new Implication(A, B)))));
        ans.add(new Implication(new Implication(new Implication(new Implication(A, B), B), new Implication(new Implication(new Implication(A, B), new Negation(B)), new Negation(new Implication(A, B)))), new Implication(new Negation(B), new Implication(new Implication(new Implication(A, B), B), new Implication(new Implication(new Implication(A, B), new Negation(B)), new Negation(new Implication(A, B)))))));
        ans.add(new Implication(new Negation(B), new Implication(new Implication(new Implication(A, B), B), new Implication(new Implication(new Implication(A, B), new Negation(B)), new Negation(new Implication(A, B))))));
        ans.add(new Implication(new Implication(new Negation(B), new Implication(new Implication(A, B), B)), new Implication(new Implication(new Negation(B), new Implication(new Implication(new Implication(A, B), B), new Implication(new Implication(new Implication(A, B), new Negation(B)), new Negation(new Implication(A, B))))), new Implication(new Negation(B), new Implication(new Implication(new Implication(A, B), new Negation(B)), new Negation(new Implication(A, B)))))));
        ans.add(new Implication(new Implication(new Negation(B), new Implication(new Implication(new Implication(A, B), B), new Implication(new Implication(new Implication(A, B), new Negation(B)), new Negation(new Implication(A, B))))), new Implication(new Negation(B), new Implication(new Implication(new Implication(A, B), new Negation(B)), new Negation(new Implication(A, B))))));
        ans.add(new Implication(new Negation(B), new Implication(new Implication(new Implication(A, B), new Negation(B)), new Negation(new Implication(A, B)))));
        ans.add(new Implication(new Implication(new Negation(B), new Implication(new Implication(A, B), new Negation(B))), new Implication(new Implication(new Negation(B), new Implication(new Implication(new Implication(A, B), new Negation(B)), new Negation(new Implication(A, B)))), new Implication(new Negation(B), new Negation(new Implication(A, B))))));
        ans.add(new Implication(new Implication(new Negation(B), new Implication(new Implication(new Implication(A, B), new Negation(B)), new Negation(new Implication(A, B)))), new Implication(new Negation(B), new Negation(new Implication(A, B)))));
        ans.add(new Implication(new Negation(B), new Negation(new Implication(A, B))));
        ans.add(new Implication(getDoubleNegation(new Implication(A, B)), new Implication(new Negation(B), getDoubleNegation(new Implication(A, B)))));
        ans.add(new Implication(new Negation(B), getDoubleNegation(new Implication(A, B))));
        ans.add(new Implication(new Implication(new Negation(B), new Negation(new Implication(A, B))), new Implication(new Implication(new Negation(B), getDoubleNegation(new Implication(A, B))), getDoubleNegation(B))));
        ans.add(new Implication(new Implication(new Negation(B), getDoubleNegation(new Implication(A, B))), getDoubleNegation(B)));
        ans.add(getDoubleNegation(B));
    }


}
