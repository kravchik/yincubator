package yk.jcommon.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static yk.jcommon.utils.MyMath.*;

/**
 * Created by Yuri Kravchik on 15/12/16.
 */
public class MyMathTest {

    public static void assertEqualsF(float expected, float actual) {
        assertEquals(expected, actual, 0.0000001f);
    }

    @Test
    public void testCycle() {
        assertEqualsF(0.1f, cycle(0.1f, 1));
        assertEqualsF(0.1f, cycle(1.1f, 1));
        assertEqualsF(0.1f, cycle(-.9f, 1));
        assertEqualsF(0.1f, cycle(-1.9f, 1));

        assertEquals(1, cycle(1, 10));
        assertEquals(1, cycle(11, 10));
        assertEquals(1, cycle(-9, 10));
        assertEquals(1, cycle(-19, 10));

        for (int i = -9; i < 10; i++) {
            int d = 3;
            System.out.println("floorDiv(" + i + ", " + d + ") " + Math.floorDiv(i, d));
        }

        System.out.println();
        System.out.println("Acts the same way as a 'cycle'");
        for (int i = -9; i < 10; i++) {
            int d = 3;
            System.out.println("floorMod(" + i + ", " + d + ") " + Math.floorMod(i, d));
        }

        for (float f = -0.2f; f < 0.3f; f += 0.1f) {
            System.out.println(String.format("     * <li>cycle(%s, %s) = %s", f, 2*PI, cycle(f, 2*PI)));
        }

        System.out.println();
        for (int i = -20; i < 30; i += 10) {
            System.out.println(String.format("     * <li>cycle(%s, %s) = %s", i, 360, cycle(i, 360)));
        }

    }

    @Test
    public void testAngles() throws Exception {
        float a = PI * 1.5f;
        assertEquals(a, angleNormalize02PI(-PI / 2), 0);
        assertEquals(a, angleNormalize02PI(PI * 1.5f), 0);
        assertEquals(a, angleNormalize02PI(PI * 1.5f + PI * 8), 0);
        assertEquals(a, angleNormalize02PI(-PI / 2f - PI * 8), 0.0001);

        assertEquals(PI * 0.75f, mixAngle02PI(PI / 2, PI, 0.5f), 0);
        assertEquals(PI * 1.25f, mixAngle02PI(-PI / 2, PI, 0.5f), 0);
        assertEquals(PI * 0.5f * 0.25f, mixAngle02PI(angleNormalize02PI(-PI / 4), PI / 4, 0.75f), 0.0001);
        assertEquals(2 * PI - PI * 0.5f * 0.25f, mixAngle02PI(PI / 4, angleNormalize02PI(-PI / 4), 0.75f), 0.0001);

        assertEquals(PI / 2, angleDif02PI(PI / 2, PI), 0);
        assertEquals(PI / 2, angleDif02PI(-PI / 2, PI), 0.0001f);
        assertEquals(PI / 2, angleDif02PI(angleNormalize02PI(-PI / 4), PI / 4), 0.0001);
        assertEquals(PI / 2, angleDif02PI(PI / 4, angleNormalize02PI(-PI / 4)), 0.0001);
        
    }

}