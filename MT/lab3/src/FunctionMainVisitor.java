// Generated from Function.g4 by ANTLR 4.7.2
import gen.FunctionBaseVisitor;
import gen.FunctionParser;
import gen.FunctionVisitor;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.stringtemplate.v4.ST;

import javax.swing.tree.TreeNode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * This class provides an empty implementation of {@link FunctionVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 */
public class FunctionMainVisitor extends FunctionBaseVisitor<String> {
	Map<String, String> variables = new HashMap<>();
	private int num = 10;
	private String str = "IO10";

	@Override
	protected String defaultResult() {
		return "";
	}

	@Override
	protected String aggregateResult(String aggregate, String nextResult) {
		return aggregate + " " + nextResult;
	}

	@Override
	public String visitName(FunctionParser.NameContext ctx) {
		if (variables.get(ctx.getText()) == null){
			StringBuilder s = new StringBuilder("I");
			int t = variables.size();
			for (int i = 1; i < num; i++) {
				s.append(str.charAt(t % 2 + 2 * (i % 2)));
				t /= 2;
			}
			variables.put(ctx.getText(), s.toString());
		}
		return variables.get(ctx.getText());
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitCode(FunctionParser.CodeContext ctx) {
		return ctx.children.stream().limit(ctx.getChildCount() - 1).map(this::visit).collect(Collectors.joining("\n\n"));

	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitStatement(FunctionParser.StatementContext ctx) {
		return visit(ctx.getChild(0)) + " " + ctx.L_BRACE() + "\n" + visit(ctx.body()) + "\n" + ctx.R_BRACE();
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitFunction_header(FunctionParser.Function_headerContext ctx) {
		return ctx.getChild(0).getText() + " " + ctx.NAME() + ctx.L_PAR() + visit(ctx.args()) + ctx.R_PAR();
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitType_foo(FunctionParser.Type_fooContext ctx) {
		return ctx.getText();
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override
	public String visitArg(FunctionParser.ArgContext ctx) {
		return ctx.getChild(0).getText() + " " + visit(ctx.getChild(1));
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitArgs(FunctionParser.ArgsContext ctx) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < ctx.getChildCount(); i++){
			if (i % 2 == 0) {
				sb.append(visit(ctx.getChild(i)));
			} else {
				sb.append(ctx.getChild(i)).append(" ");
			}
		}
		return sb.toString();
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitBody(FunctionParser.BodyContext ctx) {
		if (ctx.children != null){
			return "\t" + ctx.children.stream().map(this::visit).collect(Collectors.joining("\n\t"));
		}
		return "";
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitDeclaration(FunctionParser.DeclarationContext ctx) {
		return ctx.children.stream().map(child -> {
			if (!(child instanceof TerminalNode)){
				return visit(child);
			} else {
				return child.getText();
			}
		}).collect(Collectors.joining(" "));
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitAssignment(FunctionParser.AssignmentContext ctx) {
		return ctx.children.stream().map(child -> {
			if (!(child instanceof TerminalNode)){
				return visit(child);
			} else {
				return child.getText();
			}
		}).collect(Collectors.joining(" "));
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitPrefix(FunctionParser.PrefixContext ctx) {
		return ctx.children.stream().map(child -> {
			if (!(child instanceof TerminalNode)){
				return visit(child);
			} else {
				return child.getText();
			}
		}).collect(Collectors.joining(" "));
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitReturn_statement(FunctionParser.Return_statementContext ctx) {
		return ctx.children.stream().map(child -> {
			if (!(child instanceof TerminalNode)){
				return visit(child);
			} else {
				return child.getText();
			}
		}).collect(Collectors.joining(" "));
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitRead(FunctionParser.ReadContext ctx) {
		return ctx.children.stream().map(child -> {
			if (!(child instanceof TerminalNode)){
				return visit(child);
			} else {
				return child.getText();
			}
		}).collect(Collectors.joining(" "));
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitWrite(FunctionParser.WriteContext ctx) {
		return ctx.children.stream().map(child -> {
			if (!(child instanceof TerminalNode)){
				return visit(child);
			} else {
				return child.getText();
			}
		}).collect(Collectors.joining(" "));
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitFoo_in_foo(FunctionParser.Foo_in_fooContext ctx) {
		return ctx.children.stream().map(child -> {
			if (!(child instanceof TerminalNode)){
				return visit(child);
			} else {
				return child.getText();
			}
		}).collect(Collectors.joining(" "));
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitIfElse(FunctionParser.IfElseContext ctx) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < ctx.getChildCount(); i++){
			if (i > 0){
				sb.append("\t");
			}
			if (!(ctx.getChild(i) instanceof TerminalNode)){
				sb.append(visit(ctx.getChild(i)));
			} else {
				sb.append(ctx.getChild(i).getText());
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitIfBody(FunctionParser.IfBodyContext ctx) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < ctx.getChildCount(); i++){
			if (i >= 3){
				sb.append("\t");
			}
			if (i == 2 || i == 3) {
				if (!(ctx.getChild(i) instanceof TerminalNode)){
					sb.append(visit(ctx.getChild(i)));
				} else {
					sb.append(ctx.getChild(i).getText());
				}
				sb.append("\n");
			} else {
				if (!(ctx.getChild(i) instanceof TerminalNode)){
					sb.append(visit(ctx.getChild(i)));
				} else {
					sb.append(ctx.getChild(i).getText());
				}
			}
		}
		return sb.toString();
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitWhileBody(FunctionParser.WhileBodyContext ctx) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < ctx.getChildCount(); i++){
			if (i >= 2){
				sb.append("\t");
			}
			if (i == 2 || i == 3) {
				if (!(ctx.getChild(i) instanceof TerminalNode)){
					sb.append(visit(ctx.getChild(i)));
				} else {
					sb.append(ctx.getChild(i).getText());
				}
				sb.append("\n");
			} else {
				if (!(ctx.getChild(i) instanceof TerminalNode)){
					sb.append(visit(ctx.getChild(i)));
				} else {
					sb.append(ctx.getChild(i).getText());
				}
			}
		}
		return sb.toString();
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitForBody(FunctionParser.ForBodyContext ctx) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < ctx.getChildCount(); i++){
			if (i > 9){
				sb.append("\t");
			}
			if (i >= 9) {
				if (!(ctx.getChild(i) instanceof TerminalNode)){
					sb.append(visit(ctx.getChild(i)));
				} else {
					sb.append(ctx.getChild(i).getText());
				}
				sb.append("\n");
			} else {
				if (!(ctx.getChild(i) instanceof TerminalNode)){
					sb.append(visit(ctx.getChild(i)));
				} else {
					sb.append(ctx.getChild(i).getText());
				}
			}
		}
		return sb.toString();
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitIn_par(FunctionParser.In_parContext ctx) {
		return ctx.children.stream().map(child -> {
			if (!(child instanceof TerminalNode)){
				return visit(child);
			} else {
				return child.getText();
			}
		}).collect(Collectors.joining(" "));
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitExpression(FunctionParser.ExpressionContext ctx) {
		return ctx.children.stream().map(child -> {
			if (!(child instanceof TerminalNode)){
				return visit(child);
			} else {
				return child.getText();
			}
		}).collect(Collectors.joining(" "));
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitBin_or_eq_expression(FunctionParser.Bin_or_eq_expressionContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitBin_expression(FunctionParser.Bin_expressionContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitPrefix_expression(FunctionParser.Prefix_expressionContext ctx) {
		return visitChildren(ctx);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitBin_op(FunctionParser.Bin_opContext ctx) { return ctx.getChild(0).getText(); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitEq_op(FunctionParser.Eq_opContext ctx) { return ctx.getChild(0).getText(); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitPrefix_op(FunctionParser.Prefix_opContext ctx) { return ctx.getChild(0).getText(); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitVar(FunctionParser.VarContext ctx) {
		return ctx.children.stream().map(child -> {
			if (!(child instanceof TerminalNode)){
				return visit(child);
			} else {
				return child.getText();
			}
		}).collect(Collectors.joining(" "));
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitString(FunctionParser.StringContext ctx) {
		return ctx.children.stream().map(child -> {
			if (!(child instanceof TerminalNode)){
				return visit(child);
			} else {
				return child.getText();
			}
		}).collect(Collectors.joining(" "));
	}
}