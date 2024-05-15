/*-
 * #%L
 * JSQLParser library
 * %%
 * Copyright (C) 2004 - 2019 JSQLParser
 * %%
 * Dual licensed under GNU LGPL 2.1 or Apache License 2.0
 * #L%
 */
package net.sf.jsqlparser.statement;

import net.sf.jsqlparser.JSQLParserException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static net.sf.jsqlparser.test.TestUtils.assertSqlCanBeParsedAndDeparsed;

/**
 *
 * @author oshai
 */
public class ShowStatementTest {

    @Test
    public void testSimpleUse() throws JSQLParserException {
        assertSqlCanBeParsedAndDeparsed("SHOW mydatabase");
    }

    @Test
    public void testSimpleUse2() throws JSQLParserException {
        assertSqlCanBeParsedAndDeparsed("SHOW transaction_isolation");
    }

    @Test
    void testShowIndexesFromTable() throws JSQLParserException {
        String sqlStr =
                "show indexes from my_table";
        assertSqlCanBeParsedAndDeparsed(sqlStr, true);
    }

    @Test
    void testShowCreateTable() throws JSQLParserException {
        String sqlStr =
                "show create table my_table";
        Statement statement = assertSqlCanBeParsedAndDeparsed(sqlStr, true);
        Assertions.assertTrue(statement instanceof UnsupportedStatement);
    }
}
