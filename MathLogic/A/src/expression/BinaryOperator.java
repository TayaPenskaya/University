package expression;

public abstract class BinaryOperator implements Expression{
    public Expression left;
    public Expression right;
    public String operator;

    BinaryOperator(Expression left, Expression right, String operator){
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    Expression getLeft(BinaryOperator binaryOperator){
        return binaryOperator.left;
    }

    Expression getRight(BinaryOperator binaryOperator){
        return  binaryOperator.right;
    }

    @Override
    public String print() {
        return '(' + operator + ',' + left.print() + ',' + right.print() + ')';
    }
}
