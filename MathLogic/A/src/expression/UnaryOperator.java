package expression;

public abstract class UnaryOperator implements Expression {
    public Expression body;
    public String operator;

    UnaryOperator(Expression body, String operator){
        this.body = body;
        this.operator = operator;
    }

    @Override
    public String print() {
        return '(' + operator + body.print() + ')';
    }
}
