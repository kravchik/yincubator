package yk.jcommon.fastgeom;

import yk.jcommon.utils.MyMath;

import java.io.Serializable;

import static java.lang.Math.abs;
import static yk.jcommon.utils.MyMath.sqr;

/**
 * Created with IntelliJ IDEA.
 * User: yuri
 * Date: 24/09/15
 * Time: 11:10
 */
public final class Vec3i implements Serializable {
    public int x, y, z;

    public static final Vec3i ZERO = new Vec3i();
    public static final Vec3i AXIS_X = new Vec3i(1, 0, 0);
    public static final Vec3i AXIS_Y = new Vec3i(0, 1, 0);
    public static final Vec3i AXIS_Z = new Vec3i(0, 0, 1);

    public Vec3i(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static Vec3i v3(int x, int y, int z) {
        return new Vec3i(x, y, z);
    }

    public Vec3i(Vec3i other) {
        this.x = other.x;
        this.y = other.y;
        this.z = other.z;
    }

    public void copyFrom(Vec3i other) {
        x = other.x;
        y = other.y;
        z = other.z;
    }

    public void seAdd(Vec3i other) {
        x = x + other.x;
        y = y + other.y;
        z = z + other.z;
    }

    public void seAdd(int scalar) {
        x = x + scalar;
        y = y + scalar;
        z = z + scalar;
    }

    public void seAdd(int x, int y, int z) {
        this.x = this.x + x;
        this.y = this.y + y;
        this.z = this.z + z;
    }

    public void seSub(Vec3i other) {
        x = x - other.x;
        y = y - other.y;
        z = z - other.z;
    }

    public void seSub(int scalar) {
        x = x - scalar;
        y = y - scalar;
        z = z - scalar;
    }

    public void seSub(int x, int y, int z) {
        this.x = this.x - x;
        this.y = this.y - y;
        this.z = this.z - z;
    }

    public void seMul(Vec3i other) {
        x = x * other.x;
        y = y * other.y;
        z = z * other.z;
    }

    public void seMul(int scalar) {
        x = x * scalar;
        y = y * scalar;
        z = z * scalar;
    }

    public void seMul(int x, int y, int z) {
        this.x = this.x * x;
        this.y = this.y * y;
        this.z = this.z * z;
    }

    public void seDiv(Vec3i other) {
        x = x / other.x;
        y = y / other.y;
        z = z / other.z;
    }

    public void seDiv(int scalar) {
        x = x / scalar;
        y = y / scalar;
        z = z / scalar;
    }

    public void seDiv(int x, int y, int z) {
        this.x = this.x / x;
        this.y = this.y / y;
        this.z = this.z / z;
    }

    public float dist(Vec3i other) {
        return (float)Math.sqrt(MyMath.sqr(other.x - this.x) + MyMath.sqr(other.y - this.y) + MyMath.sqr(other.z - this.z));
    }

    public float length() {
        return (float)Math.sqrt(x * x + y * y + z * z);
    }

    public float lengthSquared() {
        return x * x + y * y + z * z;
    }

    public int lengthManhattan() {
        return x + y + z;
    }

    public int scalarProduct(Vec3i other) {
        return x * other.x + y * other.y + z * other.z;
    }

    public int dot(Vec3i other) {
        return x * other.x + y * other.y + z * other.z;
    }

    public Vec3i round() {
        return v3i(Math.round(x), Math.round(y), Math.round(z));
    }

    public static float distanceSquared(Vec3i a, Vec3i b) {
        return sqr(a.x - b.x) + sqr(a.y - b.y) + sqr(a.z - b.z);
    }

    public Vec3i withSetX(int x) {
        return new Vec3i(x, y, z);
    }

    public Vec3i withSetY(int y) {
        return new Vec3i(x, y, z);
    }

    public Vec3i withSetZ(int z) {
        return new Vec3i(x, y, z);
    }

    public String toString() {
        return "" + x + " " + y + " " + z;
    }

    public Vec3f toVec3f() {
        return new Vec3f(x, y, z);
    }

    public static Vec3i v3i(int x, int y, int z) {
        return new Vec3i(x, y, z);
    }

    public int manhattanDistanceTo(Vec3i other) {
        return abs(other.x - x) + abs(other.y - y) + abs(other.z - z);
    }

    public Vec3i() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vec3i vec3i = (Vec3i) o;

        if (x != vec3i.x) return false;
        if (y != vec3i.y) return false;
        if (z != vec3i.z) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        result = 31 * result + z;
        return result;
    }

