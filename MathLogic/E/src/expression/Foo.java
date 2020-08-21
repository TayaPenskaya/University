package expression;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.hash;

public class Foo implements Expression {

    private Variable name;
    private List<Expression> args;

    public Foo(Variable name, List<Expression> args) {
        this.name = name;
        this.args = args;
    }

    public Variable getVariable(){
        return name;
    }

    public List<Expression> getArgs() {
        return args;
    }

    @Override
    public String print() {
        return name.print() + "(" + args.stream().map(Expression::print).collect(Collectors.joining(",")) + ")";
    }

    @Override
    public int hashCode() {
        return hash(name, args);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Foo)) {
            return false;
        }

        Foo toCheck = ((Expression) obj).asFoo();

        return this.getVariable().equals(toCheck.getVariable()) &&
                this.getArgs().equals(toCheck.getArgs());
    }
}
