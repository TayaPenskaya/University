package expression;

public class Variable implements Expression {
    public String name;

    public Variable(String name){
        this.name = name;
    }

    @Override
    public String print() {
        return name;
    }
}
