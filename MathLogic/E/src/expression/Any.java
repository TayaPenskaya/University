package expression;

public class Any extends Quantifier {

    public Any(Variable variable, Expression expression) {
        super(variable, expression, "@");
    }
}
