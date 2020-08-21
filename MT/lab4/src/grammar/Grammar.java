package grammar;

import atom.Atom;

import java.util.*;
import java.util.stream.Collectors;

public class Grammar {
    private String name;
    private List<LexerRule> lexerRules;
    private List<Rule> rules;
    private Map<Atom.Nonterminal, Set<Atom>> first = new HashMap<>();
    private Map<Atom.Nonterminal, Set<Atom>> follow = new HashMap<>();

    private final Atom.Token EPS = new Atom.Token("EPS");
    private final Atom.Nonterminal START = new Atom.Nonterminal("start");
    private final Atom.Token END = new Atom.Token("END");

    public static class LexerRule {
        private String name;
        private String regex;

        public LexerRule(String name, String regex){
            this.name = name;
            this.regex = regex;
        }

        public String getName() {
            return name;
        }

        public String getRegex() {
            return regex;
        }
    }

    public static class Rule {
        private Atom.Nonterminal nonterminal;
        private List<Variable> args = new LinkedList<>();
        private Variable returnVar;
        private List<Atom> atoms;

        public static class Variable {
            private String type;
            private String name;

            public Variable(String type, String name){
                this.type = type;
                this.name = name;
            }

            public String getName() {
                return name;
            }

            public String getType() {
                return type;
            }
        }

        public Rule(String name, List<Variable> args, Variable returnVar, List<Atom> atoms) {
            this.nonterminal = new Atom.Nonterminal(name);
            this.args = args;
            this.returnVar = returnVar;
            this.atoms = atoms;
        }

        public List<Variable> getArgs() {
            return args;
        }

        public Variable getReturnVar() {
            return returnVar;
        }

        public String getNonterminalName() {
            return nonterminal.getName();
        }

        public List<Atom> getAtoms() {
            return atoms;
        }
    }

    public Grammar(String name, List<LexerRule> lexerRules, List<Rule> rules) {
        this.name = name;
        this.lexerRules = lexerRules;
        this.rules = rules;
    }

    public String getName() {
        return name;
    }

    public List<LexerRule> getLexerRules() {
        return lexerRules;
    }

    public List<Rule> getRules() {
        return rules;
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

    public Set<Atom> getFirst(List<Atom> atoms) {
        Set<Atom> res = new HashSet<>();
        for (Atom atom : atoms) {
            if (atom instanceof Atom.Token) {
                res.add(atom);
                return res;
            }
            if (atom instanceof Atom.Nonterminal) {
                Set<Atom> curfirst = first.get(atom);
                if (curfirst != null) {
                    res.addAll(curfirst.stream().filter(a -> !a.equals(EPS)).collect(Collectors.toList()));
                    if (!curfirst.contains(EPS)) {
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

                Atom.Nonterminal A = rule.nonterminal;
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

        follow.get(START).add(END);

        boolean changed = true;
        while (changed) {
            changed = false;

            for (Rule rule : rules) {

                Atom.Nonterminal A = rule.nonterminal;
                List<Atom> a = rule.atoms;

                for (int i = 0; i < a.size(); ++i) {
                    if (a.get(i) instanceof Atom.Nonterminal) {

                        int oldSize = follow.get(a.get(i)).size();

                        int j = i + 1;
                        boolean hasEps = true;

                        while (j < a.size() && hasEps){

                            hasEps = false;

                            if (a.get(j) instanceof Atom.Token){
                                follow.get(a.get(i)).add(a.get(j));
                                if (a.get(j).equals(EPS)){
                                    hasEps = true;
                                }
                                ++j;
                                continue;
                            }

                            if (a.get(j) instanceof Atom.Nonterminal){
                                Set<Atom> nextFirst = new HashSet<>();
                                nextFirst.addAll(first.get(a.get(j)));
                                if (nextFirst.contains(EPS)) {
                                    hasEps = true;
                                    nextFirst.remove(EPS);
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
        init();
        buildFirst();
        buildFollow();
    }

    public Map<Atom.Nonterminal, Set<Atom>> getFirstSet() {
        return first;
    }

    public Map<Atom.Nonterminal, Set<Atom>> getFollowSet() {
        return follow;
    }
}