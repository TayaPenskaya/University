package expression;

public interface Expression {
    String print();

    default boolean isVariable() {
        return this instanceof Variable;
    }

    default boolean isUnary() {
        return this instanceof UnaryOperator;
    }
    default boolean isBinary() {
        return this instanceof BinaryOperator;
    }

    default boolean isImplication() {
        return this instanceof Implication;
    }

    default Variable asVariable() {
        return (Variable) this;
    }

    default UnaryOperator asUnary() {
        return (UnaryOperator) this;
    }

    default BinaryOperator asBinary() {
        return (BinaryOperator) this;
    }

    default Implication asImplication() {
        return (Implication) this;
    }
}
