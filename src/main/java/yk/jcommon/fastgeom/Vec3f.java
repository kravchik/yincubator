/**
 * File Vec3.java
 * @author Yuri Kravchik
 * Created 16.10.2008
 */
package yk.jcommon.fastgeom;

import yk.jcommon.utils.MyMath;

import java.io.Serializable;
import java.util.Objects;

import static yk.jcommon.fastgeom.Vec3i.v3i;

/**
 * Vec3
 *
 * @author Yuri Kravchik Created 16.10.2008
 */
@SuppressWarnings("SuspiciousNameCombination")
public final class Vec3f implements Serializable {
    public float x, y, z;

    public static final Vec3f ZERO = new Vec3f();
    public static final Vec3f AXIS_X = new Vec3f(1, 0, 0);
    public static final Vec3f AXIS_Y = new Vec3f(0, 1, 0);
    public static final Vec3f AXIS_Z = new Vec3f(0, 0, 1);

    //constructors
    public Vec3f() {}
    public Vec3f(Vec2f v, float z) {this(v.x, v.y, z);}
    public static Vec3f v3(Vec2f v, float z) {return new Vec3f(v.x, v.y, z);}
    public Vec3i toVec3i() {return v3i((int)x, (int)y, (int)z);}
    public Vec2f getXy() {return new Vec2f(x, y);}
    public Vec2f getXz() {return new Vec2f(x, z);}
    public Vec2f getYz() {return new Vec2f(y, z);}
    public Vec4f toVec4f(float w) {return new Vec4f(x, y, z, w);}

    //setters
    public void setXy(Vec2f v) {this.x = v.x;this.y = v.y;}
    public void setXyz(float x, float y, float z) {this.x = x;this.y = y;this.z = z;}
    public Vec3f withX(float value) {return new Vec3f(value, y, z);}
    public Vec3f withY(float value) {return new Vec3f(x, value, z);}
    public Vec3f withZ(float value) {return new Vec3f(x, y, value);}

