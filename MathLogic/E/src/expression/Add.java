package expression;

public class Add extends BinaryOperator {
    public Add(Expression left, Expression right) {
        super(left, right, "+");
    }
}
