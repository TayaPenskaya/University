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

    default boolean isConjunction() { return  this instanceof Conjunction; }

    default boolean isFoo() {
        return this instanceof Foo;
    }

    default boolean isQuantifier() {
        return this instanceof Quantifier;
    }

    default boolean isAny() {
        return this instanceof Any;
    }

    default boolean isExists() {
        return this instanceof Exists;
    }

    default boolean isFunction() {
        return this instanceof Function;
    }

    default boolean isNext() {
        return this instanceof Next;
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

    default Foo asFoo() {
        return (Foo) this;
    }

    default Quantifier asQuantifier() {
        return (Quantifier) this;
    }

}
