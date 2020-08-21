// Generated from Function.g4 by ANTLR 4.7.2
package gen;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FunctionParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TYPE=1, VOID=2, TRUE=3, FALSE=4, RETURN=5, IF=6, ELSE=7, WHILE=8, FOR=9, 
		CIN=10, COUT=11, ENDL=12, L_PAR=13, R_PAR=14, L_BRACE=15, R_BRACE=16, 
		L_BRACKET=17, R_BRACKET=18, IN=19, OUT=20, EQUAL=21, LESS=22, LESS_EQ=23, 
		GREATER=24, GR_EQ=25, EQ=26, SEMI=27, COMMA=28, INC=29, DEC=30, PLUS=31, 
		MINUS=32, MULT=33, DIV=34, MOD=35, QUOTE=36, NUMBER=37, CHARS=38, NAME=39, 
		WS=40;
	public static final int
		RULE_name = 0, RULE_code = 1, RULE_statement = 2, RULE_function_header = 3, 
		RULE_type_foo = 4, RULE_arg = 5, RULE_args = 6, RULE_body = 7, RULE_declaration = 8, 
		RULE_assignment = 9, RULE_prefix = 10, RULE_return_statement = 11, RULE_read = 12, 
		RULE_write = 13, RULE_foo_in_foo = 14, RULE_ifElse = 15, RULE_ifBody = 16, 
		RULE_whileBody = 17, RULE_forBody = 18, RULE_in_par = 19, RULE_expression = 20, 
		RULE_bin_or_eq_expression = 21, RULE_bin_expression = 22, RULE_prefix_expression = 23, 
		RULE_bin_op = 24, RULE_eq_op = 25, RULE_prefix_op = 26, RULE_var = 27, 
		RULE_string = 28;
	private static String[] makeRuleNames() {
		return new String[] {
			"name", "code", "statement", "function_header", "type_foo", "arg", "args", 
			"body", "declaration", "assignment", "prefix", "return_statement", "read", 
			"write", "foo_in_foo", "ifElse", "ifBody", "whileBody", "forBody", "in_par", 
			"expression", "bin_or_eq_expression", "bin_expression", "prefix_expression", 
			"bin_op", "eq_op", "prefix_op", "var", "string"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'void'", "'true'", "'false'", "'return'", "'if'", "'else'", 
			"'while'", "'for'", "'std::cin'", "'std::cout'", "'std::endl'", "'('", 
			"')'", "'{'", "'}'", "'['", "']'", "'>>'", "'<<'", "'='", "'<'", "'<='", 
			"'>'", "'>='", "'=='", "';'", "','", "'++'", "'--'", "'+'", "'-'", "'*'", 
			"'/'", "'%'", "'\"'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "TYPE", "VOID", "TRUE", "FALSE", "RETURN", "IF", "ELSE", "WHILE", 
			"FOR", "CIN", "COUT", "ENDL", "L_PAR", "R_PAR", "L_BRACE", "R_BRACE", 
			"L_BRACKET", "R_BRACKET", "IN", "OUT", "EQUAL", "LESS", "LESS_EQ", "GREATER", 
			"GR_EQ", "EQ", "SEMI", "COMMA", "INC", "DEC", "PLUS", "MINUS", "MULT", 
			"DIV", "MOD", "QUOTE", "NUMBER", "CHARS", "NAME", "WS"
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
	public String getGrammarFileName() { return "Function.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public FunctionParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class NameContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(FunctionParser.NAME, 0); }
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionVisitor ) return ((FunctionVisitor<? extends T>)visitor).visitName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			match(NAME);
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

	public static class CodeContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(FunctionParser.EOF, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public CodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_code; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionVisitor ) return ((FunctionVisitor<? extends T>)visitor).visitCode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CodeContext code() throws RecognitionException {
		CodeContext _localctx = new CodeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_code);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TYPE || _la==VOID) {
				{
				{
				setState(60);
				statement();
				}
				}
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(66);
			match(EOF);
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

	public static class StatementContext extends ParserRuleContext {
		public Function_headerContext function_header() {
			return getRuleContext(Function_headerContext.class,0);
		}
		public TerminalNode L_BRACE() { return getToken(FunctionParser.L_BRACE, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode R_BRACE() { return getToken(FunctionParser.R_BRACE, 0); }
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionVisitor ) return ((FunctionVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			function_header();
			setState(69);
			match(L_BRACE);
			setState(70);
			body();
			setState(71);
			match(R_BRACE);
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

	public static class Function_headerContext extends ParserRuleContext {
		public Type_fooContext type_foo() {
			return getRuleContext(Type_fooContext.class,0);
		}
		public TerminalNode NAME() { return getToken(FunctionParser.NAME, 0); }
		public TerminalNode L_PAR() { return getToken(FunctionParser.L_PAR, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public TerminalNode R_PAR() { return getToken(FunctionParser.R_PAR, 0); }
		public Function_headerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_header; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionVisitor ) return ((FunctionVisitor<? extends T>)visitor).visitFunction_header(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_headerContext function_header() throws RecognitionException {
		Function_headerContext _localctx = new Function_headerContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_function_header);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			type_foo();
			setState(74);
			match(NAME);
			setState(75);
			match(L_PAR);
			setState(76);
			args();
			setState(77);
			match(R_PAR);
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

	public static class Type_fooContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(FunctionParser.TYPE, 0); }
		public TerminalNode VOID() { return getToken(FunctionParser.VOID, 0); }
		public Type_fooContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_foo; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionVisitor ) return ((FunctionVisitor<? extends T>)visitor).visitType_foo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_fooContext type_foo() throws RecognitionException {
		Type_fooContext _localctx = new Type_fooContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_type_foo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			_la = _input.LA(1);
			if ( !(_la==TYPE || _la==VOID) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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
		public TerminalNode TYPE() { return getToken(FunctionParser.TYPE, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public ArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arg; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionVisitor ) return ((FunctionVisitor<? extends T>)visitor).visitArg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgContext arg() throws RecognitionException {
		ArgContext _localctx = new ArgContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_arg);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(TYPE);
			setState(82);
			name();
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
		public List<ArgContext> arg() {
			return getRuleContexts(ArgContext.class);
		}
		public ArgContext arg(int i) {
			return getRuleContext(ArgContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(FunctionParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FunctionParser.COMMA, i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionVisitor ) return ((FunctionVisitor<? extends T>)visitor).visitArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPE) {
				{
				setState(84);
				arg();
				setState(89);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(85);
					match(COMMA);
					setState(86);
					arg();
					}
					}
					setState(91);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
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

	public static class BodyContext extends ParserRuleContext {
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public List<AssignmentContext> assignment() {
			return getRuleContexts(AssignmentContext.class);
		}
		public AssignmentContext assignment(int i) {
			return getRuleContext(AssignmentContext.class,i);
		}
		public List<PrefixContext> prefix() {
			return getRuleContexts(PrefixContext.class);
		}
		public PrefixContext prefix(int i) {
			return getRuleContext(PrefixContext.class,i);
		}
		public List<IfElseContext> ifElse() {
			return getRuleContexts(IfElseContext.class);
		}
		public IfElseContext ifElse(int i) {
			return getRuleContext(IfElseContext.class,i);
		}
		public List<WhileBodyContext> whileBody() {
			return getRuleContexts(WhileBodyContext.class);
		}
		public WhileBodyContext whileBody(int i) {
			return getRuleContext(WhileBodyContext.class,i);
		}
		public List<ForBodyContext> forBody() {
			return getRuleContexts(ForBodyContext.class);
		}
		public ForBodyContext forBody(int i) {
			return getRuleContext(ForBodyContext.class,i);
		}
		public List<ReadContext> read() {
			return getRuleContexts(ReadContext.class);
		}
		public ReadContext read(int i) {
			return getRuleContext(ReadContext.class,i);
		}
		public List<WriteContext> write() {
			return getRuleContexts(WriteContext.class);
		}
		public WriteContext write(int i) {
			return getRuleContext(WriteContext.class,i);
		}
		public List<Return_statementContext> return_statement() {
			return getRuleContexts(Return_statementContext.class);
		}
		public Return_statementContext return_statement(int i) {
			return getRuleContext(Return_statementContext.class,i);
		}
		public List<Foo_in_fooContext> foo_in_foo() {
			return getRuleContexts(Foo_in_fooContext.class);
		}
		public Foo_in_fooContext foo_in_foo(int i) {
			return getRuleContext(Foo_in_fooContext.class,i);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionVisitor ) return ((FunctionVisitor<? extends T>)visitor).visitBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TYPE) | (1L << RETURN) | (1L << IF) | (1L << WHILE) | (1L << FOR) | (1L << CIN) | (1L << COUT) | (1L << INC) | (1L << DEC) | (1L << NAME))) != 0)) {
				{
				setState(104);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					setState(94);
					declaration();
					}
					break;
				case 2:
					{
					setState(95);
					assignment();
					}
					break;
				case 3:
					{
					setState(96);
					prefix();
					}
					break;
				case 4:
					{
					setState(97);
					ifElse();
					}
					break;
				case 5:
					{
					setState(98);
					whileBody();
					}
					break;
				case 6:
					{
					setState(99);
					forBody();
					}
					break;
				case 7:
					{
					setState(100);
					read();
					}
					break;
				case 8:
					{
					setState(101);
					write();
					}
					break;
				case 9:
					{
					setState(102);
					return_statement();
					}
					break;
				case 10:
					{
					setState(103);
					foo_in_foo();
					}
					break;
				}
				}
				setState(108);
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

	public static class DeclarationContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(FunctionParser.TYPE, 0); }
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public TerminalNode SEMI() { return getToken(FunctionParser.SEMI, 0); }
		public List<TerminalNode> EQUAL() { return getTokens(FunctionParser.EQUAL); }
		public TerminalNode EQUAL(int i) {
			return getToken(FunctionParser.EQUAL, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(FunctionParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FunctionParser.COMMA, i);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionVisitor ) return ((FunctionVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			match(TYPE);
			setState(110);
			name();
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQUAL) {
				{
				setState(111);
				match(EQUAL);
				setState(112);
				expression();
				}
			}

			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(115);
				match(COMMA);
				setState(116);
				name();
				setState(119);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EQUAL) {
					{
					setState(117);
					match(EQUAL);
					setState(118);
					expression();
					}
				}

				}
				}
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(126);
			match(SEMI);
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

	public static class AssignmentContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(FunctionParser.EQUAL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(FunctionParser.SEMI, 0); }
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionVisitor ) return ((FunctionVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			name();
			setState(129);
			match(EQUAL);
			setState(130);
			expression();
			setState(131);
			match(SEMI);
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

	public static class PrefixContext extends ParserRuleContext {
		public Prefix_expressionContext prefix_expression() {
			return getRuleContext(Prefix_expressionContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(FunctionParser.SEMI, 0); }
		public PrefixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefix; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionVisitor ) return ((FunctionVisitor<? extends T>)visitor).visitPrefix(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrefixContext prefix() throws RecognitionException {
		PrefixContext _localctx = new PrefixContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_prefix);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			prefix_expression();
			setState(134);
			match(SEMI);
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

	public static class Return_statementContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(FunctionParser.RETURN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(FunctionParser.SEMI, 0); }
		public Return_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionVisitor ) return ((FunctionVisitor<? extends T>)visitor).visitReturn_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Return_statementContext return_statement() throws RecognitionException {
		Return_statementContext _localctx = new Return_statementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_return_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			match(RETURN);
			setState(137);
			expression();
			setState(138);
			match(SEMI);
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

	public static class ReadContext extends ParserRuleContext {
		public TerminalNode CIN() { return getToken(FunctionParser.CIN, 0); }
		public TerminalNode SEMI() { return getToken(FunctionParser.SEMI, 0); }
		public List<TerminalNode> IN() { return getTokens(FunctionParser.IN); }
		public TerminalNode IN(int i) {
			return getToken(FunctionParser.IN, i);
		}
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public ReadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_read; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionVisitor ) return ((FunctionVisitor<? extends T>)visitor).visitRead(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReadContext read() throws RecognitionException {
		ReadContext _localctx = new ReadContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_read);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			match(CIN);
			setState(143); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(141);
				match(IN);
				setState(142);
				name();
				}
				}
				setState(145); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IN );
			setState(147);
			match(SEMI);
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

	public static class WriteContext extends ParserRuleContext {
		public TerminalNode COUT() { return getToken(FunctionParser.COUT, 0); }
		public TerminalNode SEMI() { return getToken(FunctionParser.SEMI, 0); }
		public List<TerminalNode> OUT() { return getTokens(FunctionParser.OUT); }
		public TerminalNode OUT(int i) {
			return getToken(FunctionParser.OUT, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ENDL() { return getToken(FunctionParser.ENDL, 0); }
		public WriteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_write; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionVisitor ) return ((FunctionVisitor<? extends T>)visitor).visitWrite(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WriteContext write() throws RecognitionException {
		WriteContext _localctx = new WriteContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_write);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			match(COUT);
			setState(152); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(150);
					match(OUT);
					setState(151);
					expression();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(154); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OUT) {
				{
				setState(156);
				match(OUT);
				setState(157);
				match(ENDL);
				}
			}

			setState(160);
			match(SEMI);
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

	public static class Foo_in_fooContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(FunctionParser.NAME, 0); }
		public TerminalNode L_PAR() { return getToken(FunctionParser.L_PAR, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public TerminalNode R_PAR() { return getToken(FunctionParser.R_PAR, 0); }
		public TerminalNode SEMI() { return getToken(FunctionParser.SEMI, 0); }
		public Foo_in_fooContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_foo_in_foo; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionVisitor ) return ((FunctionVisitor<? extends T>)visitor).visitFoo_in_foo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Foo_in_fooContext foo_in_foo() throws RecognitionException {
		Foo_in_fooContext _localctx = new Foo_in_fooContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_foo_in_foo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			match(NAME);
			setState(163);
			match(L_PAR);
			setState(164);
			args();
			setState(165);
			match(R_PAR);
			setState(166);
			match(SEMI);
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

	public static class IfElseContext extends ParserRuleContext {
		public List<IfBodyContext> ifBody() {
			return getRuleContexts(IfBodyContext.class);
		}
		public IfBodyContext ifBody(int i) {
			return getRuleContext(IfBodyContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(FunctionParser.ELSE, 0); }
		public TerminalNode L_BRACE() { return getToken(FunctionParser.L_BRACE, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode R_BRACE() { return getToken(FunctionParser.R_BRACE, 0); }
		public IfElseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifElse; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionVisitor ) return ((FunctionVisitor<? extends T>)visitor).visitIfElse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfElseContext ifElse() throws RecognitionException {
		IfElseContext _localctx = new IfElseContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_ifElse);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			ifBody();
			setState(182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(169);
				match(ELSE);
				setState(180);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case TYPE:
				case RETURN:
				case IF:
				case WHILE:
				case FOR:
				case CIN:
				case COUT:
				case R_BRACE:
				case INC:
				case DEC:
				case NAME:
					{
					setState(173);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(170);
							ifBody();
							}
							} 
						}
						setState(175);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
					}
					}
					break;
				case L_BRACE:
					{
					setState(176);
					match(L_BRACE);
					setState(177);
					body();
					setState(178);
					match(R_BRACE);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
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

	public static class IfBodyContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(FunctionParser.IF, 0); }
		public In_parContext in_par() {
			return getRuleContext(In_parContext.class,0);
		}
		public TerminalNode L_BRACE() { return getToken(FunctionParser.L_BRACE, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode R_BRACE() { return getToken(FunctionParser.R_BRACE, 0); }
		public IfBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifBody; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionVisitor ) return ((FunctionVisitor<? extends T>)visitor).visitIfBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfBodyContext ifBody() throws RecognitionException {
		IfBodyContext _localctx = new IfBodyContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_ifBody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			match(IF);
			setState(185);
			in_par();
			setState(186);
			match(L_BRACE);
			setState(187);
			body();
			setState(188);
			match(R_BRACE);
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

	public static class WhileBodyContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(FunctionParser.WHILE, 0); }
		public In_parContext in_par() {
			return getRuleContext(In_parContext.class,0);
		}
		public TerminalNode L_BRACE() { return getToken(FunctionParser.L_BRACE, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode R_BRACE() { return getToken(FunctionParser.R_BRACE, 0); }
		public WhileBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileBody; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionVisitor ) return ((FunctionVisitor<? extends T>)visitor).visitWhileBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileBodyContext whileBody() throws RecognitionException {
		WhileBodyContext _localctx = new WhileBodyContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_whileBody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			match(WHILE);
			setState(191);
			in_par();
			setState(192);
			match(L_BRACE);
			setState(193);
			body();
			setState(194);
			match(R_BRACE);
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

	public static class ForBodyContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(FunctionParser.FOR, 0); }
		public TerminalNode L_PAR() { return getToken(FunctionParser.L_PAR, 0); }
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public Eq_opContext eq_op() {
			return getRuleContext(Eq_opContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(FunctionParser.SEMI, 0); }
		public TerminalNode R_PAR() { return getToken(FunctionParser.R_PAR, 0); }
		public TerminalNode L_BRACE() { return getToken(FunctionParser.L_BRACE, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode R_BRACE() { return getToken(FunctionParser.R_BRACE, 0); }
		public Bin_expressionContext bin_expression() {
			return getRuleContext(Bin_expressionContext.class,0);
		}
		public Prefix_expressionContext prefix_expression() {
			return getRuleContext(Prefix_expressionContext.class,0);
		}
		public ForBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forBody; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionVisitor ) return ((FunctionVisitor<? extends T>)visitor).visitForBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForBodyContext forBody() throws RecognitionException {
		ForBodyContext _localctx = new ForBodyContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_forBody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			match(FOR);
			setState(197);
			match(L_PAR);
			setState(198);
			declaration();
			setState(199);
			name();
			setState(200);
			eq_op();
			setState(201);
			expression();
			setState(202);
			match(SEMI);
			setState(205);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
			case FALSE:
			case NUMBER:
			case CHARS:
			case NAME:
				{
				setState(203);
				bin_expression();
				}
				break;
			case INC:
			case DEC:
				{
				setState(204);
				prefix_expression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(207);
			match(R_PAR);
			setState(208);
			match(L_BRACE);
			setState(209);
			body();
			setState(210);
			match(R_BRACE);
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

	public static class In_parContext extends ParserRuleContext {
		public TerminalNode L_PAR() { return getToken(FunctionParser.L_PAR, 0); }
		public TerminalNode R_PAR() { return getToken(FunctionParser.R_PAR, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Eq_opContext eq_op() {
			return getRuleContext(Eq_opContext.class,0);
		}
		public In_parContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_in_par; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionVisitor ) return ((FunctionVisitor<? extends T>)visitor).visitIn_par(this);
			else return visitor.visitChildren(this);
		}
	}

	public final In_parContext in_par() throws RecognitionException {
		In_parContext _localctx = new In_parContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_in_par);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			match(L_PAR);
			setState(218);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(213);
				expression();
				setState(214);
				eq_op();
				setState(215);
				expression();
				}
				break;
			case 2:
				{
				setState(217);
				expression();
				}
				break;
			}
			setState(220);
			match(R_PAR);
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

	public static class ExpressionContext extends ParserRuleContext {
		public Bin_or_eq_expressionContext bin_or_eq_expression() {
			return getRuleContext(Bin_or_eq_expressionContext.class,0);
		}
		public Prefix_expressionContext prefix_expression() {
			return getRuleContext(Prefix_expressionContext.class,0);
		}
		public TerminalNode TRUE() { return getToken(FunctionParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(FunctionParser.FALSE, 0); }
		public TerminalNode NUMBER() { return getToken(FunctionParser.NUMBER, 0); }
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionVisitor ) return ((FunctionVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_expression);
		try {
			setState(229);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(222);
				bin_or_eq_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(223);
				prefix_expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(224);
				match(TRUE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(225);
				match(FALSE);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(226);
				match(NUMBER);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(227);
				string();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(228);
				name();
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

	public static class Bin_or_eq_expressionContext extends ParserRuleContext {
		public List<VarContext> var() {
			return getRuleContexts(VarContext.class);
		}
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
		}
		public List<Bin_opContext> bin_op() {
			return getRuleContexts(Bin_opContext.class);
		}
		public Bin_opContext bin_op(int i) {
			return getRuleContext(Bin_opContext.class,i);
		}
		public List<Eq_opContext> eq_op() {
			return getRuleContexts(Eq_opContext.class);
		}
		public Eq_opContext eq_op(int i) {
			return getRuleContext(Eq_opContext.class,i);
		}
		public Bin_or_eq_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bin_or_eq_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionVisitor ) return ((FunctionVisitor<? extends T>)visitor).visitBin_or_eq_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bin_or_eq_expressionContext bin_or_eq_expression() throws RecognitionException {
		Bin_or_eq_expressionContext _localctx = new Bin_or_eq_expressionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_bin_or_eq_expression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			var();
			setState(238); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(234);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case PLUS:
					case MINUS:
					case MULT:
					case DIV:
					case MOD:
						{
						setState(232);
						bin_op();
						}
						break;
					case LESS:
					case LESS_EQ:
					case GREATER:
					case GR_EQ:
					case EQ:
						{
						setState(233);
						eq_op();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(236);
					var();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(240); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class Bin_expressionContext extends ParserRuleContext {
		public List<VarContext> var() {
			return getRuleContexts(VarContext.class);
		}
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
		}
		public List<Bin_opContext> bin_op() {
			return getRuleContexts(Bin_opContext.class);
		}
		public Bin_opContext bin_op(int i) {
			return getRuleContext(Bin_opContext.class,i);
		}
		public Bin_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bin_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionVisitor ) return ((FunctionVisitor<? extends T>)visitor).visitBin_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bin_expressionContext bin_expression() throws RecognitionException {
		Bin_expressionContext _localctx = new Bin_expressionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_bin_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			var();
			setState(246); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(243);
				bin_op();
				setState(244);
				var();
				}
				}
				setState(248); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << MULT) | (1L << DIV) | (1L << MOD))) != 0) );
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

	public static class Prefix_expressionContext extends ParserRuleContext {
		public Prefix_opContext prefix_op() {
			return getRuleContext(Prefix_opContext.class,0);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public Prefix_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefix_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionVisitor ) return ((FunctionVisitor<? extends T>)visitor).visitPrefix_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Prefix_expressionContext prefix_expression() throws RecognitionException {
		Prefix_expressionContext _localctx = new Prefix_expressionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_prefix_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			prefix_op();
			setState(251);
			name();
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

	public static class Bin_opContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(FunctionParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(FunctionParser.MINUS, 0); }
		public TerminalNode MULT() { return getToken(FunctionParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(FunctionParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(FunctionParser.MOD, 0); }
		public Bin_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bin_op; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionVisitor ) return ((FunctionVisitor<? extends T>)visitor).visitBin_op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bin_opContext bin_op() throws RecognitionException {
		Bin_opContext _localctx = new Bin_opContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_bin_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << MULT) | (1L << DIV) | (1L << MOD))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class Eq_opContext extends ParserRuleContext {
		public TerminalNode EQ() { return getToken(FunctionParser.EQ, 0); }
		public TerminalNode LESS() { return getToken(FunctionParser.LESS, 0); }
		public TerminalNode LESS_EQ() { return getToken(FunctionParser.LESS_EQ, 0); }
		public TerminalNode GREATER() { return getToken(FunctionParser.GREATER, 0); }
		public TerminalNode GR_EQ() { return getToken(FunctionParser.GR_EQ, 0); }
		public Eq_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eq_op; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionVisitor ) return ((FunctionVisitor<? extends T>)visitor).visitEq_op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Eq_opContext eq_op() throws RecognitionException {
		Eq_opContext _localctx = new Eq_opContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_eq_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LESS) | (1L << LESS_EQ) | (1L << GREATER) | (1L << GR_EQ) | (1L << EQ))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class Prefix_opContext extends ParserRuleContext {
		public TerminalNode INC() { return getToken(FunctionParser.INC, 0); }
		public TerminalNode DEC() { return getToken(FunctionParser.DEC, 0); }
		public Prefix_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefix_op; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionVisitor ) return ((FunctionVisitor<? extends T>)visitor).visitPrefix_op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Prefix_opContext prefix_op() throws RecognitionException {
		Prefix_opContext _localctx = new Prefix_opContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_prefix_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
			_la = _input.LA(1);
			if ( !(_la==INC || _la==DEC) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class VarContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(FunctionParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(FunctionParser.FALSE, 0); }
		public TerminalNode NUMBER() { return getToken(FunctionParser.NUMBER, 0); }
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionVisitor ) return ((FunctionVisitor<? extends T>)visitor).visitVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_var);
		try {
			setState(264);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
				enterOuterAlt(_localctx, 1);
				{
				setState(259);
				match(TRUE);
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 2);
				{
				setState(260);
				match(FALSE);
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 3);
				{
				setState(261);
				match(NUMBER);
				}
				break;
			case CHARS:
				enterOuterAlt(_localctx, 4);
				{
				setState(262);
				string();
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 5);
				{
				setState(263);
				name();
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

	public static class StringContext extends ParserRuleContext {
		public TerminalNode CHARS() { return getToken(FunctionParser.CHARS, 0); }
		public StringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FunctionVisitor ) return ((FunctionVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringContext string() throws RecognitionException {
		StringContext _localctx = new StringContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_string);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			match(CHARS);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3*\u010f\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\3\2\3\3\7\3@\n"+
		"\3\f\3\16\3C\13\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\7\bZ\n\b\f\b\16\b]\13\b\5\b_\n\b\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\tk\n\t\f\t\16\tn\13\t\3\n\3\n\3"+
		"\n\3\n\5\nt\n\n\3\n\3\n\3\n\3\n\5\nz\n\n\7\n|\n\n\f\n\16\n\177\13\n\3"+
		"\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16"+
		"\3\16\6\16\u0092\n\16\r\16\16\16\u0093\3\16\3\16\3\17\3\17\3\17\6\17\u009b"+
		"\n\17\r\17\16\17\u009c\3\17\3\17\5\17\u00a1\n\17\3\17\3\17\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\21\3\21\3\21\7\21\u00ae\n\21\f\21\16\21\u00b1\13"+
		"\21\3\21\3\21\3\21\3\21\5\21\u00b7\n\21\5\21\u00b9\n\21\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\5\24\u00d0\n\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\5\25\u00dd\n\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\5\26\u00e8\n\26\3\27\3\27\3\27\5\27\u00ed\n\27\3\27\3\27\6"+
		"\27\u00f1\n\27\r\27\16\27\u00f2\3\30\3\30\3\30\3\30\6\30\u00f9\n\30\r"+
		"\30\16\30\u00fa\3\31\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35"+
		"\3\35\3\35\3\35\5\35\u010b\n\35\3\36\3\36\3\36\2\2\37\2\4\6\b\n\f\16\20"+
		"\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:\2\6\3\2\3\4\3\2!%\3\2\30"+
		"\34\3\2\37 \2\u0116\2<\3\2\2\2\4A\3\2\2\2\6F\3\2\2\2\bK\3\2\2\2\nQ\3\2"+
		"\2\2\fS\3\2\2\2\16^\3\2\2\2\20l\3\2\2\2\22o\3\2\2\2\24\u0082\3\2\2\2\26"+
		"\u0087\3\2\2\2\30\u008a\3\2\2\2\32\u008e\3\2\2\2\34\u0097\3\2\2\2\36\u00a4"+
		"\3\2\2\2 \u00aa\3\2\2\2\"\u00ba\3\2\2\2$\u00c0\3\2\2\2&\u00c6\3\2\2\2"+
		"(\u00d6\3\2\2\2*\u00e7\3\2\2\2,\u00e9\3\2\2\2.\u00f4\3\2\2\2\60\u00fc"+
		"\3\2\2\2\62\u00ff\3\2\2\2\64\u0101\3\2\2\2\66\u0103\3\2\2\28\u010a\3\2"+
		"\2\2:\u010c\3\2\2\2<=\7)\2\2=\3\3\2\2\2>@\5\6\4\2?>\3\2\2\2@C\3\2\2\2"+
		"A?\3\2\2\2AB\3\2\2\2BD\3\2\2\2CA\3\2\2\2DE\7\2\2\3E\5\3\2\2\2FG\5\b\5"+
		"\2GH\7\21\2\2HI\5\20\t\2IJ\7\22\2\2J\7\3\2\2\2KL\5\n\6\2LM\7)\2\2MN\7"+
		"\17\2\2NO\5\16\b\2OP\7\20\2\2P\t\3\2\2\2QR\t\2\2\2R\13\3\2\2\2ST\7\3\2"+
		"\2TU\5\2\2\2U\r\3\2\2\2V[\5\f\7\2WX\7\36\2\2XZ\5\f\7\2YW\3\2\2\2Z]\3\2"+
		"\2\2[Y\3\2\2\2[\\\3\2\2\2\\_\3\2\2\2][\3\2\2\2^V\3\2\2\2^_\3\2\2\2_\17"+
		"\3\2\2\2`k\5\22\n\2ak\5\24\13\2bk\5\26\f\2ck\5 \21\2dk\5$\23\2ek\5&\24"+
		"\2fk\5\32\16\2gk\5\34\17\2hk\5\30\r\2ik\5\36\20\2j`\3\2\2\2ja\3\2\2\2"+
		"jb\3\2\2\2jc\3\2\2\2jd\3\2\2\2je\3\2\2\2jf\3\2\2\2jg\3\2\2\2jh\3\2\2\2"+
		"ji\3\2\2\2kn\3\2\2\2lj\3\2\2\2lm\3\2\2\2m\21\3\2\2\2nl\3\2\2\2op\7\3\2"+
		"\2ps\5\2\2\2qr\7\27\2\2rt\5*\26\2sq\3\2\2\2st\3\2\2\2t}\3\2\2\2uv\7\36"+
		"\2\2vy\5\2\2\2wx\7\27\2\2xz\5*\26\2yw\3\2\2\2yz\3\2\2\2z|\3\2\2\2{u\3"+
		"\2\2\2|\177\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\u0080\3\2\2\2\177}\3\2\2\2\u0080"+
		"\u0081\7\35\2\2\u0081\23\3\2\2\2\u0082\u0083\5\2\2\2\u0083\u0084\7\27"+
		"\2\2\u0084\u0085\5*\26\2\u0085\u0086\7\35\2\2\u0086\25\3\2\2\2\u0087\u0088"+
		"\5\60\31\2\u0088\u0089\7\35\2\2\u0089\27\3\2\2\2\u008a\u008b\7\7\2\2\u008b"+
		"\u008c\5*\26\2\u008c\u008d\7\35\2\2\u008d\31\3\2\2\2\u008e\u0091\7\f\2"+
		"\2\u008f\u0090\7\25\2\2\u0090\u0092\5\2\2\2\u0091\u008f\3\2\2\2\u0092"+
		"\u0093\3\2\2\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0095\3\2"+
		"\2\2\u0095\u0096\7\35\2\2\u0096\33\3\2\2\2\u0097\u009a\7\r\2\2\u0098\u0099"+
		"\7\26\2\2\u0099\u009b\5*\26\2\u009a\u0098\3\2\2\2\u009b\u009c\3\2\2\2"+
		"\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u00a0\3\2\2\2\u009e\u009f"+
		"\7\26\2\2\u009f\u00a1\7\16\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2"+
		"\u00a1\u00a2\3\2\2\2\u00a2\u00a3\7\35\2\2\u00a3\35\3\2\2\2\u00a4\u00a5"+
		"\7)\2\2\u00a5\u00a6\7\17\2\2\u00a6\u00a7\5\16\b\2\u00a7\u00a8\7\20\2\2"+
		"\u00a8\u00a9\7\35\2\2\u00a9\37\3\2\2\2\u00aa\u00b8\5\"\22\2\u00ab\u00b6"+
		"\7\t\2\2\u00ac\u00ae\5\"\22\2\u00ad\u00ac\3\2\2\2\u00ae\u00b1\3\2\2\2"+
		"\u00af\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b7\3\2\2\2\u00b1\u00af"+
		"\3\2\2\2\u00b2\u00b3\7\21\2\2\u00b3\u00b4\5\20\t\2\u00b4\u00b5\7\22\2"+
		"\2\u00b5\u00b7\3\2\2\2\u00b6\u00af\3\2\2\2\u00b6\u00b2\3\2\2\2\u00b7\u00b9"+
		"\3\2\2\2\u00b8\u00ab\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9!\3\2\2\2\u00ba"+
		"\u00bb\7\b\2\2\u00bb\u00bc\5(\25\2\u00bc\u00bd\7\21\2\2\u00bd\u00be\5"+
		"\20\t\2\u00be\u00bf\7\22\2\2\u00bf#\3\2\2\2\u00c0\u00c1\7\n\2\2\u00c1"+
		"\u00c2\5(\25\2\u00c2\u00c3\7\21\2\2\u00c3\u00c4\5\20\t\2\u00c4\u00c5\7"+
		"\22\2\2\u00c5%\3\2\2\2\u00c6\u00c7\7\13\2\2\u00c7\u00c8\7\17\2\2\u00c8"+
		"\u00c9\5\22\n\2\u00c9\u00ca\5\2\2\2\u00ca\u00cb\5\64\33\2\u00cb\u00cc"+
		"\5*\26\2\u00cc\u00cf\7\35\2\2\u00cd\u00d0\5.\30\2\u00ce\u00d0\5\60\31"+
		"\2\u00cf\u00cd\3\2\2\2\u00cf\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d2"+
		"\7\20\2\2\u00d2\u00d3\7\21\2\2\u00d3\u00d4\5\20\t\2\u00d4\u00d5\7\22\2"+
		"\2\u00d5\'\3\2\2\2\u00d6\u00dc\7\17\2\2\u00d7\u00d8\5*\26\2\u00d8\u00d9"+
		"\5\64\33\2\u00d9\u00da\5*\26\2\u00da\u00dd\3\2\2\2\u00db\u00dd\5*\26\2"+
		"\u00dc\u00d7\3\2\2\2\u00dc\u00db\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00df"+
		"\7\20\2\2\u00df)\3\2\2\2\u00e0\u00e8\5,\27\2\u00e1\u00e8\5\60\31\2\u00e2"+
		"\u00e8\7\5\2\2\u00e3\u00e8\7\6\2\2\u00e4\u00e8\7\'\2\2\u00e5\u00e8\5:"+
		"\36\2\u00e6\u00e8\5\2\2\2\u00e7\u00e0\3\2\2\2\u00e7\u00e1\3\2\2\2\u00e7"+
		"\u00e2\3\2\2\2\u00e7\u00e3\3\2\2\2\u00e7\u00e4\3\2\2\2\u00e7\u00e5\3\2"+
		"\2\2\u00e7\u00e6\3\2\2\2\u00e8+\3\2\2\2\u00e9\u00f0\58\35\2\u00ea\u00ed"+
		"\5\62\32\2\u00eb\u00ed\5\64\33\2\u00ec\u00ea\3\2\2\2\u00ec\u00eb\3\2\2"+
		"\2\u00ed\u00ee\3\2\2\2\u00ee\u00ef\58\35\2\u00ef\u00f1\3\2\2\2\u00f0\u00ec"+
		"\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3"+
		"-\3\2\2\2\u00f4\u00f8\58\35\2\u00f5\u00f6\5\62\32\2\u00f6\u00f7\58\35"+
		"\2\u00f7\u00f9\3\2\2\2\u00f8\u00f5\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00f8"+
		"\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb/\3\2\2\2\u00fc\u00fd\5\66\34\2\u00fd"+
		"\u00fe\5\2\2\2\u00fe\61\3\2\2\2\u00ff\u0100\t\3\2\2\u0100\63\3\2\2\2\u0101"+
		"\u0102\t\4\2\2\u0102\65\3\2\2\2\u0103\u0104\t\5\2\2\u0104\67\3\2\2\2\u0105"+
		"\u010b\7\5\2\2\u0106\u010b\7\6\2\2\u0107\u010b\7\'\2\2\u0108\u010b\5:"+
		"\36\2\u0109\u010b\5\2\2\2\u010a\u0105\3\2\2\2\u010a\u0106\3\2\2\2\u010a"+
		"\u0107\3\2\2\2\u010a\u0108\3\2\2\2\u010a\u0109\3\2\2\2\u010b9\3\2\2\2"+
		"\u010c\u010d\7(\2\2\u010d;\3\2\2\2\27A[^jlsy}\u0093\u009c\u00a0\u00af"+
		"\u00b6\u00b8\u00cf\u00dc\u00e7\u00ec\u00f2\u00fa\u010a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}