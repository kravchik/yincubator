package yk.jcommon.fastgeom;

import yk.jcommon.utils.MyMath;

import java.io.Serializable;
import java.util.Objects;

/**
* User: Yuri Kravchik
* Date: 30.08.2010
* Time: 18:32:56
*/
@SuppressWarnings("SuspiciousNameCombination")
public final class Vec2i implements Serializable {
    public int x, y;

    public static final Vec2i ZERO = new Vec2i(0, 0);
    public static final Vec2i AXIS_X = new Vec2i(1, 0);
    public static final Vec2i AXIS_Y = new Vec2i(0, 1);

    //constructors
    public Vec2i() {x = 0;y = 0;}
    public static Vec2i v2i(int x, int y) {return new Vec2i(x, y);}
    public Vec2i(int x, int y) {this.x = x;this.y = y;}
    public Vec2i(Vec2i other) {x = other.x;y = other.y;}
    public Vec2f toVec2f() {return new Vec2f(x, y);}

    //distance
    public float disSquared(Vec2i b) {return MyMath.sqr(x - b.x) + MyMath.sqr(y - b.y);}
    public float dis(Vec2i b) {return (float) Math.sqrt(disSquared(b));}
    public float len() {return MyMath.sqr(x) + MyMath.sqr(y);}

    //math
    public float angle() {
        double len = len();
        double angle = Math.acos((double)x/len);
        if (y < 0) angle = 2 * Math.PI - angle;
        return (float) angle;
    }
    public Vec2i cMul(Vec2i other) {return v2i(x*other.x-y*other.y, x*other.y+y*other.x);}
    public Vec2i rot90() {return new Vec2i(-y, x);}
    public Vec2i rot_90() {return new Vec2i(y, -x);}
    public Vec2i negative() {return new Vec2i(-x, -y);}

    //2022 auto generated text
/*2022*///operators
/*2022*/public Vec2i add(Vec2i b) {return new Vec2i(x + b.x, y + b.y);}
/*2022*/public Vec2i add(int b) {return new Vec2i(x + b, y + b);}
/*2022*/public Vec2i add(int x, int y) {return new Vec2i(this.x + x, this.y + y);}
/*2022*/public Vec2i sub(Vec2i b) {return new Vec2i(x - b.x, y - b.y);}
/*2022*/public Vec2i sub(int b) {return new Vec2i(x - b, y - b);}
/*2022*/public Vec2i sub(int x, int y) {return new Vec2i(this.x - x, this.y - y);}
/*2022*/public Vec2i mul(Vec2i b) {return new Vec2i(x * b.x, y * b.y);}
/*2022*/public Vec2i mul(int b) {return new Vec2i(x * b, y * b);}
/*2022*/public Vec2i mul(int x, int y) {return new Vec2i(this.x * x, this.y * y);}
/*2022*/public Vec2i div(Vec2i b) {return new Vec2i(x / b.x, y / b.y);}
/*2022*/public Vec2i div(int b) {return new Vec2i(x / b, y / b);}
/*2022*/public Vec2i div(int x, int y) {return new Vec2i(this.x / x, this.y / y);}
/*2022*///0 args functions
/*2022*/public Vec2i abs() {return new Vec2i(MyMath.abs(x), MyMath.abs(y));}
/*2022*///reducers
/*2022*/public int sum() {return x + y;}
/*2022*/public int product() {return x * y;}
/*2022*/public int min() {return MyMath.min(x, y);}
/*2022*/public int max() {return MyMath.max(x, y);}
/*2022*/public int maxAbs() {return Math.max(Math.abs(x), Math.abs(y));}
/*2022*/public int minAbs() {return Math.min(Math.abs(x), Math.abs(y));}
/*2022*///binary functions
/*2022*/public Vec2i min(Vec2i b) {return new Vec2i(MyMath.min(x, b.x), MyMath.min(y, b.y));}
/*2022*/public Vec2i min(int b) {return new Vec2i(MyMath.min(x, b), MyMath.min(y, b));}
/*2022*/public Vec2i min(int x, int y) {return new Vec2i(MyMath.min(x, x), MyMath.min(y, y));}
/*2022*/public Vec2i max(Vec2i b) {return new Vec2i(MyMath.max(x, b.x), MyMath.max(y, b.y));}
/*2022*/public Vec2i max(int b) {return new Vec2i(MyMath.max(x, b), MyMath.max(y, b));}
/*2022*/public Vec2i max(int x, int y) {return new Vec2i(MyMath.max(x, x), MyMath.max(y, y));}
/*2022*/public Vec2i cycle(Vec2i b) {return new Vec2i(MyMath.cycle(x, b.x), MyMath.cycle(y, b.y));}
/*2022*/public Vec2i cycle(int b) {return new Vec2i(MyMath.cycle(x, b), MyMath.cycle(y, b));}
/*2022*/public Vec2i cycle(int x, int y) {return new Vec2i(MyMath.cycle(x, x), MyMath.cycle(y, y));}
//2022 auto generated text

    @Override
    public String toString() {return x + ":" + y;}

    public boolean equals(int x, int y) {
        return this.x == x && this.y == y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vec2i vec2i = (Vec2i) o;
        return x == vec2i.x && y == vec2i.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}