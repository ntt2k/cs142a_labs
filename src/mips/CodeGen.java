package mips;

import java.util.regex.Pattern;

import ast.*;
import types.*;

/**
 * A visitor that generated MIPS assembly code.
 */
public class CodeGen implements ast.CommandVisitor {
    
    /* Collected error messages. */
    private StringBuffer errorBuffer = new StringBuffer();

    /* The type checker. */
    private TypeChecker typeChecker;

    /* The program we're building. */
    private Program program;

    /* The curretn activation record. */
    private ActivationRecord currentFunction;

    /**
     * Construct a new code generator using the given type checker.
     * @param TypeChecker The type checker to use.
     */
    public CodeGen(TypeChecker typeChecker) {
        this.typeChecker = typeChecker;
        this.program = new Program();
    }
    
    /**
     * Query for errors.
     * @return Indication of the precense of errors.
     */
    public boolean hasError() {
        return errorBuffer.length() != 0;
    }
    
    public String errorReport() {
        return errorBuffer.toString();
    }

    private class CodeGenException extends RuntimeException {
        private static final long serialVersionUID = 1L;
        public CodeGenException(String errorMessage) {
            super(errorMessage);
        }
    }
    
    public boolean generate(Command ast) {
        try {
            currentFunction = ActivationRecord.newGlobalFrame();
            ast.accept(this);
            return !hasError();
        } catch (CodeGenException e) {
            return false;
        }
    }
    
    public Program getProgram() {
        return program;
    }

    @Override
    public void visit(Command node) {
        throw new RuntimeException("Implement this");
    }

    @Override
    public void visit(Expression node) {
        throw new RuntimeException("Implement this");
    }

    @Override
    public void visit(Declaration node) {
        throw new RuntimeException("Implement this");
    }

    @Override
    public void visit(Statement node) {
        throw new RuntimeException("Implement this");
    }

    @Override
    public void visit(ExpressionList node) {
        throw new RuntimeException("Implement this");
    }

    @Override
    public void visit(DeclarationList node) {
        throw new RuntimeException("Implement this");
    }

    @Override
    public void visit(StatementList node) {
        throw new RuntimeException("Implement this");
    }

    @Override
    public void visit(ReadSymbol node) {
        throw new RuntimeException("Implement this");
    }

    @Override
    public void visit(LiteralBool node) {
        throw new RuntimeException("Implement this");
    }

    @Override
    public void visit(LiteralFloat node) {
        throw new RuntimeException("Implement this");
    }

    @Override
    public void visit(LiteralInt node) {
        throw new RuntimeException("Implement this");
    }

    @Override
    public void visit(VariableDeclaration node) {
        throw new RuntimeException("Implement this");
    }

    @Override
    public void visit(ArrayDeclaration node) {
        throw new RuntimeException("Implement this");
    }

    @Override
    public void visit(FunctionDefinition node) {
        throw new RuntimeException("Implement this");
    }

    @Override
    public void visit(Addition node) {
        throw new RuntimeException("Implement this");
    }

    @Override
    public void visit(Subtraction node) {
        throw new RuntimeException("Implement this");
    }

    @Override
    public void visit(Multiplication node) {
        throw new RuntimeException("Implement this");
    }

    @Override
    public void visit(Division node) {
        throw new RuntimeException("Implement this");
    }

    @Override
    public void visit(LogicalAnd node) {
        throw new RuntimeException("Implement this");
    }

    @Override
    public void visit(LogicalOr node) {
        throw new RuntimeException("Implement this");
    }
    
    @Override
    public void visit(LogicalNot node) {
        throw new RuntimeException("Implement this");
    }

    @Override
    public void visit(Comparison node) {
        throw new RuntimeException("Implement this");
    }

    @Override
    public void visit(Dereference node) {
        throw new RuntimeException("Implement this");
    }

    @Override
    public void visit(Index node) {
        throw new RuntimeException("Implement this");
    }

    @Override
    public void visit(Assignment node) {
        throw new RuntimeException("Implement this");
    }

    @Override
    public void visit(Call node) {
        throw new RuntimeException("Implement this");
    }

    @Override
    public void visit(IfElseBranch node) {
        throw new RuntimeException("Implement this");
    }

    @Override
    public void visit(WhileLoop node) {
        throw new RuntimeException("Implement this");
    }

    @Override
    public void visit(Return node) {
        throw new RuntimeException("Implement this");
    }

    @Override
    public void visit(ast.Error node) {
        String message = "CodeGen cannot compile a " + node);
        errorBuffer.append(message);
        throw new CodeGenException(message);
    }
}
