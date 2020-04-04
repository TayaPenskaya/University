// Generated from MetaGrammar.g4 by ANTLR 4.7.2
package gen;

import grammar.Grammar;
import atom.Atom;
import java.util.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MetaGrammarParser}.
 */
public interface MetaGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MetaGrammarParser#metaGrammar}.
	 * @param ctx the parse tree
	 */
	void enterMetaGrammar(MetaGrammarParser.MetaGrammarContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetaGrammarParser#metaGrammar}.
	 * @param ctx the parse tree
	 */
	void exitMetaGrammar(MetaGrammarParser.MetaGrammarContext ctx);
	/**
	 * Enter a parse tree produced by {@link MetaGrammarParser#grammarName}.
	 * @param ctx the parse tree
	 */
	void enterGrammarName(MetaGrammarParser.GrammarNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetaGrammarParser#grammarName}.
	 * @param ctx the parse tree
	 */
	void exitGrammarName(MetaGrammarParser.GrammarNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MetaGrammarParser#parsRules}.
	 * @param ctx the parse tree
	 */
	void enterParsRules(MetaGrammarParser.ParsRulesContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetaGrammarParser#parsRules}.
	 * @param ctx the parse tree
	 */
	void exitParsRules(MetaGrammarParser.ParsRulesContext ctx);
	/**
	 * Enter a parse tree produced by {@link MetaGrammarParser#parsRule}.
	 * @param ctx the parse tree
	 */
	void enterParsRule(MetaGrammarParser.ParsRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetaGrammarParser#parsRule}.
	 * @param ctx the parse tree
	 */
	void exitParsRule(MetaGrammarParser.ParsRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link MetaGrammarParser#args}.
	 * @param ctx the parse tree
	 */
	void enterArgs(MetaGrammarParser.ArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetaGrammarParser#args}.
	 * @param ctx the parse tree
	 */
	void exitArgs(MetaGrammarParser.ArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MetaGrammarParser#arg}.
	 * @param ctx the parse tree
	 */
	void enterArg(MetaGrammarParser.ArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetaGrammarParser#arg}.
	 * @param ctx the parse tree
	 */
	void exitArg(MetaGrammarParser.ArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link MetaGrammarParser#atomExpr}.
	 * @param ctx the parse tree
	 */
	void enterAtomExpr(MetaGrammarParser.AtomExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetaGrammarParser#atomExpr}.
	 * @param ctx the parse tree
	 */
	void exitAtomExpr(MetaGrammarParser.AtomExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MetaGrammarParser#atoms}.
	 * @param ctx the parse tree
	 */
	void enterAtoms(MetaGrammarParser.AtomsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetaGrammarParser#atoms}.
	 * @param ctx the parse tree
	 */
	void exitAtoms(MetaGrammarParser.AtomsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MetaGrammarParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(MetaGrammarParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetaGrammarParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(MetaGrammarParser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link MetaGrammarParser#nonterminal}.
	 * @param ctx the parse tree
	 */
	void enterNonterminal(MetaGrammarParser.NonterminalContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetaGrammarParser#nonterminal}.
	 * @param ctx the parse tree
	 */
	void exitNonterminal(MetaGrammarParser.NonterminalContext ctx);
	/**
	 * Enter a parse tree produced by {@link MetaGrammarParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(MetaGrammarParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetaGrammarParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(MetaGrammarParser.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MetaGrammarParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(MetaGrammarParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetaGrammarParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(MetaGrammarParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link MetaGrammarParser#token}.
	 * @param ctx the parse tree
	 */
	void enterToken(MetaGrammarParser.TokenContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetaGrammarParser#token}.
	 * @param ctx the parse tree
	 */
	void exitToken(MetaGrammarParser.TokenContext ctx);
	/**
	 * Enter a parse tree produced by {@link MetaGrammarParser#lexerRules}.
	 * @param ctx the parse tree
	 */
	void enterLexerRules(MetaGrammarParser.LexerRulesContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetaGrammarParser#lexerRules}.
	 * @param ctx the parse tree
	 */
	void exitLexerRules(MetaGrammarParser.LexerRulesContext ctx);
	/**
	 * Enter a parse tree produced by {@link MetaGrammarParser#lexerRule}.
	 * @param ctx the parse tree
	 */
	void enterLexerRule(MetaGrammarParser.LexerRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetaGrammarParser#lexerRule}.
	 * @param ctx the parse tree
	 */
	void exitLexerRule(MetaGrammarParser.LexerRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link MetaGrammarParser#tokenFilling}.
	 * @param ctx the parse tree
	 */
	void enterTokenFilling(MetaGrammarParser.TokenFillingContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetaGrammarParser#tokenFilling}.
	 * @param ctx the parse tree
	 */
	void exitTokenFilling(MetaGrammarParser.TokenFillingContext ctx);
	/**
	 * Enter a parse tree produced by {@link MetaGrammarParser#name}.
	 * @param ctx the parse tree
	 */
	void enterName(MetaGrammarParser.NameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MetaGrammarParser#name}.
	 * @param ctx the parse tree
	 */
	void exitName(MetaGrammarParser.NameContext ctx);
}