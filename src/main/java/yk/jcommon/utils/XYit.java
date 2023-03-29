package yk.jcommon.utils;

import java.awt.image.BufferedImage;
import java.util.Iterator;

/**
 * Kravchik Yuri
 * Date: 1/17/12
 * Time: 10:58 PM
 */
public class XYit implements Iterable<XYit>, Iterator<XYit> {
    //WARNING IT IS SLOWER THEN TWO FORS   (0.016 vs 0.013)
    public final int r, t;//inclusive
    public final int l, b;

    public int x;
    public int y;

    private XYit(BufferedImage im) {
        r = im.getWidth();
        t = im.getHeight();
        l = 0;
        b = 0;
    }

    private XYit(int width, int height) {
        r = width - 1;
        t = height - 1;
        l = 0;
        b = 0;
    }

    private XYit(int l, int b, int r, int t) {
        this.r = r;
        this.l = l;
        this.t = t;
        this.b = b;
    }

    public static XYit im(BufferedImage im) {
        return new XYit(im);
    }

    public static XYit wh(int width, int height) {
        return new XYit(width, height);
    }

    public static XYit lbrt(int l, int b, int r, int t) {
        return new XYit(l, b, r, t);
    }

    @Override
    public Iterator<XYit> iterator() {
        if (r - l < 0 || t - b < 0) {
            x = r;
            y = t;
        } else {
            x = l - 1;
            y = b;
        }
        return this;
    }

    @Override
    public boolean hasNext() {
        return y <= t && (y != t || x < r);
    }

    @Override
    public XYit next() {
        x++;
        if (x > r) {
            x = l;
            y++;
        }
        return this;
    }

    @Override
    public void remove() {
        throw new RuntimeException("not supported");
    }

    @Override
    public String toString() {
        return "XYit{" +
                "l=" + l +
                ", b=" + b +
                ", r=" + r +
                ", t=" + t +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    //    @Override
//    public void forEach(Block<? super XYit> block) {
//    }
}
