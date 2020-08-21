package expression;

import java.util.Map;

public interface Proof {
    String get();

    void updateIndexes(Map<Integer, Integer> indexMapper);

    default boolean isMP() {
        return this instanceof ModusPonens;
    }

    default ModusPonens asMP() {
        return (ModusPonens) this;
    }
}
