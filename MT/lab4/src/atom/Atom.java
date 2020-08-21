package atom;

import java.util.LinkedList;
import java.util.List;

public abstract class Atom {

    private String name;
    private String varName = "";
    private String code = "";

    public Atom(String name){
        this.name = name;
    }

    public Atom(String name, String varName, String code){
        this.name = name;
        this.varName = varName;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getVarName() {
        return varName;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Atom)) return false;

        return name.equals(((Atom) obj).name);
    }

    public static class Token extends Atom {
        private String filling = "";

        public Token(String name){
            super(name);
        }
        public Token(String name, String varName, String code){
            super(name, varName, code);
        }

        public Token(String name, String filling){
            super(name);
            this.filling = filling;
        }

        public Token(String name, String filling, String varName, String code){
            super(name, varName, code);
            this.filling = filling;
        }

        public String getFilling() {
            return filling;
        }
    }


    public static class Nonterminal extends Atom {
        private List<String> args = new LinkedList<>();

        public Nonterminal(String name){
            super(name);
        }
        public Nonterminal(String name, String varName, String code){
            super(name, varName, code);
        }

        public Nonterminal(String name, List<String> args){
            super(name);
            this.args = args;
        }

        public Nonterminal(String name, List<String> args, String varName, String code){
            super(name, varName, code);
            this.args = args;
        }

        public List<String> getArgs() {
            return args;
        }
    }
}