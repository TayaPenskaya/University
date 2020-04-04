// Generated from MetaGrammar.g4 by ANTLR 4.7.2
package gen;

import grammar.Grammar;
import atom.Atom;
import java.util.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MetaGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		GRAMMAR=1, RETURN=2, HEADER=3, MEMBERS=4, IMPORT=5, SKIP_RULE=6, SOBAKA=7, 
		SEMI=8, COLON=9, COMMA=10, REPEAT=11, OR=12, QUESTION=13, ASTERISK=14, 
		PLUS=15, EQ=16, L_PAR=17, R_PAR=18, L_BRACE=19, R_BRACE=20, L_BRACKET=21, 
		R_BRACKET=22, NUMBER=23, NONTERMINAL_NAME=24, TOKEN_NAME=25, LETTER=26, 
		NAME=27, CODE=28, REGEX=29, WS=30;
	public static final int
		RULE_metaGrammar = 0, RULE_grammarName = 1, RULE_parsRules = 2, RULE_parsRule = 3, 
		RULE_args = 4, RULE_arg = 5, RULE_atomExpr = 6, RULE_atoms = 7, RULE_atom = 8, 
		RULE_nonterminal = 9, RULE_params = 10, RULE_param = 11, RULE_token = 12, 
		RULE_lexerRules = 13, RULE_lexerRule = 14, RULE_tokenFilling = 15, RULE_name = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"metaGrammar", "grammarName", "parsRules", "parsRule", "args", "arg", 
			"atomExpr", "atoms", "atom", "nonterminal", "params", "param", "token", 
			"lexerRules", "lexerRule", "tokenFilling", "name"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'grammar'", "'returns'", "'header'", "'members'", "'import'", 
			"'-> skip'", "'@'", "';'", "':'", "','", null, "'|'", "'?'", "'*'", "'+'", 
			"'='", "'('", "')'", "'{'", "'}'", "'['", "']'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "GRAMMAR", "RETURN", "HEADER", "MEMBERS", "IMPORT", "SKIP_RULE", 
			"SOBAKA", "SEMI", "COLON", "COMMA", "REPEAT", "OR", "QUESTION", "ASTERISK", 
			"PLUS", "EQ", "L_PAR", "R_PAR", "L_BRACE", "R_BRACE", "L_BRACKET", "R_BRACKET", 
			"NUMBER", "NONTERMINAL_NAME", "TOKEN_NAME", "LETTER", "NAME", "CODE", 
			"REGEX", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "MetaGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MetaGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class MetaGrammarContext extends ParserRuleContext {
		public Grammar grammar;
		public GrammarNameContext grammarName;
		public ParsRulesContext parsRules;
		public LexerRulesContext lexerRules;
		public GrammarNameContext grammarName() {
			return getRuleContext(GrammarNameContext.class,0);
		}
		public ParsRulesContext parsRules() {
			return getRuleContext(ParsRulesContext.class,0);
		}
		public LexerRulesContext lexerRules() {
			return getRuleContext(LexerRulesContext.class,0);
		}
		public MetaGrammarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_metaGrammar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).enterMetaGrammar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).exitMetaGrammar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MetaGrammarVisitor ) return ((MetaGrammarVisitor<? extends T>)visitor).visitMetaGrammar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MetaGrammarContext metaGrammar() throws RecognitionException {
		MetaGrammarContext _localctx = new MetaGrammarContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_metaGrammar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			((MetaGrammarContext)_localctx).grammarName = grammarName();
			setState(35);
			((MetaGrammarContext)_localctx).parsRules = parsRules();
			setState(36);
			((MetaGrammarContext)_localctx).lexerRules = lexerRules();
			((MetaGrammarContext)_localctx).grammar =  new Grammar(((MetaGrammarContext)_localctx).grammarName.value, ((MetaGrammarContext)_localctx).lexerRules.lexRules, ((MetaGrammarContext)_localctx).parsRules.rules);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GrammarNameContext extends ParserRuleContext {
		public String value;
		public NameContext name;
		public TerminalNode GRAMMAR() { return getToken(MetaGrammarParser.GRAMMAR, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(MetaGrammarParser.SEMI, 0); }
		public GrammarNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_grammarName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).enterGrammarName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).exitGrammarName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MetaGrammarVisitor ) return ((MetaGrammarVisitor<? extends T>)visitor).visitGrammarName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GrammarNameContext grammarName() throws RecognitionException {
		GrammarNameContext _localctx = new GrammarNameContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_grammarName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			match(GRAMMAR);
			setState(40);
			((GrammarNameContext)_localctx).name = name();
			setState(41);
			match(SEMI);
			((GrammarNameContext)_localctx).value =  ((GrammarNameContext)_localctx).name.value;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParsRulesContext extends ParserRuleContext {
		public List<Grammar.Rule> rules;
		public ParsRuleContext parsRule;
		public List<ParsRuleContext> parsRule() {
			return getRuleContexts(ParsRuleContext.class);
		}
		public ParsRuleContext parsRule(int i) {
			return getRuleContext(ParsRuleContext.class,i);
		}
		public ParsRulesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parsRules; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).enterParsRules(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).exitParsRules(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MetaGrammarVisitor ) return ((MetaGrammarVisitor<? extends T>)visitor).visitParsRules(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParsRulesContext parsRules() throws RecognitionException {
		ParsRulesContext _localctx = new ParsRulesContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_parsRules);

		    ((ParsRulesContext)_localctx).rules =  new LinkedList<>();

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(44);
				((ParsRulesContext)_localctx).parsRule = parsRule();
				_localctx.rules.addAll(((ParsRulesContext)_localctx).parsRule.rule);
				}
				}
				setState(49); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NONTERMINAL_NAME );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParsRuleContext extends ParserRuleContext {
		public List<Grammar.Rule> rule;
		public Token NONTERMINAL_NAME;
		public ArgsContext args;
		public ArgContext arg;
		public AtomExprContext atomExpr;
		public TerminalNode NONTERMINAL_NAME() { return getToken(MetaGrammarParser.NONTERMINAL_NAME, 0); }
		public TerminalNode L_PAR() { return getToken(MetaGrammarParser.L_PAR, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public TerminalNode R_PAR() { return getToken(MetaGrammarParser.R_PAR, 0); }
		public TerminalNode RETURN() { return getToken(MetaGrammarParser.RETURN, 0); }
		public TerminalNode L_BRACKET() { return getToken(MetaGrammarParser.L_BRACKET, 0); }
		public ArgContext arg() {
			return getRuleContext(ArgContext.class,0);
		}
		public TerminalNode R_BRACKET() { return getToken(MetaGrammarParser.R_BRACKET, 0); }
		public TerminalNode COLON() { return getToken(MetaGrammarParser.COLON, 0); }
		public AtomExprContext atomExpr() {
			return getRuleContext(AtomExprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(MetaGrammarParser.SEMI, 0); }
		public ParsRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parsRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).enterParsRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).exitParsRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MetaGrammarVisitor ) return ((MetaGrammarVisitor<? extends T>)visitor).visitParsRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParsRuleContext parsRule() throws RecognitionException {
		ParsRuleContext _localctx = new ParsRuleContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_parsRule);

		    ((ParsRuleContext)_localctx).rule =  new LinkedList<>();

		try {
			setState(74);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(51);
				((ParsRuleContext)_localctx).NONTERMINAL_NAME = match(NONTERMINAL_NAME);
				setState(52);
				match(L_PAR);
				setState(53);
				((ParsRuleContext)_localctx).args = args();
				setState(54);
				match(R_PAR);
				setState(55);
				match(RETURN);
				setState(56);
				match(L_BRACKET);
				setState(57);
				((ParsRuleContext)_localctx).arg = arg();
				setState(58);
				match(R_BRACKET);
				setState(59);
				match(COLON);
				setState(60);
				((ParsRuleContext)_localctx).atomExpr = atomExpr();
				setState(61);
				match(SEMI);

				      for (List<Atom> l : ((ParsRuleContext)_localctx).atomExpr.allAtoms) {
				          _localctx.rule.add(new Grammar.Rule((((ParsRuleContext)_localctx).NONTERMINAL_NAME!=null?((ParsRuleContext)_localctx).NONTERMINAL_NAME.getText():null), ((ParsRuleContext)_localctx).args.vars, ((ParsRuleContext)_localctx).arg.var, l));
				      }
				  
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(64);
				((ParsRuleContext)_localctx).NONTERMINAL_NAME = match(NONTERMINAL_NAME);
				setState(65);
				match(RETURN);
				setState(66);
				match(L_BRACKET);
				setState(67);
				((ParsRuleContext)_localctx).arg = arg();
				setState(68);
				match(R_BRACKET);
				setState(69);
				match(COLON);
				setState(70);
				((ParsRuleContext)_localctx).atomExpr = atomExpr();
				setState(71);
				match(SEMI);

				    for (List<Atom> l : ((ParsRuleContext)_localctx).atomExpr.allAtoms) {
				        _localctx.rule.add(new Grammar.Rule((((ParsRuleContext)_localctx).NONTERMINAL_NAME!=null?((ParsRuleContext)_localctx).NONTERMINAL_NAME.getText():null), Collections.EMPTY_LIST, ((ParsRuleContext)_localctx).arg.var, l));
				    }

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgsContext extends ParserRuleContext {
		public List<Grammar.Rule.Variable> vars;
		public ArgContext arg;
		public List<ArgContext> arg() {
			return getRuleContexts(ArgContext.class);
		}
		public ArgContext arg(int i) {
			return getRuleContext(ArgContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MetaGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MetaGrammarParser.COMMA, i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).enterArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).exitArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MetaGrammarVisitor ) return ((MetaGrammarVisitor<? extends T>)visitor).visitArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_args);

		    ((ArgsContext)_localctx).vars =  new LinkedList<>();

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			((ArgsContext)_localctx).arg = arg();
			_localctx.vars.add(((ArgsContext)_localctx).arg.var);
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(78);
				match(COMMA);
				setState(79);
				((ArgsContext)_localctx).arg = arg();
				_localctx.vars.add(((ArgsContext)_localctx).arg.var);
				}
				}
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgContext extends ParserRuleContext {
		public Grammar.Rule.Variable var;
		public NameContext t;
		public NameContext n;
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public ArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).enterArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).exitArg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MetaGrammarVisitor ) return ((MetaGrammarVisitor<? extends T>)visitor).visitArg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgContext arg() throws RecognitionException {
		ArgContext _localctx = new ArgContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_arg);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			((ArgContext)_localctx).t = name();
			setState(88);
			((ArgContext)_localctx).n = name();
			((ArgContext)_localctx).var =  new Grammar.Rule.Variable(((ArgContext)_localctx).t.value, ((ArgContext)_localctx).n.value);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtomExprContext extends ParserRuleContext {
		public List<List<Atom>> allAtoms;
		public AtomsContext atoms;
		public List<AtomsContext> atoms() {
			return getRuleContexts(AtomsContext.class);
		}
		public AtomsContext atoms(int i) {
			return getRuleContext(AtomsContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(MetaGrammarParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(MetaGrammarParser.OR, i);
		}
		public AtomExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).enterAtomExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).exitAtomExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MetaGrammarVisitor ) return ((MetaGrammarVisitor<? extends T>)visitor).visitAtomExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomExprContext atomExpr() throws RecognitionException {
		AtomExprContext _localctx = new AtomExprContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_atomExpr);

		    ((AtomExprContext)_localctx).allAtoms =  new LinkedList<>();

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			((AtomExprContext)_localctx).atoms = atoms();
			_localctx.allAtoms.add(((AtomExprContext)_localctx).atoms.atomsList);
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(93);
				match(OR);
				setState(94);
				((AtomExprContext)_localctx).atoms = atoms();
				_localctx.allAtoms.add(((AtomExprContext)_localctx).atoms.atomsList);
				}
				}
				setState(101);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtomsContext extends ParserRuleContext {
		public List<Atom> atomsList;
		public AtomContext atom;
		public List<AtomContext> atom() {
			return getRuleContexts(AtomContext.class);
		}
		public AtomContext atom(int i) {
			return getRuleContext(AtomContext.class,i);
		}
		public AtomsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atoms; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).enterAtoms(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).exitAtoms(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MetaGrammarVisitor ) return ((MetaGrammarVisitor<? extends T>)visitor).visitAtoms(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomsContext atoms() throws RecognitionException {
		AtomsContext _localctx = new AtomsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_atoms);

		    ((AtomsContext)_localctx).atomsList =  new LinkedList<>();

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(102);
				((AtomsContext)_localctx).atom = atom();
				_localctx.atomsList.add(((AtomsContext)_localctx).atom.atoM);
				}
				}
				setState(107); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NONTERMINAL_NAME) | (1L << TOKEN_NAME) | (1L << NAME))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtomContext extends ParserRuleContext {
		public Atom atoM;
		public NonterminalContext nonterminal;
		public TokenContext token;
		public NonterminalContext nonterminal() {
			return getRuleContext(NonterminalContext.class,0);
		}
		public TokenContext token() {
			return getRuleContext(TokenContext.class,0);
		}
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).enterAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).exitAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MetaGrammarVisitor ) return ((MetaGrammarVisitor<? extends T>)visitor).visitAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_atom);
		try {
			setState(115);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(109);
				((AtomContext)_localctx).nonterminal = nonterminal();
				((AtomContext)_localctx).atoM =  ((AtomContext)_localctx).nonterminal.atoM;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(112);
				((AtomContext)_localctx).token = token();
				((AtomContext)_localctx).atoM =  ((AtomContext)_localctx).token.atoM;
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NonterminalContext extends ParserRuleContext {
		public Atom atoM;
		public NameContext name;
		public Token NONTERMINAL_NAME;
		public ParamsContext params;
		public Token CODE;
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode EQ() { return getToken(MetaGrammarParser.EQ, 0); }
		public TerminalNode NONTERMINAL_NAME() { return getToken(MetaGrammarParser.NONTERMINAL_NAME, 0); }
		public TerminalNode L_PAR() { return getToken(MetaGrammarParser.L_PAR, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public TerminalNode R_PAR() { return getToken(MetaGrammarParser.R_PAR, 0); }
		public TerminalNode CODE() { return getToken(MetaGrammarParser.CODE, 0); }
		public NonterminalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonterminal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).enterNonterminal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).exitNonterminal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MetaGrammarVisitor ) return ((MetaGrammarVisitor<? extends T>)visitor).visitNonterminal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NonterminalContext nonterminal() throws RecognitionException {
		NonterminalContext _localctx = new NonterminalContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_nonterminal);
		int _la;
		try {
			setState(140);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(117);
				((NonterminalContext)_localctx).name = name();
				setState(118);
				match(EQ);
				setState(119);
				((NonterminalContext)_localctx).NONTERMINAL_NAME = match(NONTERMINAL_NAME);
				setState(120);
				match(L_PAR);
				setState(121);
				((NonterminalContext)_localctx).params = params();
				setState(122);
				match(R_PAR);
				setState(124);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CODE) {
					{
					setState(123);
					((NonterminalContext)_localctx).CODE = match(CODE);
					}
				}

				((NonterminalContext)_localctx).atoM =  new Atom.Nonterminal((((NonterminalContext)_localctx).NONTERMINAL_NAME!=null?((NonterminalContext)_localctx).NONTERMINAL_NAME.getText():null), ((NonterminalContext)_localctx).params.vals, ((NonterminalContext)_localctx).name.value, (((NonterminalContext)_localctx).CODE!=null?((NonterminalContext)_localctx).CODE.getText():null));
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(128);
				((NonterminalContext)_localctx).name = name();
				setState(129);
				match(EQ);
				setState(130);
				((NonterminalContext)_localctx).NONTERMINAL_NAME = match(NONTERMINAL_NAME);
				setState(131);
				match(L_PAR);
				setState(132);
				match(R_PAR);
				setState(134);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CODE) {
					{
					setState(133);
					((NonterminalContext)_localctx).CODE = match(CODE);
					}
				}

				((NonterminalContext)_localctx).atoM =  new Atom.Nonterminal((((NonterminalContext)_localctx).NONTERMINAL_NAME!=null?((NonterminalContext)_localctx).NONTERMINAL_NAME.getText():null), Collections.EMPTY_LIST, ((NonterminalContext)_localctx).name.value, (((NonterminalContext)_localctx).CODE!=null?((NonterminalContext)_localctx).CODE.getText():null));
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(138);
				((NonterminalContext)_localctx).NONTERMINAL_NAME = match(NONTERMINAL_NAME);
				((NonterminalContext)_localctx).atoM =  new Atom.Nonterminal((((NonterminalContext)_localctx).NONTERMINAL_NAME!=null?((NonterminalContext)_localctx).NONTERMINAL_NAME.getText():null));
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamsContext extends ParserRuleContext {
		public List<String> vals;
		public ParamContext param;
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MetaGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MetaGrammarParser.COMMA, i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).enterParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).exitParams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MetaGrammarVisitor ) return ((MetaGrammarVisitor<? extends T>)visitor).visitParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_params);

		    ((ParamsContext)_localctx).vals =  new LinkedList<>();

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			((ParamsContext)_localctx).param = param();
			_localctx.vals.add(((ParamsContext)_localctx).param.value);
			setState(150);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(144);
				match(COMMA);
				setState(145);
				((ParamsContext)_localctx).param = param();
				_localctx.vals.add(((ParamsContext)_localctx).param.value);
				}
				}
				setState(152);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamContext extends ParserRuleContext {
		public String value;
		public NameContext name;
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).exitParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MetaGrammarVisitor ) return ((MetaGrammarVisitor<? extends T>)visitor).visitParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			((ParamContext)_localctx).name = name();
			((ParamContext)_localctx).value =  ((ParamContext)_localctx).name.value;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TokenContext extends ParserRuleContext {
		public Atom atoM;
		public NameContext name;
		public Token TOKEN_NAME;
		public Token CODE;
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode EQ() { return getToken(MetaGrammarParser.EQ, 0); }
		public TerminalNode TOKEN_NAME() { return getToken(MetaGrammarParser.TOKEN_NAME, 0); }
		public TerminalNode CODE() { return getToken(MetaGrammarParser.CODE, 0); }
		public TokenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_token; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).enterToken(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).exitToken(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MetaGrammarVisitor ) return ((MetaGrammarVisitor<? extends T>)visitor).visitToken(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TokenContext token() throws RecognitionException {
		TokenContext _localctx = new TokenContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_token);
		int _la;
		try {
			setState(169);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(156);
				((TokenContext)_localctx).name = name();
				setState(157);
				match(EQ);
				setState(158);
				((TokenContext)_localctx).TOKEN_NAME = match(TOKEN_NAME);
				setState(160);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CODE) {
					{
					setState(159);
					((TokenContext)_localctx).CODE = match(CODE);
					}
				}

				((TokenContext)_localctx).atoM =  new Atom.Token((((TokenContext)_localctx).TOKEN_NAME!=null?((TokenContext)_localctx).TOKEN_NAME.getText():null), ((TokenContext)_localctx).name.value, (((TokenContext)_localctx).CODE!=null?((TokenContext)_localctx).CODE.getText():null));
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(164);
				((TokenContext)_localctx).TOKEN_NAME = match(TOKEN_NAME);
				setState(166);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CODE) {
					{
					setState(165);
					((TokenContext)_localctx).CODE = match(CODE);
					}
				}

				((TokenContext)_localctx).atoM =  new Atom.Token((((TokenContext)_localctx).TOKEN_NAME!=null?((TokenContext)_localctx).TOKEN_NAME.getText():null), "", (((TokenContext)_localctx).CODE!=null?((TokenContext)_localctx).CODE.getText():null));
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LexerRulesContext extends ParserRuleContext {
		public List<Grammar.LexerRule> lexRules;
		public LexerRuleContext lexerRule;
		public List<LexerRuleContext> lexerRule() {
			return getRuleContexts(LexerRuleContext.class);
		}
		public LexerRuleContext lexerRule(int i) {
			return getRuleContext(LexerRuleContext.class,i);
		}
		public LexerRulesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lexerRules; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).enterLexerRules(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).exitLexerRules(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MetaGrammarVisitor ) return ((MetaGrammarVisitor<? extends T>)visitor).visitLexerRules(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LexerRulesContext lexerRules() throws RecognitionException {
		LexerRulesContext _localctx = new LexerRulesContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_lexerRules);

		    ((LexerRulesContext)_localctx).lexRules =  new LinkedList<>();

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(171);
				((LexerRulesContext)_localctx).lexerRule = lexerRule();
				_localctx.lexRules.add(((LexerRulesContext)_localctx).lexerRule.lexRule);
				}
				}
				setState(176); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==TOKEN_NAME );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LexerRuleContext extends ParserRuleContext {
		public Grammar.LexerRule lexRule;
		public Token TOKEN_NAME;
		public TokenFillingContext tokenFilling;
		public TerminalNode TOKEN_NAME() { return getToken(MetaGrammarParser.TOKEN_NAME, 0); }
		public TerminalNode COLON() { return getToken(MetaGrammarParser.COLON, 0); }
		public TokenFillingContext tokenFilling() {
			return getRuleContext(TokenFillingContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(MetaGrammarParser.SEMI, 0); }
		public LexerRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lexerRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).enterLexerRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).exitLexerRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MetaGrammarVisitor ) return ((MetaGrammarVisitor<? extends T>)visitor).visitLexerRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LexerRuleContext lexerRule() throws RecognitionException {
		LexerRuleContext _localctx = new LexerRuleContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_lexerRule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			((LexerRuleContext)_localctx).TOKEN_NAME = match(TOKEN_NAME);
			setState(179);
			match(COLON);
			setState(180);
			((LexerRuleContext)_localctx).tokenFilling = tokenFilling();
			setState(181);
			match(SEMI);
			((LexerRuleContext)_localctx).lexRule =  new Grammar.LexerRule((((LexerRuleContext)_localctx).TOKEN_NAME!=null?((LexerRuleContext)_localctx).TOKEN_NAME.getText():null), ((LexerRuleContext)_localctx).tokenFilling.regex);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TokenFillingContext extends ParserRuleContext {
		public String regex;
		public Token REGEX;
		public TerminalNode REGEX() { return getToken(MetaGrammarParser.REGEX, 0); }
		public TokenFillingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tokenFilling; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).enterTokenFilling(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).exitTokenFilling(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MetaGrammarVisitor ) return ((MetaGrammarVisitor<? extends T>)visitor).visitTokenFilling(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TokenFillingContext tokenFilling() throws RecognitionException {
		TokenFillingContext _localctx = new TokenFillingContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_tokenFilling);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			((TokenFillingContext)_localctx).REGEX = match(REGEX);
			((TokenFillingContext)_localctx).regex =  (((TokenFillingContext)_localctx).REGEX!=null?((TokenFillingContext)_localctx).REGEX.getText():null);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NameContext extends ParserRuleContext {
		public String value;
		public Token NONTERMINAL_NAME;
		public Token TOKEN_NAME;
		public Token NAME;
		public TerminalNode NONTERMINAL_NAME() { return getToken(MetaGrammarParser.NONTERMINAL_NAME, 0); }
		public TerminalNode TOKEN_NAME() { return getToken(MetaGrammarParser.TOKEN_NAME, 0); }
		public TerminalNode NAME() { return getToken(MetaGrammarParser.NAME, 0); }
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).enterName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MetaGrammarListener ) ((MetaGrammarListener)listener).exitName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MetaGrammarVisitor ) return ((MetaGrammarVisitor<? extends T>)visitor).visitName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_name);
		try {
			setState(193);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NONTERMINAL_NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(187);
				((NameContext)_localctx).NONTERMINAL_NAME = match(NONTERMINAL_NAME);
				((NameContext)_localctx).value =  (((NameContext)_localctx).NONTERMINAL_NAME!=null?((NameContext)_localctx).NONTERMINAL_NAME.getText():null);
				}
				break;
			case TOKEN_NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(189);
				((NameContext)_localctx).TOKEN_NAME = match(TOKEN_NAME);
				((NameContext)_localctx).value =  (((NameContext)_localctx).TOKEN_NAME!=null?((NameContext)_localctx).TOKEN_NAME.getText():null);
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 3);
				{
				setState(191);
				((NameContext)_localctx).NAME = match(NAME);
				((NameContext)_localctx).value =  (((NameContext)_localctx).NAME!=null?((NameContext)_localctx).NAME.getText():null);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3 \u00c6\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\6\4\62\n\4\r\4\16"+
		"\4\63\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5M\n\5\3\6\3\6\3\6\3\6\3\6\3\6\7\6U\n\6"+
		"\f\6\16\6X\13\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\7\bd\n\b\f\b\16"+
		"\bg\13\b\3\t\3\t\3\t\6\tl\n\t\r\t\16\tm\3\n\3\n\3\n\3\n\3\n\3\n\5\nv\n"+
		"\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\177\n\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\5\13\u0089\n\13\3\13\3\13\3\13\3\13\5\13\u008f\n"+
		"\13\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u0097\n\f\f\f\16\f\u009a\13\f\3\r\3\r"+
		"\3\r\3\16\3\16\3\16\3\16\5\16\u00a3\n\16\3\16\3\16\3\16\3\16\5\16\u00a9"+
		"\n\16\3\16\5\16\u00ac\n\16\3\17\3\17\3\17\6\17\u00b1\n\17\r\17\16\17\u00b2"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\5\22\u00c4\n\22\3\22\2\2\23\2\4\6\b\n\f\16\20\22\24\26\30\32\34"+
		"\36 \"\2\2\2\u00c5\2$\3\2\2\2\4)\3\2\2\2\6\61\3\2\2\2\bL\3\2\2\2\nN\3"+
		"\2\2\2\fY\3\2\2\2\16]\3\2\2\2\20k\3\2\2\2\22u\3\2\2\2\24\u008e\3\2\2\2"+
		"\26\u0090\3\2\2\2\30\u009b\3\2\2\2\32\u00ab\3\2\2\2\34\u00b0\3\2\2\2\36"+
		"\u00b4\3\2\2\2 \u00ba\3\2\2\2\"\u00c3\3\2\2\2$%\5\4\3\2%&\5\6\4\2&\'\5"+
		"\34\17\2\'(\b\2\1\2(\3\3\2\2\2)*\7\3\2\2*+\5\"\22\2+,\7\n\2\2,-\b\3\1"+
		"\2-\5\3\2\2\2./\5\b\5\2/\60\b\4\1\2\60\62\3\2\2\2\61.\3\2\2\2\62\63\3"+
		"\2\2\2\63\61\3\2\2\2\63\64\3\2\2\2\64\7\3\2\2\2\65\66\7\32\2\2\66\67\7"+
		"\23\2\2\678\5\n\6\289\7\24\2\29:\7\4\2\2:;\7\27\2\2;<\5\f\7\2<=\7\30\2"+
		"\2=>\7\13\2\2>?\5\16\b\2?@\7\n\2\2@A\b\5\1\2AM\3\2\2\2BC\7\32\2\2CD\7"+
		"\4\2\2DE\7\27\2\2EF\5\f\7\2FG\7\30\2\2GH\7\13\2\2HI\5\16\b\2IJ\7\n\2\2"+
		"JK\b\5\1\2KM\3\2\2\2L\65\3\2\2\2LB\3\2\2\2M\t\3\2\2\2NO\5\f\7\2OV\b\6"+
		"\1\2PQ\7\f\2\2QR\5\f\7\2RS\b\6\1\2SU\3\2\2\2TP\3\2\2\2UX\3\2\2\2VT\3\2"+
		"\2\2VW\3\2\2\2W\13\3\2\2\2XV\3\2\2\2YZ\5\"\22\2Z[\5\"\22\2[\\\b\7\1\2"+
		"\\\r\3\2\2\2]^\5\20\t\2^e\b\b\1\2_`\7\16\2\2`a\5\20\t\2ab\b\b\1\2bd\3"+
		"\2\2\2c_\3\2\2\2dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2f\17\3\2\2\2ge\3\2\2\2h"+
		"i\5\22\n\2ij\b\t\1\2jl\3\2\2\2kh\3\2\2\2lm\3\2\2\2mk\3\2\2\2mn\3\2\2\2"+
		"n\21\3\2\2\2op\5\24\13\2pq\b\n\1\2qv\3\2\2\2rs\5\32\16\2st\b\n\1\2tv\3"+
		"\2\2\2uo\3\2\2\2ur\3\2\2\2v\23\3\2\2\2wx\5\"\22\2xy\7\22\2\2yz\7\32\2"+
		"\2z{\7\23\2\2{|\5\26\f\2|~\7\24\2\2}\177\7\36\2\2~}\3\2\2\2~\177\3\2\2"+
		"\2\177\u0080\3\2\2\2\u0080\u0081\b\13\1\2\u0081\u008f\3\2\2\2\u0082\u0083"+
		"\5\"\22\2\u0083\u0084\7\22\2\2\u0084\u0085\7\32\2\2\u0085\u0086\7\23\2"+
		"\2\u0086\u0088\7\24\2\2\u0087\u0089\7\36\2\2\u0088\u0087\3\2\2\2\u0088"+
		"\u0089\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008b\b\13\1\2\u008b\u008f\3"+
		"\2\2\2\u008c\u008d\7\32\2\2\u008d\u008f\b\13\1\2\u008ew\3\2\2\2\u008e"+
		"\u0082\3\2\2\2\u008e\u008c\3\2\2\2\u008f\25\3\2\2\2\u0090\u0091\5\30\r"+
		"\2\u0091\u0098\b\f\1\2\u0092\u0093\7\f\2\2\u0093\u0094\5\30\r\2\u0094"+
		"\u0095\b\f\1\2\u0095\u0097\3\2\2\2\u0096\u0092\3\2\2\2\u0097\u009a\3\2"+
		"\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\27\3\2\2\2\u009a\u0098"+
		"\3\2\2\2\u009b\u009c\5\"\22\2\u009c\u009d\b\r\1\2\u009d\31\3\2\2\2\u009e"+
		"\u009f\5\"\22\2\u009f\u00a0\7\22\2\2\u00a0\u00a2\7\33\2\2\u00a1\u00a3"+
		"\7\36\2\2\u00a2\u00a1\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a4\3\2\2\2"+
		"\u00a4\u00a5\b\16\1\2\u00a5\u00ac\3\2\2\2\u00a6\u00a8\7\33\2\2\u00a7\u00a9"+
		"\7\36\2\2\u00a8\u00a7\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00aa\3\2\2\2"+
		"\u00aa\u00ac\b\16\1\2\u00ab\u009e\3\2\2\2\u00ab\u00a6\3\2\2\2\u00ac\33"+
		"\3\2\2\2\u00ad\u00ae\5\36\20\2\u00ae\u00af\b\17\1\2\u00af\u00b1\3\2\2"+
		"\2\u00b0\u00ad\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b3"+
		"\3\2\2\2\u00b3\35\3\2\2\2\u00b4\u00b5\7\33\2\2\u00b5\u00b6\7\13\2\2\u00b6"+
		"\u00b7\5 \21\2\u00b7\u00b8\7\n\2\2\u00b8\u00b9\b\20\1\2\u00b9\37\3\2\2"+
		"\2\u00ba\u00bb\7\37\2\2\u00bb\u00bc\b\21\1\2\u00bc!\3\2\2\2\u00bd\u00be"+
		"\7\32\2\2\u00be\u00c4\b\22\1\2\u00bf\u00c0\7\33\2\2\u00c0\u00c4\b\22\1"+
		"\2\u00c1\u00c2\7\35\2\2\u00c2\u00c4\b\22\1\2\u00c3\u00bd\3\2\2\2\u00c3"+
		"\u00bf\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c4#\3\2\2\2\21\63LVemu~\u0088\u008e"+
		"\u0098\u00a2\u00a8\u00ab\u00b2\u00c3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}