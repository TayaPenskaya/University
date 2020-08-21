package expression;

public class Conjunction extends BinaryOperator{
    public Conjunction(Expression left, Expression right) {
        super(left, right, "&");
    }
}
