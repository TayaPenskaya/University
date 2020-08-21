package expression;

import java.util.Map;
import java.util.Set;

public class ModusPonens extends AbstractProof {

    private int from, to;

    public ModusPonens(int number, int from, int to) {
        super(number);
        this.from = from;
        this.to = to;
    }

    @Override
    String doGet() {
        return "M.P. " + (from + 1) + ", " + (to + 1);
    }

    @Override
    public void updateIndexes(Map<Integer, Integer> indexMapper) {
        super.updateIndexes(indexMapper);
        from = indexMapper.get(from);
        to = indexMapper.get(to);
    }

    public void provideUsed(Set<Integer> used) {
        used.add(from);
        used.add(to);
    }
}
