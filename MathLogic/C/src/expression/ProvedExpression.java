package expression;

public class ProvedExpression implements Expression {
    public Expression getExpression() {
        return expression;
    }

    public Proof getProof() {
        return proof;
    }

    private Expression expression;
    private Proof proof;

    public ProvedExpression(Expression expression, Proof proof) {
        this.expression = expression;
        this.proof = proof;
    }

    @Override
    public String print() {
        return proof.get() + " " + expression.print();
    }
}
