package yk.jcommon.fastgeom;

import yk.jcommon.utils.MyMath;

import static yk.jcommon.fastgeom.Vec3f.v3;

//TODO rename ?
//Vec3i Vec3f Vec3d Vec3l
//Vec3i Vec3f Vec3D Vec3L
//Vec3i Vec3f Vec3d Vec3l
//VecI3 VecF3 VecD3 VecL3

//.v3i .v3f .v3d .v3l
//.v3i .v3f .v3D .v3L
//.i3 .f3 .d3 .l3
//.I3 .F3 .D3 .L3
//.i3 .f3 .double3 .long3

//VecF3, VecD3
//v3/vf3, vd3, vbi3

//leave as it is? v3, v3f, v3i, v3d, v3l, v3bi

public class Vec3d {
    public double x, y, z;

    public Vec3d() {
    }

    public Vec3f toFloat() {
        return v3((float) x, (float) y, (float) z);
    }

    public Vec3l toLong() {
        return Vec3l.v3l((long) x, (long) y, (long) z);
    }

    //math
    public Vec3d crossProduct(final Vec3d b) {
        return new Vec3d(y * b.z - z * b.y, z * b.x - x * b.z, x * b.y - y * b.x);
    }

    public Vec3d withX(double x) {
        return new Vec3d(x, y, z);
    }

    public Vec3d withY(double y) {
        return new Vec3d(x, y, z);
    }

