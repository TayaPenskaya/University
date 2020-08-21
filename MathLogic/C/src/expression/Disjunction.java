package expression;

public class Disjunction extends BinaryOperator {
    public Disjunction(Expression left, Expression right) {
        super(left, right, "|");
    }
}
