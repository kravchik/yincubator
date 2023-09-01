package yk.jcommon.utils;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by yuri at 2023.03.29
 */
public class XYitTest {
    @Test
    public void testWh() {
        assertIterator("", XYit.wh(0, 0));
        assertIterator("0:0:0 ", XYit.wh(1, 1));
        assertIterator("", XYit.wh(1, 0));
        assertIterator("", XYit.wh(0, 1));

        assertIterator("", XYit.wh(-1, -1));
        assertIterator("", XYit.wh(-1, 0));
        assertIterator("", XYit.wh(0, -1));

        assertIterator("0:0:0 1:0:1 ", XYit.wh(2, 1));
        assertIterator("0:0:0 0:1:1 ", XYit.wh(1, 2));
        assertIterator("0:0:0 1:0:1 0:1:2 1:1:3 ", XYit.wh(2, 2));
        assertIterator("", XYit.wh(2, 0));
        assertIterator("", XYit.wh(0, 2));
    }

    @Test
    public void testLbrt() {
        assertIterator2("", XYit.lbrt(0, 0, -1, -1));
        assertIterator2("", XYit.lbrt(2, 3, 1, 2));
        assertIterator2("2:3 ", XYit.lbrt(2, 3, 2, 3));
        assertIterator2("", XYit.lbrt(2, 3, 2, 2));
        assertIterator2("", XYit.lbrt(2, 3, 1, 3));

        assertIterator2("2:3 3:3 ", XYit.lbrt(2, 3, 3, 3));
        assertIterator2("2:3 2:4 ", XYit.lbrt(2, 3, 2, 4));
        assertIterator2("2:3 3:3 2:4 3:4 ", XYit.lbrt(2, 3, 3, 4));
        assertIterator2("", XYit.lbrt(2, 3, 1, 5));
        assertIterator2("", XYit.lbrt(2, 3, 5, 2));
    }

    private static void assertIterator(String expected, XYit it) {
        String result = "";
        for (XYit xy : it) result += xy.x + ":" + xy.y + ":" + xy.getIndex() + " ";
        Assert.assertEquals(expected, result);
    }

    //without index
    private static void assertIterator2(String expected, XYit it) {
        String result = "";
        for (XYit xy : it) result += xy.x + ":" + xy.y + " ";
        Assert.assertEquals(expected, result);
    }
}