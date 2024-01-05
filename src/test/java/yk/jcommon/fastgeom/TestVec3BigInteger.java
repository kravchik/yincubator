package yk.jcommon.fastgeom;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;
import static yk.jcommon.fastgeom.Vec3BigInteger.v3bi;
import static yk.jcommon.utils.BigIntegerMath.bi;

public class TestVec3BigInteger {
    @Test
    public void test1() {
        assertEquals(v3bi(new BigInteger("3000000000000000000000000000")), v3bi(
            new BigInteger("1000000000000000000000000000").add(
                new BigInteger("2000000000000000000000000000"))));

        assertEquals(v3bi(1, 2, 3), v3bi(0, 1, 2).add(v3bi(1)));
        assertEquals(v3bi(1, 2, 3), v3bi(0, 1, 2).add(bi(1)));
        assertEquals(v3bi(1, 3, 5), v3bi(0, 1, 2).add(bi(1), bi(2), bi(3)));

        assertEquals(v3bi(-1, 0, 1), v3bi(0, 1, 2).sub(v3bi(1)));
        assertEquals(v3bi(-1, 0, 1), v3bi(0, 1, 2).sub(bi(1)));
        assertEquals(v3bi(-1, 0, 1), v3bi(0, 1, 2).sub(v3bi(1)));

        assertEquals(v3bi(0, 2, 4), v3bi(0, 1, 2).mul(v3bi(2)));
        assertEquals(v3bi(0, 2, 4), v3bi(0, 1, 2).mul(bi(2)));
        assertEquals(v3bi(0, 3, 8), v3bi(0, 1, 2).mul(bi(2), bi(3), bi(4)));

        assertEquals(v3bi(0, 5, 10), v3bi(0, 10, 20).div(v3bi(2)));
        assertEquals(v3bi(0, 5, 10), v3bi(0, 10, 20).div(bi(2)));
        assertEquals(v3bi(0, 3, 5), v3bi(0, 10, 20).div(bi(2), bi(3), bi(4)));

        assertEquals(v3bi(0, 1, 1), v3bi(0, -1, 1).abs());
        assertEquals(bi(1), v3bi(0, -1, 2).sum());
        assertEquals(bi(-2), v3bi(1, -1, 2).product());
        assertEquals(bi(-1), v3bi(1, -1, 2).min());
        assertEquals(bi(2), v3bi(1, -1, 2).max());
        assertEquals(bi(6), v3bi(1, -1, 2).lengthSquared());
        assertEquals(bi(3), v3bi(1).distanceSquared(v3bi(2)));
        assertEquals(bi(3), v3bi(1).distanceSquared(bi(2), bi(2), bi(2)));
        assertEquals(bi(6), v3bi(-2).manhattanLength());
        assertEquals(bi(9), v3bi(1).manhattanDistance(v3bi(-2)));
        assertEquals(bi(4), v3bi(1).manhattanDistance(bi(3), bi(2), bi(2)));

        assertEquals(bi(9+4+1), v3bi(3, 2, 1).dot(bi(3), bi(2), bi(1)));
        assertEquals(bi(9+4+1), v3bi(3, 2, 1).dot(v3bi(3, 2, 1)));
        assertEquals(v3bi(-3, 2, -1), v3bi(3, -2, 1).negative());

        assertEquals(v3bi(1, 1, 3), v3bi(1, 2, 3).min(v3bi(2, 1, 5)));
        assertEquals(v3bi(1, 1, 3), v3bi(1, 2, 3).min(bi(2), bi(1), bi(5)));
        assertEquals(v3bi(1, 2, 2), v3bi(1, 2, 3).min(bi(2)));

        assertEquals(v3bi(2, 2, 5), v3bi(1, 2, 3).max(v3bi(2, 1, 5)));
        assertEquals(v3bi(2, 2, 5), v3bi(1, 2, 3).max(bi(2), bi(1), bi(5)));
        assertEquals(v3bi(2, 2, 3), v3bi(1, 2, 3).max(bi(2)));

        assertEquals(v3bi(2, 2, 3), v3bi(1, 2, 5).clamp(bi(2), bi(3)));
        assertEquals(v3bi(-1, 3, 5), v3bi(1, 2, 5).clamp(v3bi(-2, 3, 0), v3bi(-1, 3, 5)));
    }
}
