package yk.jcommon.utils;

import java.math.BigInteger;

public class BigIntegerMath {

    public static BigInteger bi(long v) {
        return BigInteger.valueOf(v);
    }

    public static BigInteger sqr(BigInteger bi) {
        return bi.multiply(bi);
    }
}
