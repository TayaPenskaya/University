package generator;

import atom.Atom;
import grammar.Grammar;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class ParserGenerator {
    private final Path out;
    private final String name;
    private final Grammar grammar;

    private final String Q = "\"";

    public ParserGenerator(Path out, String name, Grammar grammar) {
        this.out = out;
        this.name = name;
        this.grammar = grammar;
    }

    public void createParser() throws IOException {
        File file = new File(out + "/" + name + "Parser.java");
        FileWriter writer = new FileWriter(file);

        List<Grammar.Rule> rules = grammar.getRules();
        grammar.buildAll();
        Map<Atom.Nonterminal, Set<Atom>> follow = grammar.getFollowSet();

        Grammar.Rule startRule = rules.stream().filter(r -> r.getNonterminalName().equals("start")).collect(Collectors.toList()).get(0);

        StringGenerator gen = new StringGenerator(new StringBuilder());

        gen.add(0, "package generated;", 2);

        gen.add(0, "import java.text.ParseException;", 2);
        gen.add(0, "import atom.Atom;", 2);

        gen.add(0, "public class " + name + "Parser {", 1);

        gen.add(1, "private " + name + "Lexer lexer;", 2);

        gen.add(1, "public " + name + "Parser(String string) throws ParseException {", 1);
        gen.add(2, "this.lexer = new " + name + "Lexer(string);", 1);
        gen.add(1, "}", 2);

        gen.add(1, "public " + startRule.getReturnVar().getType() + " parse() throws ParseException {", 1);
        gen.addManyOnSameLevel(2, new ArrayList<>(Arrays.asList("lexer.nextToken();", "return start();")));
        gen.add(1, "}", 2);

        List<String> distinctNames = rules.stream().map(Grammar.Rule::getNonterminalName).distinct().collect(Collectors.toList());
        Map<String, List<Grammar.Rule>> ruleS = new HashMap<>();
        for (String name : distinctNames) {
            List<Grammar.Rule> productions = new ArrayList<>();
            productions.addAll(rules.stream().filter(r -> r.getNonterminalName().equals(name)).collect(Collectors.toList()));
            ruleS.put(name, productions);
        }

        for (String name : distinctNames) {

            Grammar.Rule.Variable returnVar = ruleS.get(name).stream().map(Grammar.Rule::getReturnVar).collect(Collectors.toList()).get(0);
            List<Grammar.Rule.Variable> args = ruleS.get(name).stream().map(Grammar.Rule::getArgs).collect(Collectors.toList()).get(0);

            gen.add(1, "private "+ returnVar.getType() + " " + name + "(", 0);
            if (!args.isEmpty()){
                for(int i = 0; i < args.size(); ++i){
                    if (i != args.size() - 1){
                        gen.add(0, args.get(i).getType() + " " + args.get(i).getName() + ", ", 0);
                    } else {
                        gen.add(0, args.get(i).getType() + " " + args.get(i).getName(), 0);
                    }
                }
            }
            gen.add(0, ") throws ParseException {", 1);
            gen.add(2, returnVar.getType() + " " + returnVar.getName() + ";", 1);
            gen.add(2, "switch (lexer.curToken.getName()) {", 1);

            List<List<Atom>> thisProductions = ruleS.get(name).stream().map(Grammar.Rule::getAtoms).collect(Collectors.toList());
            Set<Atom> thisFollow = follow.get(new Atom.Nonterminal(name));

            for (List<Atom> pr : thisProductions) {
                boolean eps = false;
                Set<Atom> prFirst = grammar.getFirst(pr);
                if (prFirst.contains(new Atom.Token("EPS")))  {
                    for (Atom terminal : thisFollow) {
                        gen.add(3, "case " + Q + terminal.getName() + Q + ":", 1);
                    }
                    gen.add(4, pr.get(0).getCode().substring(1, pr.get(0).getCode().length()-1), 1);
                    gen.add(4, "break;", 1);
                } else {

                    for (Atom terminal : prFirst) {
                        gen.add(3, "case " + Q + terminal.getName() + Q + ":", 1);
                    }
                    for (Atom atom : pr) {
                        if (atom instanceof Atom.Token) {
                            if (!atom.getVarName().equals("")){
                                gen.add(4, "Atom.Token " + atom.getVarName() + " = lexer.curToken;", 1);
                                gen.add(4, atom.getCode().substring(1, atom.getCode().length()-1), 1);
                            } else if (atom.getCode() != null){
                                gen.add(4, atom.getCode().substring(1, atom.getCode().length()-1), 1);
                            }
                            gen.add(4, "lexer.nextToken();", 1);
                        }
                        if (atom instanceof Atom.Nonterminal) {
                            Grammar.Rule.Variable thisReturnVar = ruleS.get(atom.getName()).stream().map(Grammar.Rule::getReturnVar).collect(Collectors.toList()).get(0);
                            gen.add(4, thisReturnVar.getType() + " " + atom.getVarName() + " = " + atom.getName() + "(", 0);
                            if (!((Atom.Nonterminal) atom).getArgs().isEmpty()){
                                for (int i = 0; i < ((Atom.Nonterminal) atom).getArgs().size(); ++i){
                                    if (i != ((Atom.Nonterminal) atom).getArgs().size()-1){
                                        gen.add(0,  ((Atom.Nonterminal) atom).getArgs().get(i)+ ", ", 0);
                                    } else {
                                        gen.add(0,  ((Atom.Nonterminal) atom).getArgs().get(i), 0);
                                    }
                                }
                            }
                            gen.add(0, ");", 1);
                            if (atom.getCode() != null){
                                gen.add(4, atom.getCode().substring(1, atom.getCode().length()-1), 1);
                            }
                        }
                    }
                    gen.add(4, "break;", 1);

                }

            }

            gen.add(3, "default:", 1);
            gen.add(4, "throw new ParseException(\"Illegal token in " + name + "()\", 1);", 1);
            gen.add(2, "}", 1);
            gen.add(2, "return " + returnVar.getName() + ";", 1);
            gen.add(1, "}", 2);

        }

        gen.add(0, "}", 0);

//        System.out.println(gen.getSb().toString());

        writer.write(gen.getSb().toString());
        writer.close();

    }
}
