package expression;

public class Implication extends BinaryOperator {
    public Implication(Expression left, Expression right) {
        super(left, right, "->");
    }
}
