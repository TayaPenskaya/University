package expression;

import static java.util.Objects.hash;

public class Variable implements Expression {
    private String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public String print() {
        return name;
    }

    @Override
    public int hashCode() {
        return hash(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Variable)) {
            return false;
        }

        Variable toCheck = ((Expression) obj).asVariable();

        return this.name.equals(toCheck.name);
    }
}
