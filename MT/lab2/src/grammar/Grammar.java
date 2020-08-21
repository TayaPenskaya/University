package grammar;

import atom.Atom;
import atom.Nonterminal;
import atom.Token;

import java.util.*;

public class Grammar {
    private List<Rule> rules;
    private Map<Atom.ANonterminal, Set<Atom>> first = new HashMap<>();
    private Map<Atom.ANonterminal, Set<Atom>> follow = new HashMap<>();


    public static class Rule {
        private Atom.ANonterminal nonterminal;
        private List<Atom> atoms;

        public Rule(Atom.ANonterminal nonterminal, List<Atom> atoms) {
            this.nonterminal = nonterminal;
            this.atoms = atoms;
        }
    }

    public Grammar(List<Rule> rules) {
        this.rules = rules;
    }

    public void add(Rule rule) {
        rules.add(rule);
    }

    public void init() {
        rules.forEach(rule -> {
            first.put(rule.nonterminal, new HashSet<>());
            follow.put(rule.nonterminal, new HashSet<>());
        });
    }

    private Set<Atom> getFirst(List<Atom> atoms) {
        Set<Atom> res = new HashSet<>();
        for (Atom atom : atoms) {
            if (atom instanceof Atom.AToken) {
                res.add(atom);
                return res;
            }
            if (atom instanceof Atom.ANonterminal) {
                Set<Atom> curfirst = first.get(atom);
                if (curfirst != null) {
                    res.addAll(curfirst);
                    if (!curfirst.contains(new Atom.AToken(Token.EPS))) {
                        return res;
                    }
                } else {
                    return res;
                }
            }
        }
        return res;
    }

    private void buildFirst() {
        boolean changed = true;
        while (changed) {
            changed = false;
            for (Rule rule : rules) {

                Atom.ANonterminal A = rule.nonterminal;
                List<Atom> a = rule.atoms;

                int lastSize = first.get(A).size();
                first.get(A).addAll(getFirst(a));

                if (lastSize != first.get(A).size()) {
                    changed = true;
                }
            }
        }
    }

    private void buildFollow() {

        follow.get(new Atom.ANonterminal(Nonterminal.START)).add(new Atom.AToken(Token.END));

        boolean changed = true;
        while (changed) {
            changed = false;

            for (Rule rule : rules) {

                Atom.ANonterminal A = rule.nonterminal;
                List<Atom> a = rule.atoms;

                for (int i = 0; i < a.size(); ++i) {
                    if (a.get(i) instanceof Atom.ANonterminal) {

                        int oldSize = follow.get(a.get(i)).size();

                        int j = i + 1;
                        boolean hasEps = true;

                        while (j < a.size() && hasEps){

                            hasEps = false;

                            if (a.get(j) instanceof Atom.AToken){
                                follow.get(a.get(i)).add(a.get(j));
                                if (a.get(j).equals(new Atom.AToken(Token.EPS))){
                                    hasEps = true;
                                }
                                ++j;
                                continue;
                            }

                            if (a.get(j) instanceof Atom.ANonterminal){
                                Set<Atom> nextFirst = new HashSet<>();
                                nextFirst.addAll(first.get(a.get(j)));
                                if (nextFirst.contains(new Atom.AToken(Token.EPS))) {
                                    hasEps = true;
                                    nextFirst.remove(new Atom.AToken(Token.EPS));
                                }
                                follow.get(a.get(i)).addAll(nextFirst);
                                ++j;
                            }
                        }

                        if (hasEps || i == a.size() - 1){
                            follow.get(a.get(i)).addAll(follow.get(A));
                        }

                        if (oldSize != follow.get(a.get(i)).size()) {
                            changed = true;
                        }
                    }
                }
            }
        }
    }

    public void buildAll() {
        buildFirst();
        buildFollow();
    }

    public Map<Atom.ANonterminal, Set<Atom>> getFirstSet() {
        return first;
    }

    public Map<Atom.ANonterminal, Set<Atom>> getFollowSet() {
        return follow;
    }
}

