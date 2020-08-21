package expression;

import static java.util.Objects.hash;

public abstract class BinaryOperator implements Expression {
    private Expression left;
    private Expression right;
    private String operator;

    BinaryOperator(Expression left, Expression right, String operator) {
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    public Expression getLeft() {
        return this.left;
    }

    public Expression getRight() {
        return this.right;
    }

    public String getOperator() {
        return operator;
    }

    @Override
    public String print() {
        return '(' + left.print() + " " + getOperator() + " " + right.print() + ')';
    }

    @Override
    public int hashCode() {
        return hash(left, right, operator);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof BinaryOperator)) {
            return false;
        }

        BinaryOperator toCheck = ((Expression) obj).asBinary();

        return this.getOperator().equals(toCheck.getOperator()) &&
                this.getRight().equals(toCheck.getRight()) &&
                this.getLeft().equals(toCheck.getLeft());
    }
}
