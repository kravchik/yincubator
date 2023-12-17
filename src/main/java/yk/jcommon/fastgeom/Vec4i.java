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
@SuppressWarnings("SuspiciousNameCombination")
public final class Vec4i implements Serializable {
    public int x, y, z, w;

    public static final Vec4i ZERO = new Vec4i(0, 0, 0, 0);
    public static final Vec4i AXIS_X = new Vec4i(1, 0, 0, 0);
    public static final Vec4i AXIS_Y = new Vec4i(0, 1, 0, 0);
    public static final Vec4i AXIS_Z = new Vec4i(0, 0, 1, 0);
    public static final Vec4i AXIS_W = new Vec4i(0, 0, 0, 1);

    public Vec4i() {
    }

    public static Vec4i v4(Vec3i v3, final int w) {
        return new Vec4i(v3, w);
    }

    public Vec4i(Vec3i v, int w) {
        this(v.x, v.y, v.z, w);
    }

    public Vec4i withX(int x) {
        return new Vec4i(x, y, z, w);
    }

    public Vec4i withY(int y) {
        return new Vec4i(x, y, z, w);
    }

    public Vec4i withZ(int z) {
        return new Vec4i(x, y, z, w);
    }

    public Vec4i withW(int w) {
        return new Vec4i(x, y, z, w);
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

//2022 auto generated text
/*2022*///constructors
/*2022*/public Vec4i(int x, int y, int z, int w) {this.x = x;this.y = y;this.z = z;this.w = w;}
/*2022*/public Vec4i(Vec4i other) {x = other.x;y = other.y;z = other.z;w = other.w;}
/*2022*/public Vec4i(int b) {x = b;y = b;z = b;w = b;}
/*2022*/public static Vec4i v4i(int x, int y, int z, int w) {return new Vec4i(x, y, z, w);}
/*2022*/public static Vec4i v4i(int b) {return new Vec4i(b, b, b, b);}
/*2022*/public void fillFrom(Vec4i other) {x = other.x;y = other.y;z = other.z;w = other.w;}
/*2022*///operators
/*2022*/public Vec4i add(Vec4i b) {return new Vec4i(x + b.x, y + b.y, z + b.z, w + b.w);}
/*2022*/public Vec4i add(int b) {return new Vec4i(x + b, y + b, z + b, w + b);}
/*2022*/public Vec4i add(int x, int y, int z, int w) {return new Vec4i(this.x + x, this.y + y, this.z + z, this.w + w);}
/*2022*/public Vec4i sub(Vec4i b) {return new Vec4i(x - b.x, y - b.y, z - b.z, w - b.w);}
/*2022*/public Vec4i sub(int b) {return new Vec4i(x - b, y - b, z - b, w - b);}
/*2022*/public Vec4i sub(int x, int y, int z, int w) {return new Vec4i(this.x - x, this.y - y, this.z - z, this.w - w);}
/*2022*/public Vec4i mul(Vec4i b) {return new Vec4i(x * b.x, y * b.y, z * b.z, w * b.w);}
/*2022*/public Vec4i mul(int b) {return new Vec4i(x * b, y * b, z * b, w * b);}
/*2022*/public Vec4i mul(int x, int y, int z, int w) {return new Vec4i(this.x * x, this.y * y, this.z * z, this.w * w);}
/*2022*/public Vec4i div(Vec4i b) {return new Vec4i(x / b.x, y / b.y, z / b.z, w / b.w);}
/*2022*/public Vec4i div(int b) {return new Vec4i(x / b, y / b, z / b, w / b);}
/*2022*/public Vec4i div(int x, int y, int z, int w) {return new Vec4i(this.x / x, this.y / y, this.z / z, this.w / w);}
/*2022*///0 args functions
/*2022*/public Vec4i abs() {return new Vec4i(MyMath.abs(x), MyMath.abs(y), MyMath.abs(z), MyMath.abs(w));}
/*2022*///reducers
/*2022*/public int sum() {return x + y + z + w;}
/*2022*/public int product() {return x * y * z * w;}
/*2022*/public int min() {return MyMath.min(MyMath.min(MyMath.min(x, y), z), w);}
/*2022*/public int max() {return MyMath.max(MyMath.max(MyMath.max(x, y), z), w);}
/*2022*///distance
/*2022*/public int lengthSquared() {return x * x + y * y + z * z + w * w;}
/*2022*/public int distanceSquared(Vec4i b) {return MyMath.sqr(x - b.x) + MyMath.sqr(y - b.y) + MyMath.sqr(z - b.z) + MyMath.sqr(w - b.w);}
/*2022*/public int distanceSquared(int x, int y, int z, int w) {return MyMath.sqr(this.x - x) + MyMath.sqr(this.y - y) + MyMath.sqr(this.z - z) + MyMath.sqr(this.w - w);}
/*2022*/public int manhattanLength() {return Math.abs(x) + Math.abs(y) + Math.abs(z) + Math.abs(w);}
/*2022*/public int manhattanDistance(Vec4i b) {return MyMath.abs(x - b.x) + MyMath.abs(y - b.y) + MyMath.abs(z - b.z) + MyMath.abs(w - b.w);}
/*2022*/public int manhattanDistance(int x, int y, int z, int w) {return MyMath.abs(this.x - x) + MyMath.abs(this.y - y) + MyMath.abs(this.z - z) + MyMath.abs(this.w - w);}
/*2022*///math
/*2022*/public int dot(Vec4i b) {return x * b.x + y * b.y + z * b.z + w * b.w;}
/*2022*/public int dot(int x, int y, int z, int w) {return this.x * x + this.y * y + this.z * z + this.w * w;}
/*2022*/public int scalarProduct(Vec4i b) {return dot(b);}
/*2022*/public Vec4i negative() {return new Vec4i(-x, -y, -z, -w);}
/*2022*///binary functions
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

    @Override
    public String toString() {
        return "w: " + w + " x: " + x + " y: " + y + " z: " + z;
    }

}