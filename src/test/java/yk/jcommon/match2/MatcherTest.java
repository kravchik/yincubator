package yk.jcommon.match2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static yk.jcommon.collections.YArrayList.al;
import static yk.jcommon.collections.YHashSet.hs;
import static yk.jcommon.match2.MatcherShortNames.var;

/**
 * Created by Yuri Kravchik on 05.01.2019
 */
public class MatcherTest {

    @Test
    public void testVar() {
        assertEquals("[{x=a, y=c}]", new Matcher().match(al("a", "a", "c"), al(var("x"), var("x"), var("y"))).toString());

        assertEquals("[{x=[_a], y=c}]", new Matcher().match(al(al("_a"), al("_a"), "c"), al(var("x", al("_a")), var("x"), var("y"))).toString());

        assertEquals("[]", new Matcher().match(al(al("_a"), al("_a"), "c"), al(var("x", al("_a")), var("x", al("_b")), var("y"))).toString());

        assertEquals("[]", new Matcher().match(al(hs("_a", "_b"), hs("_a"), "c"), al(var("x", hs("_a")), var("x"), var("y"))).toString());

        assertEquals("[]", new Matcher().match(al(hs("_a", "_b"), hs("_a", "_b"), "c"), al(var("x", hs("_a")), var("x"), var("y"))).toString());

        //not required, it is better to place a pattern in only one var, though, currently, it is logically better at least
        assertEquals("[]", new Matcher().match(al(hs("_a", "_b"), hs("_a", "_b"), "c"), al(var("x", hs("_a")), var("x", hs("_b")), var("y"))).toString());

    }
}