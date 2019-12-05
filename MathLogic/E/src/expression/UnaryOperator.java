package expression;

import static java.util.Objects.hash;

public abstract class UnaryOperator implements Expression {
    public Expression getExpression() {
        return expression;
    }

    private Expression expression;

    public String getOperator() {
        return operator;
    }

    private String operator;

    UnaryOperator(Expression expression, String operator){
        this.expression = expression;
        this.operator = operator;
    }

    @Override
    public String print() {
        return  operator + expression.print();
    }

    @Override
    public int hashCode() {
        return hash(expression, operator);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof UnaryOperator)) {
            return false;
        }

        UnaryOperator toCheck = ((Expression) obj).asUnary();

        return this.getOperator().equals(toCheck.getOperator()) &&
                this.expression.equals(toCheck.expression);
    }
}
