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

import net.sf.jsqlparser.schema.Table;

public interface FromItemVisitor {

    void visit(Table tableName);

    void visit(ParenthesedSelect selectBody);

    void visit(LateralSubSelect lateralSubSelect);

    void visit(TableFunction tableFunction);

    void visit(ParenthesedFromItem aThis);

    void visit(Values values);
}
