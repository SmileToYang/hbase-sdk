// Generated from ./HBaseSQL.g4 by ANTLR 4.5.1

package com.github.CCwexiao.hbase.sdk.dsl.antlr;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class HBaseSQLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, STAR=4, LB=5, RB=6, WHERE=7, SELECT=8, INSERT=9, 
		DELETE=10, INTO=11, VALUES=12, FROM=13, ROWKEY=14, STARTKEY=15, ENDKEY=16, 
		HBASESTARTKEY=17, HBASEENDKEY=18, MAXVERSION=19, LIMIT=20, TS=21, STARTTS=22, 
		ENDTS=23, IS=24, NULL=25, NOT=26, AND=27, OR=28, LESSEQUAL=29, LESS=30, 
		GREATEREQUAL=31, GREATER=32, NOTEQUAL=33, EQUAL=34, ENDER=35, NOTMATCH=36, 
		MATCH=37, IN=38, NOTIN=39, BETWEEN=40, NOTBETWEEN=41, ISNULL=42, ISNOTNULL=43, 
		ISMISSING=44, ISNOTMISSING=45, TEXT=46, SPACE=47, COMMENT_INPUT=48, LINE_COMMENT=49;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "STAR", "LB", "RB", "WHERE", "SELECT", "INSERT", 
		"DELETE", "INTO", "VALUES", "FROM", "ROWKEY", "STARTKEY", "ENDKEY", "HBASESTARTKEY", 
		"HBASEENDKEY", "MAXVERSION", "LIMIT", "TS", "STARTTS", "ENDTS", "IS", 
		"NULL", "NOT", "AND", "OR", "LESSEQUAL", "LESS", "GREATEREQUAL", "GREATER", 
		"NOTEQUAL", "EQUAL", "ENDER", "NOTMATCH", "MATCH", "IN", "NOTIN", "BETWEEN", 
		"NOTBETWEEN", "ISNULL", "ISNOTNULL", "ISMISSING", "ISNOTMISSING", "TEXT", 
		"SPACE", "COMMENT_INPUT", "LINE_COMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "','", "'''", "'#'", "'*'", "'('", "')'", null, null, null, null, 
		null, null, null, null, null, null, "'hbasestartkey'", "'hbaseendkey'", 
		null, null, "'ts'", "'startTS'", "'endTS'", null, "'null'", null, null, 
		null, "'lessequal'", "'less'", "'greaterequal'", "'greater'", "'notequal'", 
		"'equal'", "';'", "'notmatch'", "'match'", "'in'", "'notin'", "'between'", 
		"'notbetween'", "'isnull'", "'isnotnull'", "'ismissing'", "'isnotmissing'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, "STAR", "LB", "RB", "WHERE", "SELECT", "INSERT", 
		"DELETE", "INTO", "VALUES", "FROM", "ROWKEY", "STARTKEY", "ENDKEY", "HBASESTARTKEY", 
		"HBASEENDKEY", "MAXVERSION", "LIMIT", "TS", "STARTTS", "ENDTS", "IS", 
		"NULL", "NOT", "AND", "OR", "LESSEQUAL", "LESS", "GREATEREQUAL", "GREATER", 
		"NOTEQUAL", "EQUAL", "ENDER", "NOTMATCH", "MATCH", "IN", "NOTIN", "BETWEEN", 
		"NOTBETWEEN", "ISNULL", "ISNOTNULL", "ISMISSING", "ISNOTMISSING", "TEXT", 
		"SPACE", "COMMENT_INPUT", "LINE_COMMENT"
	};
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


	public HBaseSQLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "HBaseSQL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\63\u0228\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\3\2\3\2\3\3\3"+
		"\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\5\b|\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u008a"+
		"\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0098\n\n\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00a6\n\13"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00b0\n\f\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00be\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\5\16\u00c8\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\5\17\u00d6\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00e8\n\20\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00f6\n\21\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\5\24\u0126\n\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\5\25\u0132\n\25\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\5\31\u0149\n\31"+
		"\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u0156\n\33"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u015e\n\34\3\35\3\35\3\35\3\35\5\35"+
		"\u0164\n\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37"+
		"\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3!"+
		"\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3$\3$"+
		"\3%\3%\3%\3%\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3(\3(\3(\3("+
		"\3(\3(\3)\3)\3)\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3+\3+"+
		"\3+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3-\3-\3-\3-\3-\3-\3-\3-"+
		"\3-\3-\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3/\6/\u01ef\n/\r/\16/\u01f0"+
		"\3\60\6\60\u01f4\n\60\r\60\16\60\u01f5\3\60\3\60\3\61\3\61\3\61\3\61\7"+
		"\61\u01fe\n\61\f\61\16\61\u0201\13\61\3\61\3\61\3\61\3\61\3\61\3\62\3"+
		"\62\3\62\3\62\5\62\u020c\n\62\3\62\7\62\u020f\n\62\f\62\16\62\u0212\13"+
		"\62\3\62\5\62\u0215\n\62\3\62\3\62\5\62\u0219\n\62\3\62\3\62\3\62\3\62"+
		"\5\62\u021f\n\62\3\62\3\62\5\62\u0223\n\62\5\62\u0225\n\62\3\62\3\62\3"+
		"\u01ff\2\63\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33"+
		"\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67"+
		"\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63\3\2\5\r"+
		"\2\17\17#(*.\60\60\62<>@B\\^^`|~~\u0080\u0080\5\2\13\f\17\17\"\"\4\2\f"+
		"\f\17\17\u0241\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3"+
		"\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2"+
		"\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3"+
		"\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2"+
		"\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\2"+
		"9\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3"+
		"\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2"+
		"\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2"+
		"_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\3e\3\2\2\2\5g\3\2\2\2\7i\3\2\2\2\tk\3"+
		"\2\2\2\13m\3\2\2\2\ro\3\2\2\2\17{\3\2\2\2\21\u0089\3\2\2\2\23\u0097\3"+
		"\2\2\2\25\u00a5\3\2\2\2\27\u00af\3\2\2\2\31\u00bd\3\2\2\2\33\u00c7\3\2"+
		"\2\2\35\u00d5\3\2\2\2\37\u00e7\3\2\2\2!\u00f5\3\2\2\2#\u00f7\3\2\2\2%"+
		"\u0105\3\2\2\2\'\u0125\3\2\2\2)\u0131\3\2\2\2+\u0133\3\2\2\2-\u0136\3"+
		"\2\2\2/\u013e\3\2\2\2\61\u0148\3\2\2\2\63\u014a\3\2\2\2\65\u0155\3\2\2"+
		"\2\67\u015d\3\2\2\29\u0163\3\2\2\2;\u0165\3\2\2\2=\u016f\3\2\2\2?\u0174"+
		"\3\2\2\2A\u0181\3\2\2\2C\u0189\3\2\2\2E\u0192\3\2\2\2G\u0198\3\2\2\2I"+
		"\u019a\3\2\2\2K\u01a3\3\2\2\2M\u01a9\3\2\2\2O\u01ac\3\2\2\2Q\u01b2\3\2"+
		"\2\2S\u01ba\3\2\2\2U\u01c5\3\2\2\2W\u01cc\3\2\2\2Y\u01d6\3\2\2\2[\u01e0"+
		"\3\2\2\2]\u01ee\3\2\2\2_\u01f3\3\2\2\2a\u01f9\3\2\2\2c\u0224\3\2\2\2e"+
		"f\7.\2\2f\4\3\2\2\2gh\7)\2\2h\6\3\2\2\2ij\7%\2\2j\b\3\2\2\2kl\7,\2\2l"+
		"\n\3\2\2\2mn\7*\2\2n\f\3\2\2\2op\7+\2\2p\16\3\2\2\2qr\7y\2\2rs\7j\2\2"+
		"st\7g\2\2tu\7t\2\2u|\7g\2\2vw\7Y\2\2wx\7J\2\2xy\7G\2\2yz\7T\2\2z|\7G\2"+
		"\2{q\3\2\2\2{v\3\2\2\2|\20\3\2\2\2}~\7u\2\2~\177\7g\2\2\177\u0080\7n\2"+
		"\2\u0080\u0081\7g\2\2\u0081\u0082\7e\2\2\u0082\u008a\7v\2\2\u0083\u0084"+
		"\7U\2\2\u0084\u0085\7G\2\2\u0085\u0086\7N\2\2\u0086\u0087\7G\2\2\u0087"+
		"\u0088\7E\2\2\u0088\u008a\7V\2\2\u0089}\3\2\2\2\u0089\u0083\3\2\2\2\u008a"+
		"\22\3\2\2\2\u008b\u008c\7k\2\2\u008c\u008d\7p\2\2\u008d\u008e\7u\2\2\u008e"+
		"\u008f\7g\2\2\u008f\u0090\7t\2\2\u0090\u0098\7v\2\2\u0091\u0092\7K\2\2"+
		"\u0092\u0093\7P\2\2\u0093\u0094\7U\2\2\u0094\u0095\7G\2\2\u0095\u0096"+
		"\7T\2\2\u0096\u0098\7V\2\2\u0097\u008b\3\2\2\2\u0097\u0091\3\2\2\2\u0098"+
		"\24\3\2\2\2\u0099\u009a\7f\2\2\u009a\u009b\7g\2\2\u009b\u009c\7n\2\2\u009c"+
		"\u009d\7g\2\2\u009d\u009e\7v\2\2\u009e\u00a6\7g\2\2\u009f\u00a0\7F\2\2"+
		"\u00a0\u00a1\7G\2\2\u00a1\u00a2\7N\2\2\u00a2\u00a3\7G\2\2\u00a3\u00a4"+
		"\7V\2\2\u00a4\u00a6\7G\2\2\u00a5\u0099\3\2\2\2\u00a5\u009f\3\2\2\2\u00a6"+
		"\26\3\2\2\2\u00a7\u00a8\7k\2\2\u00a8\u00a9\7p\2\2\u00a9\u00aa\7v\2\2\u00aa"+
		"\u00b0\7q\2\2\u00ab\u00ac\7K\2\2\u00ac\u00ad\7P\2\2\u00ad\u00ae\7V\2\2"+
		"\u00ae\u00b0\7Q\2\2\u00af\u00a7\3\2\2\2\u00af\u00ab\3\2\2\2\u00b0\30\3"+
		"\2\2\2\u00b1\u00b2\7x\2\2\u00b2\u00b3\7c\2\2\u00b3\u00b4\7n\2\2\u00b4"+
		"\u00b5\7w\2\2\u00b5\u00b6\7g\2\2\u00b6\u00be\7u\2\2\u00b7\u00b8\7X\2\2"+
		"\u00b8\u00b9\7C\2\2\u00b9\u00ba\7N\2\2\u00ba\u00bb\7W\2\2\u00bb\u00bc"+
		"\7G\2\2\u00bc\u00be\7U\2\2\u00bd\u00b1\3\2\2\2\u00bd\u00b7\3\2\2\2\u00be"+
		"\32\3\2\2\2\u00bf\u00c0\7h\2\2\u00c0\u00c1\7t\2\2\u00c1\u00c2\7q\2\2\u00c2"+
		"\u00c8\7o\2\2\u00c3\u00c4\7H\2\2\u00c4\u00c5\7T\2\2\u00c5\u00c6\7Q\2\2"+
		"\u00c6\u00c8\7O\2\2\u00c7\u00bf\3\2\2\2\u00c7\u00c3\3\2\2\2\u00c8\34\3"+
		"\2\2\2\u00c9\u00ca\7t\2\2\u00ca\u00cb\7q\2\2\u00cb\u00cc\7y\2\2\u00cc"+
		"\u00cd\7m\2\2\u00cd\u00ce\7g\2\2\u00ce\u00d6\7{\2\2\u00cf\u00d0\7t\2\2"+
		"\u00d0\u00d1\7q\2\2\u00d1\u00d2\7y\2\2\u00d2\u00d3\7M\2\2\u00d3\u00d4"+
		"\7g\2\2\u00d4\u00d6\7{\2\2\u00d5\u00c9\3\2\2\2\u00d5\u00cf\3\2\2\2\u00d6"+
		"\36\3\2\2\2\u00d7\u00d8\7u\2\2\u00d8\u00d9\7v\2\2\u00d9\u00da\7c\2\2\u00da"+
		"\u00db\7t\2\2\u00db\u00dc\7v\2\2\u00dc\u00dd\7m\2\2\u00dd\u00de\7g\2\2"+
		"\u00de\u00e8\7{\2\2\u00df\u00e0\7u\2\2\u00e0\u00e1\7v\2\2\u00e1\u00e2"+
		"\7c\2\2\u00e2\u00e3\7t\2\2\u00e3\u00e4\7v\2\2\u00e4\u00e5\7M\2\2\u00e5"+
		"\u00e6\7g\2\2\u00e6\u00e8\7{\2\2\u00e7\u00d7\3\2\2\2\u00e7\u00df\3\2\2"+
		"\2\u00e8 \3\2\2\2\u00e9\u00ea\7g\2\2\u00ea\u00eb\7p\2\2\u00eb\u00ec\7"+
		"f\2\2\u00ec\u00ed\7m\2\2\u00ed\u00ee\7g\2\2\u00ee\u00f6\7{\2\2\u00ef\u00f0"+
		"\7g\2\2\u00f0\u00f1\7p\2\2\u00f1\u00f2\7f\2\2\u00f2\u00f3\7M\2\2\u00f3"+
		"\u00f4\7g\2\2\u00f4\u00f6\7{\2\2\u00f5\u00e9\3\2\2\2\u00f5\u00ef\3\2\2"+
		"\2\u00f6\"\3\2\2\2\u00f7\u00f8\7j\2\2\u00f8\u00f9\7d\2\2\u00f9\u00fa\7"+
		"c\2\2\u00fa\u00fb\7u\2\2\u00fb\u00fc\7g\2\2\u00fc\u00fd\7u\2\2\u00fd\u00fe"+
		"\7v\2\2\u00fe\u00ff\7c\2\2\u00ff\u0100\7t\2\2\u0100\u0101\7v\2\2\u0101"+
		"\u0102\7m\2\2\u0102\u0103\7g\2\2\u0103\u0104\7{\2\2\u0104$\3\2\2\2\u0105"+
		"\u0106\7j\2\2\u0106\u0107\7d\2\2\u0107\u0108\7c\2\2\u0108\u0109\7u\2\2"+
		"\u0109\u010a\7g\2\2\u010a\u010b\7g\2\2\u010b\u010c\7p\2\2\u010c\u010d"+
		"\7f\2\2\u010d\u010e\7m\2\2\u010e\u010f\7g\2\2\u010f\u0110\7{\2\2\u0110"+
		"&\3\2\2\2\u0111\u0112\7o\2\2\u0112\u0113\7c\2\2\u0113\u0114\7z\2\2\u0114"+
		"\u0115\7x\2\2\u0115\u0116\7g\2\2\u0116\u0117\7t\2\2\u0117\u0118\7u\2\2"+
		"\u0118\u0119\7k\2\2\u0119\u011a\7q\2\2\u011a\u0126\7p\2\2\u011b\u011c"+
		"\7o\2\2\u011c\u011d\7c\2\2\u011d\u011e\7z\2\2\u011e\u011f\7X\2\2\u011f"+
		"\u0120\7g\2\2\u0120\u0121\7t\2\2\u0121\u0122\7u\2\2\u0122\u0123\7k\2\2"+
		"\u0123\u0124\7q\2\2\u0124\u0126\7p\2\2\u0125\u0111\3\2\2\2\u0125\u011b"+
		"\3\2\2\2\u0126(\3\2\2\2\u0127\u0128\7n\2\2\u0128\u0129\7k\2\2\u0129\u012a"+
		"\7o\2\2\u012a\u012b\7k\2\2\u012b\u0132\7v\2\2\u012c\u012d\7N\2\2\u012d"+
		"\u012e\7K\2\2\u012e\u012f\7O\2\2\u012f\u0130\7K\2\2\u0130\u0132\7V\2\2"+
		"\u0131\u0127\3\2\2\2\u0131\u012c\3\2\2\2\u0132*\3\2\2\2\u0133\u0134\7"+
		"v\2\2\u0134\u0135\7u\2\2\u0135,\3\2\2\2\u0136\u0137\7u\2\2\u0137\u0138"+
		"\7v\2\2\u0138\u0139\7c\2\2\u0139\u013a\7t\2\2\u013a\u013b\7v\2\2\u013b"+
		"\u013c\7V\2\2\u013c\u013d\7U\2\2\u013d.\3\2\2\2\u013e\u013f\7g\2\2\u013f"+
		"\u0140\7p\2\2\u0140\u0141\7f\2\2\u0141\u0142\7V\2\2\u0142\u0143\7U\2\2"+
		"\u0143\60\3\2\2\2\u0144\u0145\7k\2\2\u0145\u0149\7u\2\2\u0146\u0147\7"+
		"K\2\2\u0147\u0149\7U\2\2\u0148\u0144\3\2\2\2\u0148\u0146\3\2\2\2\u0149"+
		"\62\3\2\2\2\u014a\u014b\7p\2\2\u014b\u014c\7w\2\2\u014c\u014d\7n\2\2\u014d"+
		"\u014e\7n\2\2\u014e\64\3\2\2\2\u014f\u0150\7p\2\2\u0150\u0151\7q\2\2\u0151"+
		"\u0156\7v\2\2\u0152\u0153\7P\2\2\u0153\u0154\7Q\2\2\u0154\u0156\7V\2\2"+
		"\u0155\u014f\3\2\2\2\u0155\u0152\3\2\2\2\u0156\66\3\2\2\2\u0157\u0158"+
		"\7c\2\2\u0158\u0159\7p\2\2\u0159\u015e\7f\2\2\u015a\u015b\7C\2\2\u015b"+
		"\u015c\7P\2\2\u015c\u015e\7F\2\2\u015d\u0157\3\2\2\2\u015d\u015a\3\2\2"+
		"\2\u015e8\3\2\2\2\u015f\u0160\7q\2\2\u0160\u0164\7t\2\2\u0161\u0162\7"+
		"Q\2\2\u0162\u0164\7T\2\2\u0163\u015f\3\2\2\2\u0163\u0161\3\2\2\2\u0164"+
		":\3\2\2\2\u0165\u0166\7n\2\2\u0166\u0167\7g\2\2\u0167\u0168\7u\2\2\u0168"+
		"\u0169\7u\2\2\u0169\u016a\7g\2\2\u016a\u016b\7s\2\2\u016b\u016c\7w\2\2"+
		"\u016c\u016d\7c\2\2\u016d\u016e\7n\2\2\u016e<\3\2\2\2\u016f\u0170\7n\2"+
		"\2\u0170\u0171\7g\2\2\u0171\u0172\7u\2\2\u0172\u0173\7u\2\2\u0173>\3\2"+
		"\2\2\u0174\u0175\7i\2\2\u0175\u0176\7t\2\2\u0176\u0177\7g\2\2\u0177\u0178"+
		"\7c\2\2\u0178\u0179\7v\2\2\u0179\u017a\7g\2\2\u017a\u017b\7t\2\2\u017b"+
		"\u017c\7g\2\2\u017c\u017d\7s\2\2\u017d\u017e\7w\2\2\u017e\u017f\7c\2\2"+
		"\u017f\u0180\7n\2\2\u0180@\3\2\2\2\u0181\u0182\7i\2\2\u0182\u0183\7t\2"+
		"\2\u0183\u0184\7g\2\2\u0184\u0185\7c\2\2\u0185\u0186\7v\2\2\u0186\u0187"+
		"\7g\2\2\u0187\u0188\7t\2\2\u0188B\3\2\2\2\u0189\u018a\7p\2\2\u018a\u018b"+
		"\7q\2\2\u018b\u018c\7v\2\2\u018c\u018d\7g\2\2\u018d\u018e\7s\2\2\u018e"+
		"\u018f\7w\2\2\u018f\u0190\7c\2\2\u0190\u0191\7n\2\2\u0191D\3\2\2\2\u0192"+
		"\u0193\7g\2\2\u0193\u0194\7s\2\2\u0194\u0195\7w\2\2\u0195\u0196\7c\2\2"+
		"\u0196\u0197\7n\2\2\u0197F\3\2\2\2\u0198\u0199\7=\2\2\u0199H\3\2\2\2\u019a"+
		"\u019b\7p\2\2\u019b\u019c\7q\2\2\u019c\u019d\7v\2\2\u019d\u019e\7o\2\2"+
		"\u019e\u019f\7c\2\2\u019f\u01a0\7v\2\2\u01a0\u01a1\7e\2\2\u01a1\u01a2"+
		"\7j\2\2\u01a2J\3\2\2\2\u01a3\u01a4\7o\2\2\u01a4\u01a5\7c\2\2\u01a5\u01a6"+
		"\7v\2\2\u01a6\u01a7\7e\2\2\u01a7\u01a8\7j\2\2\u01a8L\3\2\2\2\u01a9\u01aa"+
		"\7k\2\2\u01aa\u01ab\7p\2\2\u01abN\3\2\2\2\u01ac\u01ad\7p\2\2\u01ad\u01ae"+
		"\7q\2\2\u01ae\u01af\7v\2\2\u01af\u01b0\7k\2\2\u01b0\u01b1\7p\2\2\u01b1"+
		"P\3\2\2\2\u01b2\u01b3\7d\2\2\u01b3\u01b4\7g\2\2\u01b4\u01b5\7v\2\2\u01b5"+
		"\u01b6\7y\2\2\u01b6\u01b7\7g\2\2\u01b7\u01b8\7g\2\2\u01b8\u01b9\7p\2\2"+
		"\u01b9R\3\2\2\2\u01ba\u01bb\7p\2\2\u01bb\u01bc\7q\2\2\u01bc\u01bd\7v\2"+
		"\2\u01bd\u01be\7d\2\2\u01be\u01bf\7g\2\2\u01bf\u01c0\7v\2\2\u01c0\u01c1"+
		"\7y\2\2\u01c1\u01c2\7g\2\2\u01c2\u01c3\7g\2\2\u01c3\u01c4\7p\2\2\u01c4"+
		"T\3\2\2\2\u01c5\u01c6\7k\2\2\u01c6\u01c7\7u\2\2\u01c7\u01c8\7p\2\2\u01c8"+
		"\u01c9\7w\2\2\u01c9\u01ca\7n\2\2\u01ca\u01cb\7n\2\2\u01cbV\3\2\2\2\u01cc"+
		"\u01cd\7k\2\2\u01cd\u01ce\7u\2\2\u01ce\u01cf\7p\2\2\u01cf\u01d0\7q\2\2"+
		"\u01d0\u01d1\7v\2\2\u01d1\u01d2\7p\2\2\u01d2\u01d3\7w\2\2\u01d3\u01d4"+
		"\7n\2\2\u01d4\u01d5\7n\2\2\u01d5X\3\2\2\2\u01d6\u01d7\7k\2\2\u01d7\u01d8"+
		"\7u\2\2\u01d8\u01d9\7o\2\2\u01d9\u01da\7k\2\2\u01da\u01db\7u\2\2\u01db"+
		"\u01dc\7u\2\2\u01dc\u01dd\7k\2\2\u01dd\u01de\7p\2\2\u01de\u01df\7i\2\2"+
		"\u01dfZ\3\2\2\2\u01e0\u01e1\7k\2\2\u01e1\u01e2\7u\2\2\u01e2\u01e3\7p\2"+
		"\2\u01e3\u01e4\7q\2\2\u01e4\u01e5\7v\2\2\u01e5\u01e6\7o\2\2\u01e6\u01e7"+
		"\7k\2\2\u01e7\u01e8\7u\2\2\u01e8\u01e9\7u\2\2\u01e9\u01ea\7k\2\2\u01ea"+
		"\u01eb\7p\2\2\u01eb\u01ec\7i\2\2\u01ec\\\3\2\2\2\u01ed\u01ef\t\2\2\2\u01ee"+
		"\u01ed\3\2\2\2\u01ef\u01f0\3\2\2\2\u01f0\u01ee\3\2\2\2\u01f0\u01f1\3\2"+
		"\2\2\u01f1^\3\2\2\2\u01f2\u01f4\t\3\2\2\u01f3\u01f2\3\2\2\2\u01f4\u01f5"+
		"\3\2\2\2\u01f5\u01f3\3\2\2\2\u01f5\u01f6\3\2\2\2\u01f6\u01f7\3\2\2\2\u01f7"+
		"\u01f8\b\60\2\2\u01f8`\3\2\2\2\u01f9\u01fa\7\61\2\2\u01fa\u01fb\7,\2\2"+
		"\u01fb\u01ff\3\2\2\2\u01fc\u01fe\13\2\2\2\u01fd\u01fc\3\2\2\2\u01fe\u0201"+
		"\3\2\2\2\u01ff\u0200\3\2\2\2\u01ff\u01fd\3\2\2\2\u0200\u0202\3\2\2\2\u0201"+
		"\u01ff\3\2\2\2\u0202\u0203\7,\2\2\u0203\u0204\7\61\2\2\u0204\u0205\3\2"+
		"\2\2\u0205\u0206\b\61\2\2\u0206b\3\2\2\2\u0207\u0208\7/\2\2\u0208\u0209"+
		"\7/\2\2\u0209\u020c\7\"\2\2\u020a\u020c\7%\2\2\u020b\u0207\3\2\2\2\u020b"+
		"\u020a\3\2\2\2\u020c\u0210\3\2\2\2\u020d\u020f\n\4\2\2\u020e\u020d\3\2"+
		"\2\2\u020f\u0212\3\2\2\2\u0210\u020e\3\2\2\2\u0210\u0211\3\2\2\2\u0211"+
		"\u0218\3\2\2\2\u0212\u0210\3\2\2\2\u0213\u0215\7\17\2\2\u0214\u0213\3"+
		"\2\2\2\u0214\u0215\3\2\2\2\u0215\u0216\3\2\2\2\u0216\u0219\7\f\2\2\u0217"+
		"\u0219\7\2\2\3\u0218\u0214\3\2\2\2\u0218\u0217\3\2\2\2\u0219\u0225\3\2"+
		"\2\2\u021a\u021b\7/\2\2\u021b\u021c\7/\2\2\u021c\u0222\3\2\2\2\u021d\u021f"+
		"\7\17\2\2\u021e\u021d\3\2\2\2\u021e\u021f\3\2\2\2\u021f\u0220\3\2\2\2"+
		"\u0220\u0223\7\f\2\2\u0221\u0223\7\2\2\3\u0222\u021e\3\2\2\2\u0222\u0221"+
		"\3\2\2\2\u0223\u0225\3\2\2\2\u0224\u020b\3\2\2\2\u0224\u021a\3\2\2\2\u0225"+
		"\u0226\3\2\2\2\u0226\u0227\b\62\2\2\u0227d\3\2\2\2\35\2{\u0089\u0097\u00a5"+
		"\u00af\u00bd\u00c7\u00d5\u00e7\u00f5\u0125\u0131\u0148\u0155\u015d\u0163"+
		"\u01f0\u01f5\u01ff\u020b\u0210\u0214\u0218\u021e\u0222\u0224\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}