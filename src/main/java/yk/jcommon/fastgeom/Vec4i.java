/**
 * File Vec3.java
 * @author Yuri Kravchik
 * Created 16.10.2008
 */
package yk.jcommon.fastgeom;

import yk.jcommon.utils.MyMath;

import java.io.Serializable;

/**
 * Vec3
 *
 * @author Yuri Kravchik Created 20.08.2022
 */
public final class Vec4i implements Serializable {
    public int x, y, z, w;

    public static final Vec4i ZERO = new Vec4i(0, 0, 0, 0);
    public static final Vec4i AXIS_X = new Vec4i(1, 0, 0, 0);
    public static final Vec4i AXIS_Y = new Vec4i(0, 1, 0, 0);
    public static final Vec4i AXIS_Z = new Vec4i(0, 0, 1, 0);
    public static final Vec4i AXIS_W = new Vec4i(0, 0, 0, 1);

    public Vec4i() {
    }

    public Vec4i(final int x, final int y, final int z, final int w) {
        this.w = w;
        this.x = x;this.y = y;
        this.z = z;
    }

    public static Vec4i v4(final int x, final int y, final int z, final int w) {
        return new Vec4i(x, y, z, w);
    }

    public static Vec4i v4(Vec3i v3, final int w) {
        return new Vec4i(v3, w);
    }

    public Vec4i(Vec3i v, int w) {
        this(v.x, v.y, v.z, w);
    }

    public Vec4i(Vec4i from) {
        this.w = from.w;
        this.x = from.x;
        this.y = from.y;
        this.z = from.z;
    }

    public Vec4i withSetX(int x) {
        return new Vec4i(x, y, z, w);
    }

    public Vec4i withSetY(int y) {
        return new Vec4i(x, y, z, w);
    }

    public Vec4i withSetZ(int z) {
        return new Vec4i(x, y, z, w);
    }

    public Vec4i withSetW(int w) {
        return new Vec4i(x, y, z, w);
    }

    @Override
    public String toString() {
        return "w: " + w + " x: " + x + " y: " + y + " z: " + z;
    }

    public float length() {
        return (float) Math.sqrt(w*w+x*x+y*y+z*z);
    }

    public Vec2i getXy() {
        return new Vec2i(x, y);
    }
    public Vec2i getYz() {
        return new Vec2i(y, z);
    }

    public Vec2i getXz() {
        return new Vec2i(x, z);
    }

    public Vec3i getXyz() {
        return new Vec3i(x, y, z);
    }

    public void setXyz(Vec3i v) {
        x = v.x;
        y = v.y;
        z = v.z;
    }

    public float dot(final Vec4i b) {
        return x * b.x + y * b.y + z * b.z + w * b.z;
    }

    public Vec4i negative() {
        return v4(x, y, z, w);
    }

//2022 auto generated text
/*2022*/public Vec4i add(Vec4i other) {return new Vec4i(x + other.x, y + other.y, z + other.z, w + other.w);}
/*2022*/public Vec4i add(int v) {return new Vec4i(x + v, y + v, z + v, w + v);}
/*2022*/public Vec4i add(int x, int y, int z, int w) {return new Vec4i(this.x + x, this.y + y, this.z + z, this.w + w);}
/*2022*/public Vec4i sub(Vec4i other) {return new Vec4i(x - other.x, y - other.y, z - other.z, w - other.w);}
/*2022*/public Vec4i sub(int v) {return new Vec4i(x - v, y - v, z - v, w - v);}
/*2022*/public Vec4i sub(int x, int y, int z, int w) {return new Vec4i(this.x - x, this.y - y, this.z - z, this.w - w);}
/*2022*/public Vec4i mul(Vec4i other) {return new Vec4i(x * other.x, y * other.y, z * other.z, w * other.w);}
/*2022*/public Vec4i mul(int v) {return new Vec4i(x * v, y * v, z * v, w * v);}
/*2022*/public Vec4i mul(int x, int y, int z, int w) {return new Vec4i(this.x * x, this.y * y, this.z * z, this.w * w);}
/*2022*/public Vec4i div(Vec4i other) {return new Vec4i(x / other.x, y / other.y, z / other.z, w / other.w);}
/*2022*/public Vec4i div(int v) {return new Vec4i(x / v, y / v, z / v, w / v);}
/*2022*/public Vec4i div(int x, int y, int z, int w) {return new Vec4i(this.x / x, this.y / y, this.z / z, this.w / w);}
/*2022*/public Vec4i floor() {return new Vec4i(MyMath.floorFast(x), MyMath.floorFast(y), MyMath.floorFast(z), MyMath.floorFast(w));}
/*2022*/public Vec4i min(Vec4i b) {return new Vec4i(MyMath.min(x, b.x), MyMath.min(y, b.y), MyMath.min(z, b.z), MyMath.min(w, b.w));}
/*2022*/public Vec4i min(int b) {return new Vec4i(MyMath.min(x, b), MyMath.min(y, b), MyMath.min(z, b), MyMath.min(w, b));}
/*2022*/public Vec4i min(int x, int y, int z, int w) {return new Vec4i(MyMath.min(this.x, x), MyMath.min(this.y, y), MyMath.min(this.z, z), MyMath.min(this.w, w));}
/*2022*/public Vec4i max(Vec4i b) {return new Vec4i(MyMath.max(x, b.x), MyMath.max(y, b.y), MyMath.max(z, b.z), MyMath.max(w, b.w));}
/*2022*/public Vec4i max(int b) {return new Vec4i(MyMath.max(x, b), MyMath.max(y, b), MyMath.max(z, b), MyMath.max(w, b));}
/*2022*/public Vec4i max(int x, int y, int z, int w) {return new Vec4i(MyMath.max(this.x, x), MyMath.max(this.y, y), MyMath.max(this.z, z), MyMath.max(this.w, w));}
/*2022*/public Vec4i cycle(Vec4i b) {return new Vec4i(MyMath.cycle(x, b.x), MyMath.cycle(y, b.y), MyMath.cycle(z, b.z), MyMath.cycle(w, b.w));}
/*2022*/public Vec4i cycle(int b) {return new Vec4i(MyMath.cycle(x, b), MyMath.cycle(y, b), MyMath.cycle(z, b), MyMath.cycle(w, b));}
/*2022*/public Vec4i cycle(int x, int y, int z, int w) {return new Vec4i(MyMath.cycle(this.x, x), MyMath.cycle(this.y, y), MyMath.cycle(this.z, z), MyMath.cycle(this.w, w));}
//2022 auto generated text

}