    public Vec3d withZ(double z) {
        return new Vec3d(x, y, z);
    }

//2022 auto generated text
/*2022*///constructors
/*2022*/public Vec3d(double x, double y, double z) {this.x = x;this.y = y;this.z = z;}
/*2022*/public Vec3d(Vec3d other) {x = other.x;y = other.y;z = other.z;}
/*2022*/public Vec3d(double b) {x = b;y = b;z = b;}
/*2022*/public static Vec3d v3d(double x, double y, double z) {return new Vec3d(x, y, z);}
/*2022*/public static Vec3d v3d(double b) {return new Vec3d(b, b, b);}
/*2022*/public void fillFrom(Vec3d other) {x = other.x;y = other.y;z = other.z;}
/*2022*///operators
/*2022*/public Vec3d add(Vec3d b) {return new Vec3d(x + b.x, y + b.y, z + b.z);}
/*2022*/public Vec3d add(double b) {return new Vec3d(x + b, y + b, z + b);}
/*2022*/public Vec3d add(double x, double y, double z) {return new Vec3d(this.x + x, this.y + y, this.z + z);}
/*2022*/public Vec3d sub(Vec3d b) {return new Vec3d(x - b.x, y - b.y, z - b.z);}
/*2022*/public Vec3d sub(double b) {return new Vec3d(x - b, y - b, z - b);}
/*2022*/public Vec3d sub(double x, double y, double z) {return new Vec3d(this.x - x, this.y - y, this.z - z);}
/*2022*/public Vec3d mul(Vec3d b) {return new Vec3d(x * b.x, y * b.y, z * b.z);}
/*2022*/public Vec3d mul(double b) {return new Vec3d(x * b, y * b, z * b);}
/*2022*/public Vec3d mul(double x, double y, double z) {return new Vec3d(this.x * x, this.y * y, this.z * z);}
/*2022*/public Vec3d div(Vec3d b) {return new Vec3d(x / b.x, y / b.y, z / b.z);}
/*2022*/public Vec3d div(double b) {return new Vec3d(x / b, y / b, z / b);}
/*2022*/public Vec3d div(double x, double y, double z) {return new Vec3d(this.x / x, this.y / y, this.z / z);}
/*2022*///0 args functions
/*2022*/public Vec3d round() {return new Vec3d(Math.round(x), Math.round(y), Math.round(z));}
/*2022*/public Vec3d floor() {return new Vec3d(MyMath.floorFast(x), MyMath.floorFast(y), MyMath.floorFast(z));}
/*2022*/public Vec3d ceil() {return new Vec3d(MyMath.ceil(x), MyMath.ceil(y), MyMath.ceil(z));}
/*2022*/public Vec3d abs() {return new Vec3d(MyMath.abs(x), MyMath.abs(y), MyMath.abs(z));}
/*2022*///reducers
/*2022*/public double sum() {return x + y + z;}
/*2022*/public double product() {return x * y * z;}
/*2022*/public double min() {return MyMath.min(MyMath.min(x, y), z);}
/*2022*/public double max() {return MyMath.max(MyMath.max(x, y), z);}
/*2022*///distance
/*2022*/public double lengthSquared() {return x * x + y * y + z * z;}
/*2022*/public double distanceSquared(Vec3d b) {return MyMath.sqr(x - b.x) + MyMath.sqr(y - b.y) + MyMath.sqr(z - b.z);}
/*2022*/public double distanceSquared(double x, double y, double z) {return MyMath.sqr(this.x - x) + MyMath.sqr(this.y - y) + MyMath.sqr(this.z - z);}
/*2022*/public double manhattanLength() {return Math.abs(x) + Math.abs(y) + Math.abs(z);}
/*2022*/public double manhattanDistance(Vec3d b) {return MyMath.abs(x - b.x) + MyMath.abs(y - b.y) + MyMath.abs(z - b.z);}
/*2022*/public double manhattanDistance(double x, double y, double z) {return MyMath.abs(this.x - x) + MyMath.abs(this.y - y) + MyMath.abs(this.z - z);}
/*2022*/public double length() {return MyMath.sqrt(x * x + y * y + z * z);}
/*2022*/public Vec3d normalized() {
/*2022*/    double m = 1f / MyMath.sqrt(x * x + y * y + z * z);
/*2022*/    return new Vec3d(x * m, y * m, z * m);
/*2022*/}
/*2022*/public Vec3d normalized(double len) {
/*2022*/    double m = len / Math.sqrt(x * x + y * y + z * z);
/*2022*/    return new Vec3d(x * m, y * m, z * m);
/*2022*/}
/*2022*/public double distance(Vec3d b) {return MyMath.sqrt(MyMath.sqr(x - b.x) + MyMath.sqr(y - b.y) + MyMath.sqr(z - b.z));}
/*2022*/public double distance(double x, double y, double z) {return MyMath.sqrt(MyMath.sqr(this.x - x) + MyMath.sqr(this.y - y) + MyMath.sqr(this.z - z));}
/*2022*///math
/*2022*/public double dot(Vec3d b) {return x * b.x + y * b.y + z * b.z;}
/*2022*/public double dot(double x, double y, double z) {return this.x * x + this.y * y + this.z * z;}
/*2022*/public double scalarProduct(Vec3d b) {return dot(b);}
/*2022*/public Vec3d negative() {return new Vec3d(-x, -y, -z);}
/*2022*///binary functions
/*2022*/public Vec3d min(Vec3d b) {return new Vec3d(MyMath.min(x, b.x), MyMath.min(y, b.y), MyMath.min(z, b.z));}
/*2022*/public Vec3d min(double b) {return new Vec3d(MyMath.min(x, b), MyMath.min(y, b), MyMath.min(z, b));}
/*2022*/public Vec3d min(double x, double y, double z) {return new Vec3d(MyMath.min(this.x, x), MyMath.min(this.y, y), MyMath.min(this.z, z));}
/*2022*/public Vec3d max(Vec3d b) {return new Vec3d(MyMath.max(x, b.x), MyMath.max(y, b.y), MyMath.max(z, b.z));}
/*2022*/public Vec3d max(double b) {return new Vec3d(MyMath.max(x, b), MyMath.max(y, b), MyMath.max(z, b));}
/*2022*/public Vec3d max(double x, double y, double z) {return new Vec3d(MyMath.max(this.x, x), MyMath.max(this.y, y), MyMath.max(this.z, z));}
/*2022*/public Vec3d cycle(Vec3d b) {return new Vec3d(MyMath.cycle(x, b.x), MyMath.cycle(y, b.y), MyMath.cycle(z, b.z));}
/*2022*/public Vec3d cycle(double b) {return new Vec3d(MyMath.cycle(x, b), MyMath.cycle(y, b), MyMath.cycle(z, b));}
/*2022*/public Vec3d cycle(double x, double y, double z) {return new Vec3d(MyMath.cycle(this.x, x), MyMath.cycle(this.y, y), MyMath.cycle(this.z, z));}
/*2022*/public Vec3d clamp(Vec3d min, Vec3d max) {return new Vec3d(Math.max(min.x, Math.min(x, max.x)), Math.max(min.y, Math.min(y, max.y)), Math.max(min.z, Math.min(z, max.z)));}
/*2022*/public Vec3d clamp(double min, double max) {return new Vec3d(Math.max(min, Math.min(x, max)), Math.max(min, Math.min(y, max)), Math.max(min, Math.min(z, max)));}
//2022 auto generated text

    @Override
    public String toString() {
        return "Vec3d(" + x + " " + y + " " + z + ")";
    }
}