// Generated from Function.g4 by ANTLR 4.7.2
package gen;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FunctionLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"INT", "BOOL", "STRING", "TYPE", "VOID", "TRUE", "FALSE", "RETURN", "IF", 
			"ELSE", "WHILE", "FOR", "CIN", "COUT", "ENDL", "L_PAR", "R_PAR", "L_BRACE", 
			"R_BRACE", "L_BRACKET", "R_BRACKET", "IN", "OUT", "EQUAL", "LESS", "LESS_EQ", 
			"GREATER", "GR_EQ", "EQ", "SEMI", "COMMA", "INC", "DEC", "PLUS", "MINUS", 
			"MULT", "DIV", "MOD", "QUOTE", "DIGIT", "LETTER", "NUMBER", "CHARS", 
			"NAME", "WS"
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


	public FunctionLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Function.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2*\u0116\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\5\5v\n\5\3\6\3\6\3\6\3\6\3"+
		"\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r"+
		"\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3"+
		"\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3"+
		"\33\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3!\3"+
		"\"\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\6+\u00fa"+
		"\n+\r+\16+\u00fb\3,\3,\7,\u0100\n,\f,\16,\u0103\13,\3,\3,\3-\3-\3-\3-"+
		"\7-\u010b\n-\f-\16-\u010e\13-\3.\6.\u0111\n.\r.\16.\u0112\3.\3.\3\u0101"+
		"\2/\3\2\5\2\7\2\t\3\13\4\r\5\17\6\21\7\23\b\25\t\27\n\31\13\33\f\35\r"+
		"\37\16!\17#\20%\21\'\22)\23+\24-\25/\26\61\27\63\30\65\31\67\329\33;\34"+
		"=\35?\36A\37C E!G\"I#K$M%O&Q\2S\2U\'W(Y)[*\3\2\5\3\2\62;\4\2C\\c|\5\2"+
		"\13\f\17\17\"\"\2\u0118\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2"+
		"\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2"+
		"\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2"+
		"\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2"+
		"\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2"+
		"\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2["+
		"\3\2\2\2\3]\3\2\2\2\5a\3\2\2\2\7f\3\2\2\2\tu\3\2\2\2\13w\3\2\2\2\r|\3"+
		"\2\2\2\17\u0081\3\2\2\2\21\u0087\3\2\2\2\23\u008e\3\2\2\2\25\u0091\3\2"+
		"\2\2\27\u0096\3\2\2\2\31\u009c\3\2\2\2\33\u00a0\3\2\2\2\35\u00a9\3\2\2"+
		"\2\37\u00b3\3\2\2\2!\u00bd\3\2\2\2#\u00bf\3\2\2\2%\u00c1\3\2\2\2\'\u00c3"+
		"\3\2\2\2)\u00c5\3\2\2\2+\u00c7\3\2\2\2-\u00c9\3\2\2\2/\u00cc\3\2\2\2\61"+
		"\u00cf\3\2\2\2\63\u00d1\3\2\2\2\65\u00d3\3\2\2\2\67\u00d6\3\2\2\29\u00d8"+
		"\3\2\2\2;\u00db\3\2\2\2=\u00de\3\2\2\2?\u00e0\3\2\2\2A\u00e2\3\2\2\2C"+
		"\u00e5\3\2\2\2E\u00e8\3\2\2\2G\u00ea\3\2\2\2I\u00ec\3\2\2\2K\u00ee\3\2"+
		"\2\2M\u00f0\3\2\2\2O\u00f2\3\2\2\2Q\u00f4\3\2\2\2S\u00f6\3\2\2\2U\u00f9"+
		"\3\2\2\2W\u00fd\3\2\2\2Y\u0106\3\2\2\2[\u0110\3\2\2\2]^\7k\2\2^_\7p\2"+
		"\2_`\7v\2\2`\4\3\2\2\2ab\7d\2\2bc\7q\2\2cd\7q\2\2de\7n\2\2e\6\3\2\2\2"+
		"fg\7u\2\2gh\7v\2\2hi\7f\2\2ij\7<\2\2jk\7<\2\2kl\7u\2\2lm\7v\2\2mn\7t\2"+
		"\2no\7k\2\2op\7p\2\2pq\7i\2\2q\b\3\2\2\2rv\5\3\2\2sv\5\5\3\2tv\5\7\4\2"+
		"ur\3\2\2\2us\3\2\2\2ut\3\2\2\2v\n\3\2\2\2wx\7x\2\2xy\7q\2\2yz\7k\2\2z"+
		"{\7f\2\2{\f\3\2\2\2|}\7v\2\2}~\7t\2\2~\177\7w\2\2\177\u0080\7g\2\2\u0080"+
		"\16\3\2\2\2\u0081\u0082\7h\2\2\u0082\u0083\7c\2\2\u0083\u0084\7n\2\2\u0084"+
		"\u0085\7u\2\2\u0085\u0086\7g\2\2\u0086\20\3\2\2\2\u0087\u0088\7t\2\2\u0088"+
		"\u0089\7g\2\2\u0089\u008a\7v\2\2\u008a\u008b\7w\2\2\u008b\u008c\7t\2\2"+
		"\u008c\u008d\7p\2\2\u008d\22\3\2\2\2\u008e\u008f\7k\2\2\u008f\u0090\7"+
		"h\2\2\u0090\24\3\2\2\2\u0091\u0092\7g\2\2\u0092\u0093\7n\2\2\u0093\u0094"+
		"\7u\2\2\u0094\u0095\7g\2\2\u0095\26\3\2\2\2\u0096\u0097\7y\2\2\u0097\u0098"+
		"\7j\2\2\u0098\u0099\7k\2\2\u0099\u009a\7n\2\2\u009a\u009b\7g\2\2\u009b"+
		"\30\3\2\2\2\u009c\u009d\7h\2\2\u009d\u009e\7q\2\2\u009e\u009f\7t\2\2\u009f"+
		"\32\3\2\2\2\u00a0\u00a1\7u\2\2\u00a1\u00a2\7v\2\2\u00a2\u00a3\7f\2\2\u00a3"+
		"\u00a4\7<\2\2\u00a4\u00a5\7<\2\2\u00a5\u00a6\7e\2\2\u00a6\u00a7\7k\2\2"+
		"\u00a7\u00a8\7p\2\2\u00a8\34\3\2\2\2\u00a9\u00aa\7u\2\2\u00aa\u00ab\7"+
		"v\2\2\u00ab\u00ac\7f\2\2\u00ac\u00ad\7<\2\2\u00ad\u00ae\7<\2\2\u00ae\u00af"+
		"\7e\2\2\u00af\u00b0\7q\2\2\u00b0\u00b1\7w\2\2\u00b1\u00b2\7v\2\2\u00b2"+
		"\36\3\2\2\2\u00b3\u00b4\7u\2\2\u00b4\u00b5\7v\2\2\u00b5\u00b6\7f\2\2\u00b6"+
		"\u00b7\7<\2\2\u00b7\u00b8\7<\2\2\u00b8\u00b9\7g\2\2\u00b9\u00ba\7p\2\2"+
		"\u00ba\u00bb\7f\2\2\u00bb\u00bc\7n\2\2\u00bc \3\2\2\2\u00bd\u00be\7*\2"+
		"\2\u00be\"\3\2\2\2\u00bf\u00c0\7+\2\2\u00c0$\3\2\2\2\u00c1\u00c2\7}\2"+
		"\2\u00c2&\3\2\2\2\u00c3\u00c4\7\177\2\2\u00c4(\3\2\2\2\u00c5\u00c6\7]"+
		"\2\2\u00c6*\3\2\2\2\u00c7\u00c8\7_\2\2\u00c8,\3\2\2\2\u00c9\u00ca\7@\2"+
		"\2\u00ca\u00cb\7@\2\2\u00cb.\3\2\2\2\u00cc\u00cd\7>\2\2\u00cd\u00ce\7"+
		">\2\2\u00ce\60\3\2\2\2\u00cf\u00d0\7?\2\2\u00d0\62\3\2\2\2\u00d1\u00d2"+
		"\7>\2\2\u00d2\64\3\2\2\2\u00d3\u00d4\7>\2\2\u00d4\u00d5\7?\2\2\u00d5\66"+
		"\3\2\2\2\u00d6\u00d7\7@\2\2\u00d78\3\2\2\2\u00d8\u00d9\7@\2\2\u00d9\u00da"+
		"\7?\2\2\u00da:\3\2\2\2\u00db\u00dc\7?\2\2\u00dc\u00dd\7?\2\2\u00dd<\3"+
		"\2\2\2\u00de\u00df\7=\2\2\u00df>\3\2\2\2\u00e0\u00e1\7.\2\2\u00e1@\3\2"+
		"\2\2\u00e2\u00e3\7-\2\2\u00e3\u00e4\7-\2\2\u00e4B\3\2\2\2\u00e5\u00e6"+
		"\7/\2\2\u00e6\u00e7\7/\2\2\u00e7D\3\2\2\2\u00e8\u00e9\7-\2\2\u00e9F\3"+
		"\2\2\2\u00ea\u00eb\7/\2\2\u00ebH\3\2\2\2\u00ec\u00ed\7,\2\2\u00edJ\3\2"+
		"\2\2\u00ee\u00ef\7\61\2\2\u00efL\3\2\2\2\u00f0\u00f1\7\'\2\2\u00f1N\3"+
		"\2\2\2\u00f2\u00f3\7$\2\2\u00f3P\3\2\2\2\u00f4\u00f5\t\2\2\2\u00f5R\3"+
		"\2\2\2\u00f6\u00f7\t\3\2\2\u00f7T\3\2\2\2\u00f8\u00fa\5Q)\2\u00f9\u00f8"+
		"\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc"+
		"V\3\2\2\2\u00fd\u0101\7$\2\2\u00fe\u0100\13\2\2\2\u00ff\u00fe\3\2\2\2"+
		"\u0100\u0103\3\2\2\2\u0101\u0102\3\2\2\2\u0101\u00ff\3\2\2\2\u0102\u0104"+
		"\3\2\2\2\u0103\u0101\3\2\2\2\u0104\u0105\7$\2\2\u0105X\3\2\2\2\u0106\u010c"+
		"\5S*\2\u0107\u010b\5S*\2\u0108\u010b\5Q)\2\u0109\u010b\7a\2\2\u010a\u0107"+
		"\3\2\2\2\u010a\u0108\3\2\2\2\u010a\u0109\3\2\2\2\u010b\u010e\3\2\2\2\u010c"+
		"\u010a\3\2\2\2\u010c\u010d\3\2\2\2\u010dZ\3\2\2\2\u010e\u010c\3\2\2\2"+
		"\u010f\u0111\t\4\2\2\u0110\u010f\3\2\2\2\u0111\u0112\3\2\2\2\u0112\u0110"+
		"\3\2\2\2\u0112\u0113\3\2\2\2\u0113\u0114\3\2\2\2\u0114\u0115\b.\2\2\u0115"+
		"\\\3\2\2\2\t\2u\u00fb\u0101\u010a\u010c\u0112\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}