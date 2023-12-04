package yk.jcommon.fastgeom;

import yk.jcommon.utils.MyMath;
import yk.jcommon.utils.Reflector;
import yk.ycollections.YList;

import java.io.Serializable;

/**
* User: Yuri Kravchik
* Date: 30.08.2010
* Time: 18:32:56
*/
public final class Vec2i implements Serializable {
    public int x, y;

    public static Vec2i ZERO = new Vec2i(0, 0);
    public static final Vec2i AXIS_X = new Vec2i(1, 0);
    public static final Vec2i AXIS_Y = new Vec2i(0, 1);

    public Vec2i() {
        x = 0;
        y = 0;
    }

    public static Vec2i v2i(int x, int y) {
        return new Vec2i(x, y);
    }

    public Vec2i(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Vec2i(Vec2i other) {
        x = other.x;
        y = other.y;
    }

    public float disSquared(Vec2i b) {
        int dx = x - b.x;
        int dy = y - b.y;
        return dx * dx + dy * dy;
    }

    public float dis(Vec2i b) {
        return (float) Math.sqrt(disSquared(b));
    }

    public Vec2i addX(int x) {
        return new Vec2i(this.x + x, y);
    }
    public Vec2i addY(int y) {
        return new Vec2i(x, this.y + y);
    }
    public boolean is(int x, int y) {
        return this.x == x && this.y == y;
    }

    @Override
    public String toString() {
        return x + ":" + y;
    }

    public Vec2i mul(float i) {
        return new Vec2i((int)(x * i), (int)(y * i));
    }

    public Vec2i mul(float ox, float oy) {
        return new Vec2i((int)(x * ox), (int)(y * oy));
    }

    public Vec2i div(float i) {
        return new Vec2i((int)(x / i), (int)(y / i));
    }

    public Vec2i rnd(int radius) {
        return new Vec2i(x + (int) (-radius + Math.random() * radius * 2),
                y + (int) (-radius + Math.random() * radius * 2));
    }

    public Vec2f toVec2f() {
        return new Vec2f(x, y);
    }

    public float len() {
        return dis(ZERO);
    }

    public float angle() {
        double len = len();
        double angle = Math.acos((double)x/len);
        if (y < 0) angle = 2 * Math.PI - angle;
        return (float) angle;
    }

    public void init(YList elements) {
        //TODO remove
        Reflector.set(this, "x", ((Number)elements.get(0)).intValue());
        Reflector.set(this, "y", ((Number)elements.get(1)).intValue());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vec2i vec2i = (Vec2i) o;

        if (x != vec2i.x) return false;
        if (y != vec2i.y) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

//2022 auto generated text
/*2022*/public Vec2i add(Vec2i other) {return new Vec2i(x + other.x, y + other.y);}
/*2022*/public Vec2i add(int v) {return new Vec2i(x + v, y + v);}
/*2022*/public Vec2i add(int x, int y) {return new Vec2i(this.x + x, this.y + y);}
/*2022*/public Vec2i sub(Vec2i other) {return new Vec2i(x - other.x, y - other.y);}
/*2022*/public Vec2i sub(int v) {return new Vec2i(x - v, y - v);}
/*2022*/public Vec2i sub(int x, int y) {return new Vec2i(this.x - x, this.y - y);}
/*2022*/public Vec2i mul(Vec2i other) {return new Vec2i(x * other.x, y * other.y);}
/*2022*/public Vec2i mul(int v) {return new Vec2i(x * v, y * v);}
/*2022*/public Vec2i mul(int x, int y) {return new Vec2i(this.x * x, this.y * y);}
/*2022*/public Vec2i div(Vec2i other) {return new Vec2i(x / other.x, y / other.y);}
/*2022*/public Vec2i div(int v) {return new Vec2i(x / v, y / v);}
/*2022*/public Vec2i div(int x, int y) {return new Vec2i(this.x / x, this.y / y);}
/*2022*/public Vec2i min(Vec2i b) {return new Vec2i(MyMath.min(x, b.x), MyMath.min(y, b.y));}
/*2022*/public Vec2i min(int b) {return new Vec2i(MyMath.min(x, b), MyMath.min(y, b));}
/*2022*/public Vec2i min(int x, int y) {return new Vec2i(MyMath.min(this.x, x), MyMath.min(this.y, y));}
/*2022*/public Vec2i max(Vec2i b) {return new Vec2i(MyMath.max(x, b.x), MyMath.max(y, b.y));}
/*2022*/public Vec2i max(int b) {return new Vec2i(MyMath.max(x, b), MyMath.max(y, b));}
/*2022*/public Vec2i max(int x, int y) {return new Vec2i(MyMath.max(this.x, x), MyMath.max(this.y, y));}
/*2022*/public Vec2i cycle(Vec2i b) {return new Vec2i(MyMath.cycle(x, b.x), MyMath.cycle(y, b.y));}
/*2022*/public Vec2i cycle(int b) {return new Vec2i(MyMath.cycle(x, b), MyMath.cycle(y, b));}
/*2022*/public Vec2i cycle(int x, int y) {return new Vec2i(MyMath.cycle(this.x, x), MyMath.cycle(this.y, y));}
//2022 auto generated text

}