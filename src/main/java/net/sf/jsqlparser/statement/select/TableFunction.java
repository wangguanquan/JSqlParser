/*-
 * #%L
 * JSQLParser library
 * %%
 * Copyright (C) 2004 - 2019 JSQLParser
 * %%
 * Dual licensed under GNU LGPL 2.1 or Apache License 2.0
 * #L%
 */
package net.sf.jsqlparser.statement.select;

import net.sf.jsqlparser.expression.Alias;
import net.sf.jsqlparser.expression.Function;

@SuppressWarnings({"PMD.UncommentedEmptyMethodBody"})
public class TableFunction extends Function implements FromItem {
    private String prefix = null;
    private Alias alias = null;
    private Pivot pivot = null;
    private UnPivot unPivot = null;
    private Function function;

    public TableFunction(Function function) {
        this.function = function;
    }

    public TableFunction(String prefix, Function function) {
        this.prefix = prefix;
        this.function = function;
    }

    public Function getFunction() {
        return function;
    }

    @Deprecated
    public Function getExpression() {
        return getFunction();
    }


    public TableFunction setFunction(Function function) {
        this.function = function;
        return this;
    }

    public String getPrefix() {
        return prefix;
    }

    public TableFunction setPrefix(String prefix) {
        this.prefix = prefix;
        return this;
    }

    @Override
    public void accept(FromItemVisitor fromItemVisitor) {
        fromItemVisitor.visit(this);
    }

    @Override
    public Alias getAlias() {
        return alias;
    }

    @Override
    public void setAlias(Alias alias) {
        this.alias = alias;
    }

    @Override
    public TableFunction withAlias(Alias alias) {
        return (TableFunction) FromItem.super.withAlias(alias);
    }

    @Override
    public Pivot getPivot() {
        return pivot;
    }

    @Override
    public void setPivot(Pivot pivot) {
        this.pivot = pivot;
    }

    @Override
    public TableFunction withPivot(Pivot pivot) {
        return (TableFunction) FromItem.super.withPivot(pivot);
    }

    @Override
    public UnPivot getUnPivot() {
        return unPivot;
    }

    @Override
    public void setUnPivot(UnPivot unPivot) {
        this.unPivot = unPivot;
    }

    @Override
    public TableFunction withUnPivot(UnPivot unpivot) {
        return (TableFunction) FromItem.super.withUnPivot(unpivot);
    }

    public StringBuilder appendTo(StringBuilder builder) {
        if (prefix != null) {
            builder.append(prefix).append(" ");
        }
        builder.append(function.toString());

        if (alias != null) {
            builder.append(alias);
        }
        return builder;
    }

    @Override
    public String toString() {
        return appendTo(new StringBuilder()).toString();
    }
}
