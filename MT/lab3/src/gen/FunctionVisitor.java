// Generated from Function.g4 by ANTLR 4.7.2
package gen;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link FunctionParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface FunctionVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link FunctionParser#name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitName(FunctionParser.NameContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionParser#code}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCode(FunctionParser.CodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(FunctionParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionParser#function_header}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_header(FunctionParser.Function_headerContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionParser#type_foo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_foo(FunctionParser.Type_fooContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionParser#arg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArg(FunctionParser.ArgContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionParser#args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgs(FunctionParser.ArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(FunctionParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(FunctionParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(FunctionParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionParser#prefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefix(FunctionParser.PrefixContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionParser#return_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_statement(FunctionParser.Return_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionParser#read}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRead(FunctionParser.ReadContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionParser#write}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWrite(FunctionParser.WriteContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionParser#foo_in_foo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFoo_in_foo(FunctionParser.Foo_in_fooContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionParser#ifElse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfElse(FunctionParser.IfElseContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionParser#ifBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfBody(FunctionParser.IfBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionParser#whileBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileBody(FunctionParser.WhileBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionParser#forBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForBody(FunctionParser.ForBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionParser#in_par}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIn_par(FunctionParser.In_parContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(FunctionParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionParser#bin_or_eq_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBin_or_eq_expression(FunctionParser.Bin_or_eq_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionParser#bin_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBin_expression(FunctionParser.Bin_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionParser#prefix_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefix_expression(FunctionParser.Prefix_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionParser#bin_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBin_op(FunctionParser.Bin_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionParser#eq_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEq_op(FunctionParser.Eq_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionParser#prefix_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefix_op(FunctionParser.Prefix_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionParser#var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(FunctionParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by {@link FunctionParser#string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(FunctionParser.StringContext ctx);
}