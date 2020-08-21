package expression;

public class Exists extends Quantifier {
    public Exists(Variable variable, Expression expression) { super(variable, expression, "?");
    }
}
