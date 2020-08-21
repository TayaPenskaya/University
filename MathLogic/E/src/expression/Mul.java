package expression;

public class Mul extends BinaryOperator {
    public Mul(Expression left, Expression right) {
        super(left, right, "*");
    }
}
