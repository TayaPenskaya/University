package expression;

import static java.util.Objects.hash;

public abstract class Quantifier implements Expression {

    private Expression expression;
    private Variable variable;
    private String quantifier;

    public Quantifier(Variable variable, Expression expression, String quantifier) {
        this.variable = variable;
        this.expression = expression;
        this.quantifier = quantifier;
    }

    public Expression getExpression() {
        return this.expression;
    }

    public Variable getVariable() {
        return this.variable;
    }

    public String getQuantifier() { return this.quantifier; }

    @Override
    public String print() {
        return quantifier + variable.print() + "." + expression.print();
    }

    @Override
    public int hashCode() {
        return hash(expression, variable, quantifier);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Quantifier)) {
            return false;
        }

        Quantifier toCheck = ((Expression) obj).asQuantifier();

        return this.getExpression().equals(toCheck.getExpression()) && this.getVariable().equals(toCheck.getVariable()) &&
                this.getQuantifier().equals(toCheck.getQuantifier());
    }
}
