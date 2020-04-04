// Generated from MetaGrammar.g4 by ANTLR 4.7.2
package gen;

import grammar.Grammar;
import atom.Atom;
import java.util.*;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MetaGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MetaGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MetaGrammarParser#metaGrammar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMetaGrammar(MetaGrammarParser.MetaGrammarContext ctx);
	/**
	 * Visit a parse tree produced by {@link MetaGrammarParser#grammarName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGrammarName(MetaGrammarParser.GrammarNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MetaGrammarParser#parsRules}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParsRules(MetaGrammarParser.ParsRulesContext ctx);
	/**
	 * Visit a parse tree produced by {@link MetaGrammarParser#parsRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParsRule(MetaGrammarParser.ParsRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link MetaGrammarParser#args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgs(MetaGrammarParser.ArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MetaGrammarParser#arg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArg(MetaGrammarParser.ArgContext ctx);
	/**
	 * Visit a parse tree produced by {@link MetaGrammarParser#atomExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomExpr(MetaGrammarParser.AtomExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MetaGrammarParser#atoms}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtoms(MetaGrammarParser.AtomsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MetaGrammarParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(MetaGrammarParser.AtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link MetaGrammarParser#nonterminal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonterminal(MetaGrammarParser.NonterminalContext ctx);
	/**
	 * Visit a parse tree produced by {@link MetaGrammarParser#params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParams(MetaGrammarParser.ParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MetaGrammarParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(MetaGrammarParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link MetaGrammarParser#token}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToken(MetaGrammarParser.TokenContext ctx);
	/**
	 * Visit a parse tree produced by {@link MetaGrammarParser#lexerRules}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLexerRules(MetaGrammarParser.LexerRulesContext ctx);
	/**
	 * Visit a parse tree produced by {@link MetaGrammarParser#lexerRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLexerRule(MetaGrammarParser.LexerRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link MetaGrammarParser#tokenFilling}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTokenFilling(MetaGrammarParser.TokenFillingContext ctx);
	/**
	 * Visit a parse tree produced by {@link MetaGrammarParser#name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitName(MetaGrammarParser.NameContext ctx);
}