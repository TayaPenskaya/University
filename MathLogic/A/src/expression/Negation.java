package expression;

public class Negation extends UnaryOperator {
    public Negation(Expression body) {
        super(body, "!");
    }
}