    //math
    public Vec3f limit(float max) {
        float l = this.length();
        return l > max ? this.normalized(max) : this;
    }
    public Vec3f limit(Vec3f center, float max) {return (this.sub(center)).limit(max).add(center);}
    public Vec3f crossProduct(final Vec3f b) {
        return new Vec3f(y * b.z - z * b.y, z * b.x - x * b.z, x * b.y - y * b.x);
    }
    public Vec3f mirror(Vec3f around) {return sub(around).mul(-1).add(around);}
    public Vec3f getXFor(Vec3f normalizedAxis) {
        return normalizedAxis.mul(normalizedAxis.scalarProduct(this));
    }
    public Vec3f getYFor(Vec3f normalizedAxis) {
        return this.sub(getXFor(normalizedAxis));
    }
    public Vec3f normalTo(Vec3f normalizedAxis) {
        Vec3f normal = getYFor(normalizedAxis);
        if (normal.lengthSquared() > 0.00001f) {
            return normal.normalized();
        }
        return null;
    }
    public Vec3f projectOnAxis(Vec3f normalizedAxis) {
        return normalizedAxis.mul(normalizedAxis.scalarProduct(this));
    }
    public Vec3f projectOnPlane(Vec3f normalizedAxis) {
        return this.sub(this.projectOnAxis(normalizedAxis));
    }

//2022 auto generated text
/*2022*///constructors
/*2022*/public Vec3f(float x, float y, float z) {this.x = x;this.y = y;this.z = z;}
/*2022*/public Vec3f(Vec3f other) {x = other.x;y = other.y;z = other.z;}
/*2022*/public Vec3f(float b) {x = b;y = b;z = b;}
/*2022*/public static Vec3f v3(float x, float y, float z) {return new Vec3f(x, y, z);}
/*2022*/public static Vec3f v3(float b) {return new Vec3f(b, b, b);}
/*2022*/public void fillFrom(Vec3f other) {x = other.x;y = other.y;z = other.z;}
/*2022*///operators
/*2022*/public Vec3f add(Vec3f b) {return new Vec3f(x + b.x, y + b.y, z + b.z);}
/*2022*/public Vec3f add(float b) {return new Vec3f(x + b, y + b, z + b);}
/*2022*/public Vec3f add(float x, float y, float z) {return new Vec3f(this.x + x, this.y + y, this.z + z);}
/*2022*/public Vec3f sub(Vec3f b) {return new Vec3f(x - b.x, y - b.y, z - b.z);}
/*2022*/public Vec3f sub(float b) {return new Vec3f(x - b, y - b, z - b);}
/*2022*/public Vec3f sub(float x, float y, float z) {return new Vec3f(this.x - x, this.y - y, this.z - z);}
/*2022*/public Vec3f mul(Vec3f b) {return new Vec3f(x * b.x, y * b.y, z * b.z);}
/*2022*/public Vec3f mul(float b) {return new Vec3f(x * b, y * b, z * b);}
/*2022*/public Vec3f mul(float x, float y, float z) {return new Vec3f(this.x * x, this.y * y, this.z * z);}
/*2022*/public Vec3f div(Vec3f b) {return new Vec3f(x / b.x, y / b.y, z / b.z);}
/*2022*/public Vec3f div(float b) {return new Vec3f(x / b, y / b, z / b);}
/*2022*/public Vec3f div(float x, float y, float z) {return new Vec3f(this.x / x, this.y / y, this.z / z);}
/*2022*///0 args functions
/*2022*/public Vec3f round() {return new Vec3f(Math.round(x), Math.round(y), Math.round(z));}
/*2022*/public Vec3f floor() {return new Vec3f(MyMath.floorFast(x), MyMath.floorFast(y), MyMath.floorFast(z));}
/*2022*/public Vec3f ceil() {return new Vec3f(MyMath.ceil(x), MyMath.ceil(y), MyMath.ceil(z));}
/*2022*/public Vec3f abs() {return new Vec3f(MyMath.abs(x), MyMath.abs(y), MyMath.abs(z));}
/*2022*///reducers
/*2022*/public float sum() {return x + y + z;}
/*2022*/public float product() {return x * y * z;}
/*2022*/public float min() {return MyMath.min(MyMath.min(x, y), z);}
/*2022*/public float max() {return MyMath.max(MyMath.max(x, y), z);}
/*2022*///distance
/*2022*/public float lengthSquared() {return x * x + y * y + z * z;}
/*2022*/public float distanceSquared(Vec3f b) {return MyMath.sqr(x - b.x) + MyMath.sqr(y - b.y) + MyMath.sqr(z - b.z);}
/*2022*/public float distanceSquared(float x, float y, float z) {return MyMath.sqr(this.x - x) + MyMath.sqr(this.y - y) + MyMath.sqr(this.z - z);}
/*2022*/public float manhattanLength() {return Math.abs(x) + Math.abs(y) + Math.abs(z);}
/*2022*/public float manhattanDistance(Vec3f b) {return MyMath.abs(x - b.x) + MyMath.abs(y - b.y) + MyMath.abs(z - b.z);}
/*2022*/public float manhattanDistance(float x, float y, float z) {return MyMath.abs(this.x - x) + MyMath.abs(this.y - y) + MyMath.abs(this.z - z);}
/*2022*/public float length() {return MyMath.sqrt(x * x + y * y + z * z);}
/*2022*/public Vec3f normalized() {
/*2022*/    float m = 1f / MyMath.sqrt(x * x + y * y + z * z);
/*2022*/    return new Vec3f(x * m, y * m, z * m);
/*2022*/}
/*2022*/public Vec3f normalized(float len) {
/*2022*/    float m = len / (float)Math.sqrt(x * x + y * y + z * z);
/*2022*/    return new Vec3f(x * m, y * m, z * m);
/*2022*/}
/*2022*/public float distance(Vec3f b) {return MyMath.sqrt(MyMath.sqr(x - b.x) + MyMath.sqr(y - b.y) + MyMath.sqr(z - b.z));}
/*2022*/public float distance(float x, float y, float z) {return MyMath.sqrt(MyMath.sqr(this.x - x) + MyMath.sqr(this.y - y) + MyMath.sqr(this.z - z));}
/*2022*///math
/*2022*/public float dot(Vec3f b) {return x * b.x + y * b.y + z * b.z;}
/*2022*/public float dot(float x, float y, float z) {return this.x * x + this.y * y + this.z * z;}
/*2022*/public float scalarProduct(Vec3f b) {return dot(b);}
/*2022*/public Vec3f negative() {return new Vec3f(-x, -y, -z);}
/*2022*///binary functions
/*2022*/public Vec3f min(Vec3f b) {return new Vec3f(MyMath.min(x, b.x), MyMath.min(y, b.y), MyMath.min(z, b.z));}
/*2022*/public Vec3f min(float b) {return new Vec3f(MyMath.min(x, b), MyMath.min(y, b), MyMath.min(z, b));}
/*2022*/public Vec3f min(float x, float y, float z) {return new Vec3f(MyMath.min(this.x, x), MyMath.min(this.y, y), MyMath.min(this.z, z));}
/*2022*/public Vec3f max(Vec3f b) {return new Vec3f(MyMath.max(x, b.x), MyMath.max(y, b.y), MyMath.max(z, b.z));}
/*2022*/public Vec3f max(float b) {return new Vec3f(MyMath.max(x, b), MyMath.max(y, b), MyMath.max(z, b));}
/*2022*/public Vec3f max(float x, float y, float z) {return new Vec3f(MyMath.max(this.x, x), MyMath.max(this.y, y), MyMath.max(this.z, z));}
/*2022*/public Vec3f cycle(Vec3f b) {return new Vec3f(MyMath.cycle(x, b.x), MyMath.cycle(y, b.y), MyMath.cycle(z, b.z));}
/*2022*/public Vec3f cycle(float b) {return new Vec3f(MyMath.cycle(x, b), MyMath.cycle(y, b), MyMath.cycle(z, b));}
/*2022*/public Vec3f cycle(float x, float y, float z) {return new Vec3f(MyMath.cycle(this.x, x), MyMath.cycle(this.y, y), MyMath.cycle(this.z, z));}
//2022 auto generated text

//gglsl auto generated text
public Vec3f plus(Vec3f arg1) {return Vec3f.v3(this.x + arg1.x, this.y + arg1.y, this.z + arg1.z);}
public Vec3f plus(float arg1) {return Vec3f.v3(this.x + arg1, this.y + arg1, this.z + arg1);}
public Vec3f plus(Float arg1) {return Vec3f.v3(this.x + arg1, this.y + arg1, this.z + arg1);}
public Vec3f plus(Number arg1) {return Vec3f.v3(this.x +(float)arg1, this.y +(float)arg1, this.z +(float)arg1);}
public Vec3f minus(Vec3f arg1) {return Vec3f.v3(this.x - arg1.x, this.y - arg1.y, this.z - arg1.z);}
public Vec3f minus(float arg1) {return Vec3f.v3(this.x - arg1, this.y - arg1, this.z - arg1);}
public Vec3f minus(Float arg1) {return Vec3f.v3(this.x - arg1, this.y - arg1, this.z - arg1);}
public Vec3f minus(Number arg1) {return Vec3f.v3(this.x -(float)arg1, this.y -(float)arg1, this.z -(float)arg1);}
public Vec3f multiply(Vec3f arg1) {return Vec3f.v3(this.x * arg1.x, this.y * arg1.y, this.z * arg1.z);}
public Vec3f multiply(float arg1) {return Vec3f.v3(this.x * arg1, this.y * arg1, this.z * arg1);}
public Vec3f multiply(Float arg1) {return Vec3f.v3(this.x * arg1, this.y * arg1, this.z * arg1);}
public Vec3f multiply(Number arg1) {return Vec3f.v3(this.x *(float)arg1, this.y *(float)arg1, this.z *(float)arg1);}
public Vec3f div(Float arg1) {return Vec3f.v3(this.x / arg1, this.y / arg1, this.z / arg1);}
public Vec3f div(Number arg1) {return Vec3f.v3(this.x /(float)arg1, this.y /(float)arg1, this.z /(float)arg1);}

public Vec3f radians() {return Vec3f.v3((float)(this.x/180f*Math.PI), (float)(this.y/180f*Math.PI), (float)(this.z/180f*Math.PI));}
public Vec3f degrees() {return Vec3f.v3((float)(this.x/Math.PI*180), (float)(this.y/Math.PI*180), (float)(this.z/Math.PI*180));}
public Vec3f sin() {return Vec3f.v3((float)Math.sin(this.x), (float)Math.sin(this.y), (float)Math.sin(this.z));}
public Vec3f cos() {return Vec3f.v3((float)Math.cos(this.x), (float)Math.cos(this.y), (float)Math.cos(this.z));}
public Vec3f tan() {return Vec3f.v3((float)Math.tan(this.x), (float)Math.tan(this.y), (float)Math.tan(this.z));}
public Vec3f asin() {return Vec3f.v3((float)Math.asin(this.x), (float)Math.asin(this.y), (float)Math.asin(this.z));}
public Vec3f acos() {return Vec3f.v3((float)Math.acos(this.x), (float)Math.acos(this.y), (float)Math.acos(this.z));}
public Vec3f atan() {return Vec3f.v3((float)Math.atan(this.x), (float)Math.atan(this.y), (float)Math.atan(this.z));}
public Vec3f atan(Vec3f x) {return Vec3f.v3((float)Math.atan2(this.x, x.x), (float)Math.atan2(this.y, x.y), (float)Math.atan2(this.z, x.z));}
public Vec3f pow(Vec3f power) {return Vec3f.v3((float)Math.pow(this.x, power.x), (float)Math.pow(this.y, power.y), (float)Math.pow(this.z, power.z));}
public Vec3f exp() {return Vec3f.v3((float)Math.exp(this.x), (float)Math.exp(this.y), (float)Math.exp(this.z));}
public Vec3f log() {return Vec3f.v3((float)Math.log(this.x), (float)Math.log(this.y), (float)Math.log(this.z));}
public Vec3f sqrt() {return Vec3f.v3((float)Math.sqrt(this.x), (float)Math.sqrt(this.y), (float)Math.sqrt(this.z));}
public Vec3f sign() {return Vec3f.v3(Math.signum(this.x), Math.signum(this.y), Math.signum(this.z));}
public Vec3f fract() {return Vec3f.v3(this.x - (float)Math.floor(this.x), this.y - (float)Math.floor(this.y), this.z - (float)Math.floor(this.z));}
public Vec3f mod(Vec3f by) {return Vec3f.v3((float)(this.x-by.x*Math.floor(this.x/by.x)), (float)(this.y-by.y*Math.floor(this.y/by.y)), (float)(this.z-by.z*Math.floor(this.z/by.z)));}
public Vec3f clamp(Vec3f min, Vec3f max) {return Vec3f.v3(Math.max(min.x, Math.min(this.x, max.x)), Math.max(min.y, Math.min(this.y, max.y)), Math.max(min.z, Math.min(this.z, max.z)));}
public Vec3f clamp(float min, float max) {return Vec3f.v3(Math.max(min, Math.min(this.x, max)), Math.max(min, Math.min(this.y, max)), Math.max(min, Math.min(this.z, max)));}
public Vec3f mix(Vec3f to, Vec3f progress) {return Vec3f.v3(this.x * (1 - progress.x) + to.x * progress.x, this.y * (1 - progress.y) + to.y * progress.y, this.z * (1 - progress.z) + to.z * progress.z);}
public Vec3f mix(Vec3f to, float progress) {return Vec3f.v3(this.x * (1 - progress) + to.x * progress, this.y * (1 - progress) + to.y * progress, this.z * (1 - progress) + to.z * progress);}
public Vec3f step(Vec3f value) {return Vec3f.v3(value.x < this.x ? 0 : 1, value.y < this.y ? 0 : 1, value.z < this.z ? 0 : 1);}
public Vec3f smoothstep(Vec3f to, Vec3f progress) {return Vec3f.v3(progress.x < this.x ? 0 : progress.x > to.x ? 1 : progress.x*progress.x*(3 - 2*progress.x), progress.y < this.y ? 0 : progress.y > to.y ? 1 : progress.y*progress.y*(3 - 2*progress.y), progress.z < this.z ? 0 : progress.z > to.z ? 1 : progress.z*progress.z*(3 - 2*progress.z));}
//gglsl auto generated text


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vec3f vec3f = (Vec3f) o;
        return Float.compare(x, vec3f.x) == 0 && Float.compare(y, vec3f.y) == 0 && Float.compare(z, vec3f.z) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    public String toString() {
        return "" + x + " " + y + " " + z;
    }

}