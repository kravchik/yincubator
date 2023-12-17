package yk.jcommon.utils;

import yk.jcommon.fastgeom.Vec2i;

import java.awt.image.BufferedImage;
import java.util.Iterator;

import static yk.jcommon.fastgeom.Vec2i.v2i;

/**
 * Kravchik Yuri
 * Date: 1/17/12
 * Time: 10:58 PM
 */
public class XYit implements Iterable<XYit>, Iterator<XYit> {
    //WARNING IT IS SLOWER THEN TWO FORS   (0.016 vs 0.013)
    public final int r, t;//inclusive
    public final int l, b;
    public final int w, h;

    public int x;
    public int y;

    private XYit(BufferedImage im) {
        this(im.getWidth(), im.getHeight());
    }

    private XYit(int width, int height) {
        w = width;
        h = height;
        r = width - 1;
        t = height - 1;
        l = 0;
        b = 0;
    }

    private XYit(int l, int b, int r, int t) {
        w = 0;//undefined for lbrt
        h = 0;
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

    public int getIndex() {
        return x + y * w;
    }

    public Vec2i getVec2i() {
        return v2i(x, y);
    }

    @Override
    public boolean hasNext() {
        return x != r || y != t;
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
