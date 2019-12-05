package checker;

import expression.Expression;
import expression.Proof;
import expression.ProvedExpression;

import java.util.*;

public class ProofProvider {

    private final List<ProvedExpression> provedExpressions;
    private final Expression statement;

    private final Set<Integer> usedInMp = new HashSet<>();

    public ProofProvider(List<ProvedExpression> provedExpressions, Expression statement) {
        this.provedExpressions = provedExpressions;
        this.statement = statement;
    }


    private boolean checkStatement() {
        return provedExpressions.get(provedExpressions.size() - 1).getExpression().equals(statement);
    }

    private void finUsedInMP() {
        int last = provedExpressions.size() - 1;
        usedInMp.add(last);

        for (int i = last; i >= 0; --i) {
            if (!usedInMp.contains(i)) {
                continue;
            }
            Proof proof = provedExpressions.get(i).getProof();
            if (proof.isMP()) {

                proof.asMP().provideUsed(usedInMp);
            }
        }
    }


    public List<ProvedExpression> getProof() {
        if (!checkStatement()) {
            return null;
        }

        finUsedInMP();

        List<ProvedExpression> ans = new ArrayList<>();
        Map<Integer, Integer> indexMapper = new HashMap<>();
        int counter = -1;
        for (int i = 0; i < provedExpressions.size(); ++i) {
            if (!usedInMp.contains(i)) {
                continue;
            }
            indexMapper.put(i, ++counter);
            ProvedExpression provedExpression = provedExpressions.get(i);
            provedExpression.getProof().updateIndexes(indexMapper);
            ans.add(provedExpression);
        }
        return ans;
    }

}
