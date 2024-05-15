/*-
 * #%L
 * JSQLParser library
 * %%
 * Copyright (C) 2004 - 2023 JSQLParser
 * %%
 * Dual licensed under GNU LGPL 2.1 or Apache License 2.0
 * #L%
 */
package net.sf.jsqlparser.statement.select;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.test.TestUtils;
import org.junit.jupiter.api.Test;


class AllColumnsTest {

    @Test
    void testBigQuerySyntax() throws JSQLParserException {
        String sqlStr =
                "SELECT * EXCEPT (order_id) REPLACE (\"widget\" AS item_name), \"more\" as more_fields\n"
                        + "FROM orders";
        TestUtils.assertSqlCanBeParsedAndDeparsed(sqlStr, true);
    }
}