    public Vec2i getXy() {
        return new Vec2i(x, y);
    }
    public Vec2i getXz() {
        return new Vec2i(x, z);
    }
    public Vec2i getYz() {
        return new Vec2i(y, z);
    }

//2022 auto generated text
/*2022*/public Vec3i add(Vec3i other) {return new Vec3i(x + other.x, y + other.y, z + other.z);}
/*2022*/public Vec3i add(int v) {return new Vec3i(x + v, y + v, z + v);}
/*2022*/public Vec3i add(int x, int y, int z) {return new Vec3i(this.x + x, this.y + y, this.z + z);}
/*2022*/public Vec3i sub(Vec3i other) {return new Vec3i(x - other.x, y - other.y, z - other.z);}
/*2022*/public Vec3i sub(int v) {return new Vec3i(x - v, y - v, z - v);}
/*2022*/public Vec3i sub(int x, int y, int z) {return new Vec3i(this.x - x, this.y - y, this.z - z);}
/*2022*/public Vec3i mul(Vec3i other) {return new Vec3i(x * other.x, y * other.y, z * other.z);}
/*2022*/public Vec3i mul(int v) {return new Vec3i(x * v, y * v, z * v);}
/*2022*/public Vec3i mul(int x, int y, int z) {return new Vec3i(this.x * x, this.y * y, this.z * z);}
/*2022*/public Vec3i div(Vec3i other) {return new Vec3i(x / other.x, y / other.y, z / other.z);}
/*2022*/public Vec3i div(int v) {return new Vec3i(x / v, y / v, z / v);}
/*2022*/public Vec3i div(int x, int y, int z) {return new Vec3i(this.x / x, this.y / y, this.z / z);}
/*2022*/public Vec3i min(Vec3i b) {return new Vec3i(MyMath.min(x, b.x), MyMath.min(y, b.y), MyMath.min(z, b.z));}
/*2022*/public Vec3i min(int b) {return new Vec3i(MyMath.min(x, b), MyMath.min(y, b), MyMath.min(z, b));}
/*2022*/public Vec3i min(int x, int y, int z) {return new Vec3i(MyMath.min(this.x, x), MyMath.min(this.y, y), MyMath.min(this.z, z));}
/*2022*/public Vec3i max(Vec3i b) {return new Vec3i(MyMath.max(x, b.x), MyMath.max(y, b.y), MyMath.max(z, b.z));}
/*2022*/public Vec3i max(int b) {return new Vec3i(MyMath.max(x, b), MyMath.max(y, b), MyMath.max(z, b));}
/*2022*/public Vec3i max(int x, int y, int z) {return new Vec3i(MyMath.max(this.x, x), MyMath.max(this.y, y), MyMath.max(this.z, z));}
/*2022*/public Vec3i cycle(Vec3i b) {return new Vec3i(MyMath.cycle(x, b.x), MyMath.cycle(y, b.y), MyMath.cycle(z, b.z));}
/*2022*/public Vec3i cycle(int b) {return new Vec3i(MyMath.cycle(x, b), MyMath.cycle(y, b), MyMath.cycle(z, b));}
/*2022*/public Vec3i cycle(int x, int y, int z) {return new Vec3i(MyMath.cycle(this.x, x), MyMath.cycle(this.y, y), MyMath.cycle(this.z, z));}
//2022 auto generated text

}