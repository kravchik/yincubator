package yk.jcommon.fastgeom;

import yk.jcommon.utils.MyMath;

import java.util.Objects;

import static yk.jcommon.fastgeom.Vec3f.v3;

public class Vec3l {
    public long x, y, z;

    public Vec3l() {
    }

    public Vec3f toFloat() {
        return v3(x, y, z);
    }

    public Vec3d toDouble() {
        return Vec3d.v3d(x, y, z);
    }

    //math
    public Vec3l crossProduct(final Vec3l b) {
        return new Vec3l(y * b.z - z * b.y, z * b.x - x * b.z, x * b.y - y * b.x);
    }
    public double distance(Vec3l b) {return MyMath.sqrt(MyMath.sqr(x - b.x) + MyMath.sqr(y - b.y) + MyMath.sqr(z - b.z));}

//2022 auto generated text
/*2022*///constructors
/*2022*/public Vec3l(long x, long y, long z) {this.x = x;this.y = y;this.z = z;}
/*2022*/public Vec3l(Vec3l other) {x = other.x;y = other.y;z = other.z;}
/*2022*/public Vec3l(long b) {x = b;y = b;z = b;}
/*2022*/public static Vec3l v3l(long x, long y, long z) {return new Vec3l(x, y, z);}
/*2022*/public static Vec3l v3l(long b) {return new Vec3l(b, b, b);}
/*2022*/public void fillFrom(Vec3l other) {x = other.x;y = other.y;z = other.z;}
/*2022*///operators
/*2022*/public Vec3l add(Vec3l b) {return new Vec3l(x + b.x, y + b.y, z + b.z);}
/*2022*/public Vec3l add(long b) {return new Vec3l(x + b, y + b, z + b);}
/*2022*/public Vec3l add(long x, long y, long z) {return new Vec3l(this.x + x, this.y + y, this.z + z);}
/*2022*/public Vec3l sub(Vec3l b) {return new Vec3l(x - b.x, y - b.y, z - b.z);}
/*2022*/public Vec3l sub(long b) {return new Vec3l(x - b, y - b, z - b);}
/*2022*/public Vec3l sub(long x, long y, long z) {return new Vec3l(this.x - x, this.y - y, this.z - z);}
/*2022*/public Vec3l mul(Vec3l b) {return new Vec3l(x * b.x, y * b.y, z * b.z);}
/*2022*/public Vec3l mul(long b) {return new Vec3l(x * b, y * b, z * b);}
/*2022*/public Vec3l mul(long x, long y, long z) {return new Vec3l(this.x * x, this.y * y, this.z * z);}
/*2022*/public Vec3l div(Vec3l b) {return new Vec3l(x / b.x, y / b.y, z / b.z);}
/*2022*/public Vec3l div(long b) {return new Vec3l(x / b, y / b, z / b);}
/*2022*/public Vec3l div(long x, long y, long z) {return new Vec3l(this.x / x, this.y / y, this.z / z);}
/*2022*///0 args functions
/*2022*/public Vec3l abs() {return new Vec3l(MyMath.abs(x), MyMath.abs(y), MyMath.abs(z));}
/*2022*///reducers
/*2022*/public long sum() {return x + y + z;}
/*2022*/public long product() {return x * y * z;}
/*2022*/public long min() {return MyMath.min(MyMath.min(x, y), z);}
/*2022*/public long max() {return MyMath.max(MyMath.max(x, y), z);}
/*2022*///distance
/*2022*/public long lengthSquared() {return x * x + y * y + z * z;}
/*2022*/public long distanceSquared(Vec3l b) {return MyMath.sqr(x - b.x) + MyMath.sqr(y - b.y) + MyMath.sqr(z - b.z);}
/*2022*/public long distanceSquared(long x, long y, long z) {return MyMath.sqr(this.x - x) + MyMath.sqr(this.y - y) + MyMath.sqr(this.z - z);}
/*2022*/public long manhattanLength() {return Math.abs(x) + Math.abs(y) + Math.abs(z);}
/*2022*/public long manhattanDistance(Vec3l b) {return MyMath.abs(x - b.x) + MyMath.abs(y - b.y) + MyMath.abs(z - b.z);}
/*2022*/public long manhattanDistance(long x, long y, long z) {return MyMath.abs(this.x - x) + MyMath.abs(this.y - y) + MyMath.abs(this.z - z);}
/*2022*///math
/*2022*/public long dot(Vec3l b) {return x * b.x + y * b.y + z * b.z;}
/*2022*/public long dot(long x, long y, long z) {return this.x * x + this.y * y + this.z * z;}
/*2022*/public long scalarProduct(Vec3l b) {return dot(b);}
/*2022*/public Vec3l negative() {return new Vec3l(-x, -y, -z);}
/*2022*///binary functions
/*2022*/public Vec3l min(Vec3l b) {return new Vec3l(MyMath.min(x, b.x), MyMath.min(y, b.y), MyMath.min(z, b.z));}
/*2022*/public Vec3l min(long b) {return new Vec3l(MyMath.min(x, b), MyMath.min(y, b), MyMath.min(z, b));}
/*2022*/public Vec3l min(long x, long y, long z) {return new Vec3l(MyMath.min(this.x, x), MyMath.min(this.y, y), MyMath.min(this.z, z));}
/*2022*/public Vec3l max(Vec3l b) {return new Vec3l(MyMath.max(x, b.x), MyMath.max(y, b.y), MyMath.max(z, b.z));}
/*2022*/public Vec3l max(long b) {return new Vec3l(MyMath.max(x, b), MyMath.max(y, b), MyMath.max(z, b));}
/*2022*/public Vec3l max(long x, long y, long z) {return new Vec3l(MyMath.max(this.x, x), MyMath.max(this.y, y), MyMath.max(this.z, z));}
/*2022*/public Vec3l cycle(Vec3l b) {return new Vec3l(MyMath.cycle(x, b.x), MyMath.cycle(y, b.y), MyMath.cycle(z, b.z));}
/*2022*/public Vec3l cycle(long b) {return new Vec3l(MyMath.cycle(x, b), MyMath.cycle(y, b), MyMath.cycle(z, b));}
/*2022*/public Vec3l cycle(long x, long y, long z) {return new Vec3l(MyMath.cycle(this.x, x), MyMath.cycle(this.y, y), MyMath.cycle(this.z, z));}
/*2022*/public Vec3l clamp(Vec3l min, Vec3l max) {return new Vec3l(Math.max(min.x, Math.min(x, max.x)), Math.max(min.y, Math.min(y, max.y)), Math.max(min.z, Math.min(z, max.z)));}
/*2022*/public Vec3l clamp(long min, long max) {return new Vec3l(Math.max(min, Math.min(x, max)), Math.max(min, Math.min(y, max)), Math.max(min, Math.min(z, max)));}
//2022 auto generated text


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vec3l vec3L = (Vec3l) o;
        return x == vec3L.x && y == vec3L.y && z == vec3L.z;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    @Override
    public String toString() {
        return "L3(" + x + "L, " + y + "L, " + z + "L)";
    }
}