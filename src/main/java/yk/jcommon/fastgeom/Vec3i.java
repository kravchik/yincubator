package yk.jcommon.fastgeom;

import yk.jcommon.utils.MyMath;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 * User: yuri
 * Date: 24/09/15
 * Time: 11:10
 */
@SuppressWarnings("SuspiciousNameCombination")
public final class Vec3i implements Serializable {
    public int x, y, z;

    public static final Vec3i ZERO = new Vec3i();
    public static final Vec3i AXIS_X = new Vec3i(1, 0, 0);
    public static final Vec3i AXIS_Y = new Vec3i(0, 1, 0);
    public static final Vec3i AXIS_Z = new Vec3i(0, 0, 1);

    public Vec3i() {
    }

    public float distance(Vec3i other) {
        return (float)Math.sqrt(MyMath.sqr(other.x - this.x) + MyMath.sqr(other.y - this.y) + MyMath.sqr(other.z - this.z));
    }

    public float length() {
        return (float)Math.sqrt(x * x + y * y + z * z);
    }

    public Vec3i withX(int x) {return new Vec3i(x, y, z);}
    public Vec3i withY(int y) {return new Vec3i(x, y, z);}
    public Vec3i withZ(int z) {return new Vec3i(x, y, z);}
    public Vec3f toVec3f() {return new Vec3f(x, y, z);}
    public Vec2i getXy() {return new Vec2i(x, y);}
    public Vec2i getXz() {return new Vec2i(x, z);}
    public Vec2i getYz() {return new Vec2i(y, z);}

//2022 auto generated text
/*2022*///constructors
/*2022*/public Vec3i(int x, int y, int z) {this.x = x;this.y = y;this.z = z;}
/*2022*/public Vec3i(Vec3i other) {x = other.x;y = other.y;z = other.z;}
/*2022*/public Vec3i(int b) {x = b;y = b;z = b;}
/*2022*/public static Vec3i v3i(int x, int y, int z) {return new Vec3i(x, y, z);}
/*2022*/public static Vec3i v3i(int b) {return new Vec3i(b, b, b);}
/*2022*/public void fillFrom(Vec3i other) {x = other.x;y = other.y;z = other.z;}
/*2022*///operators
/*2022*/public Vec3i add(Vec3i b) {return new Vec3i(x + b.x, y + b.y, z + b.z);}
/*2022*/public Vec3i add(int b) {return new Vec3i(x + b, y + b, z + b);}
/*2022*/public Vec3i add(int x, int y, int z) {return new Vec3i(this.x + x, this.y + y, this.z + z);}
/*2022*/public Vec3i sub(Vec3i b) {return new Vec3i(x - b.x, y - b.y, z - b.z);}
/*2022*/public Vec3i sub(int b) {return new Vec3i(x - b, y - b, z - b);}
/*2022*/public Vec3i sub(int x, int y, int z) {return new Vec3i(this.x - x, this.y - y, this.z - z);}
/*2022*/public Vec3i mul(Vec3i b) {return new Vec3i(x * b.x, y * b.y, z * b.z);}
/*2022*/public Vec3i mul(int b) {return new Vec3i(x * b, y * b, z * b);}
/*2022*/public Vec3i mul(int x, int y, int z) {return new Vec3i(this.x * x, this.y * y, this.z * z);}
/*2022*/public Vec3i div(Vec3i b) {return new Vec3i(x / b.x, y / b.y, z / b.z);}
/*2022*/public Vec3i div(int b) {return new Vec3i(x / b, y / b, z / b);}
/*2022*/public Vec3i div(int x, int y, int z) {return new Vec3i(this.x / x, this.y / y, this.z / z);}
/*2022*///0 args functions
/*2022*/public Vec3i abs() {return new Vec3i(MyMath.abs(x), MyMath.abs(y), MyMath.abs(z));}
/*2022*///reducers
/*2022*/public int sum() {return x + y + z;}
/*2022*/public int product() {return x * y * z;}
/*2022*/public int min() {return MyMath.min(MyMath.min(x, y), z);}
/*2022*/public int max() {return MyMath.max(MyMath.max(x, y), z);}
/*2022*///distance
/*2022*/public int lengthSquared() {return x * x + y * y + z * z;}
/*2022*/public int distanceSquared(Vec3i b) {return MyMath.sqr(x - b.x) + MyMath.sqr(y - b.y) + MyMath.sqr(z - b.z);}
/*2022*/public int distanceSquared(int x, int y, int z) {return MyMath.sqr(this.x - x) + MyMath.sqr(this.y - y) + MyMath.sqr(this.z - z);}
/*2022*/public int manhattanLength() {return Math.abs(x) + Math.abs(y) + Math.abs(z);}
/*2022*/public int manhattanDistance(Vec3i b) {return MyMath.abs(x - b.x) + MyMath.abs(y - b.y) + MyMath.abs(z - b.z);}
/*2022*/public int manhattanDistance(int x, int y, int z) {return MyMath.abs(this.x - x) + MyMath.abs(this.y - y) + MyMath.abs(this.z - z);}
/*2022*///math
/*2022*/public int dot(Vec3i b) {return x * b.x + y * b.y + z * b.z;}
/*2022*/public int dot(int x, int y, int z) {return this.x * x + this.y * y + this.z * z;}
/*2022*/public int scalarProduct(Vec3i b) {return dot(b);}
/*2022*/public Vec3i negative() {return new Vec3i(-x, -y, -z);}
/*2022*///binary functions
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

    public String toString() {
        return "" + x + " " + y + " " + z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vec3i vec3i = (Vec3i) o;
        return x == vec3i.x && y == vec3i.y && z == vec3i.z;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }
}