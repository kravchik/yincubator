package yk.lang.yads.simple;

import org.junit.Test;
import yk.lang.yads.YadsSimpleParser;

import static org.junit.Assert.assertEquals;
import static yk.jcommon.collections.YArrayList.al;

public class TestYadsSimple {
    @Test
    public void test1() {
        assertEquals(al(), YadsSimpleParser.parse("()"));
        assertEquals(al(al(al())), YadsSimpleParser.parse("((()))"));
        assertEquals(al(al(), al()), YadsSimpleParser.parse("(() ())"));
        assertEquals(al("a"), YadsSimpleParser.parse("(a)"));
        assertEquals(al("a", "b"), YadsSimpleParser.parse("(a b)"));
        assertEquals(al(al(), "a", "b"), YadsSimpleParser.parse("(() a b)"));
        assertEquals(al("a", "b", al()), YadsSimpleParser.parse("(a b ())"));

        assertEquals(al("a \" ' b"), YadsSimpleParser.parse("(\"a \\\" ' b\")"));
        assertEquals(al("a \" ' b"), YadsSimpleParser.parse("('a \" \\' b')"));

        assertEquals(al("a \n b"), YadsSimpleParser.parse("('a \n b')"));

        assertEquals(al("a", "b"), YadsSimpleParser.parseListBody("a b"));
        assertEquals(al(al("a", "b")), YadsSimpleParser.parseListBody("(a b)"));
    }

    @Test
    public void testDataTypes() {
        assertEquals(al(1), YadsSimpleParser.parse("(1)"));
        assertEquals(al(1.0f), YadsSimpleParser.parse("(1.0)"));
        assertEquals(al(1.0f), YadsSimpleParser.parse("(1.0)"));

        assertEquals(al(1.0d), YadsSimpleParser.parse("(1.0d)"));
        assertEquals(al(1.0d), YadsSimpleParser.parse("(1.0D)"));

        assertEquals(al(1), YadsSimpleParser.parse("(01)"));

        assertEquals(al("true"), YadsSimpleParser.parse("(true)"));
        assertEquals(al("false"), YadsSimpleParser.parse("(false)"));

        assertEquals(al(-5), YadsSimpleParser.parse("(-5)"));
        assertEquals(al(-5f), YadsSimpleParser.parse("(-5.0)"));
        assertEquals(al(-5d), YadsSimpleParser.parse("(-5d)"));
    }
}
