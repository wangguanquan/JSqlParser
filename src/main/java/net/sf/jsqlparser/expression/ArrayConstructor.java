/*-
 * #%L
 * JSQLParser library
 * %%
 * Copyright (C) 2004 - 2021 JSQLParser
 * %%
 * Dual licensed under GNU LGPL 2.1 or Apache License 2.0
 * #L%
 */
package net.sf.jsqlparser.expression;

import net.sf.jsqlparser.expression.operators.relational.ExpressionList;
import net.sf.jsqlparser.parser.ASTNodeAccessImpl;

public class ArrayConstructor extends ASTNodeAccessImpl implements Expression {
    private ExpressionList<?> expressions;
    private boolean arrayKeyword;

    public ExpressionList<?> getExpressions() {
        return expressions;
    }

    public void setExpressions(ExpressionList<?> expressions) {
        this.expressions = expressions;
    }

    public boolean isArrayKeyword() {
        return arrayKeyword;
    }

    public void setArrayKeyword(boolean arrayKeyword) {
        this.arrayKeyword = arrayKeyword;
    }

    public ArrayConstructor(ExpressionList<?> expressions, boolean arrayKeyword) {
        this.expressions = expressions;
        this.arrayKeyword = arrayKeyword;
    }

    @Override
    public void accept(ExpressionVisitor expressionVisitor) {
        expressionVisitor.visit(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (arrayKeyword) {
            sb.append("ARRAY");
        }
        sb.append("[");
        sb.append(expressions.toString());
        sb.append("]");
        return sb.toString();
    }
}
