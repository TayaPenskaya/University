package expression;

public class Eq extends BinaryOperator {
    public Eq(Expression left, Expression right) {
        super(left, right, "=");
    }
}
