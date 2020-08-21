package expression;

import java.util.Map;

public abstract class AbstractProof implements Proof {

    private int number;

    public AbstractProof(int number) {
        this.number = number;
    }

    abstract String doGet();

    @Override
    public String get() {
        return "[" + (number + 1) + ". " + doGet() + "]";
    }

    @Override
    public void updateIndexes(Map<Integer, Integer> indexMapper) {
        number = indexMapper.get(number);
    }
}
