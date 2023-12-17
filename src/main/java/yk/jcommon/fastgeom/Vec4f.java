/**
 * File Vec3.java
 * @author Yuri Kravchik
 * Created 16.10.2008
 */
package yk.jcommon.fastgeom;

import yk.jcommon.utils.MyMath;

import java.io.Serializable;
import java.util.Objects;

/**
 * Vec3
 *
 * @author Yuri Kravchik Created 16.10.2008
 */
@SuppressWarnings("SuspiciousNameCombination")
public final class Vec4f implements Serializable {
    public float x, y, z, w;

    public static final Vec4f ZERO = new Vec4f(0, 0, 0, 0);
    public static final Vec4f AXIS_X = new Vec4f(1, 0, 0, 0);
    public static final Vec4f AXIS_Y = new Vec4f(0, 1, 0, 0);
    public static final Vec4f AXIS_Z = new Vec4f(0, 0, 1, 0);
    public static final Vec4f AXIS_W = new Vec4f(0, 0, 0, 1);


    public Vec4f() {}
    public static Vec4f v4(Vec3f v3, final float w) {return new Vec4f(v3, w);}
    public Vec4f(Vec3f v, float w) {this(v.x, v.y, v.z, w);}
    public Vec4f withX(float x) {return new Vec4f(x, y, z, w);}
    public Vec4f withY(float y) {return new Vec4f(x, y, z, w);}
    public Vec4f withZ(float z) {return new Vec4f(x, y, z, w);}
    public Vec4f withW(float w) {return new Vec4f(x, y, z, w);}
    public Vec2f getXy() {return new Vec2f(x, y);}
    public Vec2f getYz() {return new Vec2f(y, z);}
    public Vec2f getXz() {return new Vec2f(x, z);}
    public Vec3f getXyz() {return new Vec3f(x, y, z);}
    public void setXyz(Vec3f v) {x = v.x;y = v.y;z = v.z;}

    /**
     * this 0 -> 1 to
     */
    public Vec4f lerp(Vec4f to, float blend) {
        return mix(this, to, blend);
    }

    //0 - a, 1 - b
    public static Vec4f mix(Vec4f a, Vec4f b, float ab) {
        return b.sub(a).mul(ab).add(a);
    }

//2022 auto generated text
/*2022*///constructors
/*2022*/public Vec4f(float x, float y, float z, float w) {this.x = x;this.y = y;this.z = z;this.w = w;}
/*2022*/public Vec4f(Vec4f other) {x = other.x;y = other.y;z = other.z;w = other.w;}
/*2022*/public Vec4f(float b) {x = b;y = b;z = b;w = b;}
/*2022*/public static Vec4f v4(float x, float y, float z, float w) {return new Vec4f(x, y, z, w);}
/*2022*/public static Vec4f v4(float b) {return new Vec4f(b, b, b, b);}
/*2022*/public void fillFrom(Vec4f other) {x = other.x;y = other.y;z = other.z;w = other.w;}
/*2022*///operators
/*2022*/public Vec4f add(Vec4f b) {return new Vec4f(x + b.x, y + b.y, z + b.z, w + b.w);}
/*2022*/public Vec4f add(float b) {return new Vec4f(x + b, y + b, z + b, w + b);}
/*2022*/public Vec4f add(float x, float y, float z, float w) {return new Vec4f(this.x + x, this.y + y, this.z + z, this.w + w);}
/*2022*/public Vec4f sub(Vec4f b) {return new Vec4f(x - b.x, y - b.y, z - b.z, w - b.w);}
/*2022*/public Vec4f sub(float b) {return new Vec4f(x - b, y - b, z - b, w - b);}
/*2022*/public Vec4f sub(float x, float y, float z, float w) {return new Vec4f(this.x - x, this.y - y, this.z - z, this.w - w);}
/*2022*/public Vec4f mul(Vec4f b) {return new Vec4f(x * b.x, y * b.y, z * b.z, w * b.w);}
/*2022*/public Vec4f mul(float b) {return new Vec4f(x * b, y * b, z * b, w * b);}
/*2022*/public Vec4f mul(float x, float y, float z, float w) {return new Vec4f(this.x * x, this.y * y, this.z * z, this.w * w);}
/*2022*/public Vec4f div(Vec4f b) {return new Vec4f(x / b.x, y / b.y, z / b.z, w / b.w);}
/*2022*/public Vec4f div(float b) {return new Vec4f(x / b, y / b, z / b, w / b);}
/*2022*/public Vec4f div(float x, float y, float z, float w) {return new Vec4f(this.x / x, this.y / y, this.z / z, this.w / w);}
/*2022*///0 args functions
/*2022*/public Vec4f round() {return new Vec4f(Math.round(x), Math.round(y), Math.round(z), Math.round(w));}
/*2022*/public Vec4f floor() {return new Vec4f(MyMath.floorFast(x), MyMath.floorFast(y), MyMath.floorFast(z), MyMath.floorFast(w));}
/*2022*/public Vec4f ceil() {return new Vec4f(MyMath.ceil(x), MyMath.ceil(y), MyMath.ceil(z), MyMath.ceil(w));}
/*2022*/public Vec4f abs() {return new Vec4f(MyMath.abs(x), MyMath.abs(y), MyMath.abs(z), MyMath.abs(w));}
/*2022*///reducers
/*2022*/public float sum() {return x + y + z + w;}
/*2022*/public float product() {return x * y * z * w;}
/*2022*/public float min() {return MyMath.min(MyMath.min(MyMath.min(x, y), z), w);}
/*2022*/public float max() {return MyMath.max(MyMath.max(MyMath.max(x, y), z), w);}
/*2022*///distance
/*2022*/public float lengthSquared() {return x * x + y * y + z * z + w * w;}
/*2022*/public float distanceSquared(Vec4f b) {return MyMath.sqr(x - b.x) + MyMath.sqr(y - b.y) + MyMath.sqr(z - b.z) + MyMath.sqr(w - b.w);}
/*2022*/public float distanceSquared(float x, float y, float z, float w) {return MyMath.sqr(this.x - x) + MyMath.sqr(this.y - y) + MyMath.sqr(this.z - z) + MyMath.sqr(this.w - w);}
/*2022*/public float manhattanLength() {return Math.abs(x) + Math.abs(y) + Math.abs(z) + Math.abs(w);}
/*2022*/public float manhattanDistance(Vec4f b) {return MyMath.abs(x - b.x) + MyMath.abs(y - b.y) + MyMath.abs(z - b.z) + MyMath.abs(w - b.w);}
/*2022*/public float manhattanDistance(float x, float y, float z, float w) {return MyMath.abs(this.x - x) + MyMath.abs(this.y - y) + MyMath.abs(this.z - z) + MyMath.abs(this.w - w);}
/*2022*/public float length() {return MyMath.sqrt(x * x + y * y + z * z + w * w);}
/*2022*/public Vec4f normalized() {
/*2022*/    float m = 1f / MyMath.sqrt(x * x + y * y + z * z + w * w);
/*2022*/    return new Vec4f(x * m, y * m, z * m, w * m);
/*2022*/}
/*2022*/public Vec4f normalized(float len) {
/*2022*/    float m = len / (float)Math.sqrt(x * x + y * y + z * z + w * w);
/*2022*/    return new Vec4f(x * m, y * m, z * m, w * m);
/*2022*/}
/*2022*/public float distance(Vec4f b) {return MyMath.sqrt(MyMath.sqr(x - b.x) + MyMath.sqr(y - b.y) + MyMath.sqr(z - b.z) + MyMath.sqr(w - b.w));}
/*2022*/public float distance(float x, float y, float z, float w) {return MyMath.sqrt(MyMath.sqr(this.x - x) + MyMath.sqr(this.y - y) + MyMath.sqr(this.z - z) + MyMath.sqr(this.w - w));}
/*2022*///math
/*2022*/public float dot(Vec4f b) {return x * b.x + y * b.y + z * b.z + w * b.w;}
/*2022*/public float dot(float x, float y, float z, float w) {return this.x * x + this.y * y + this.z * z + this.w * w;}
/*2022*/public float scalarProduct(Vec4f b) {return dot(b);}
/*2022*/public Vec4f negative() {return new Vec4f(-x, -y, -z, -w);}
/*2022*///binary functions
/*2022*/public Vec4f min(Vec4f b) {return new Vec4f(MyMath.min(x, b.x), MyMath.min(y, b.y), MyMath.min(z, b.z), MyMath.min(w, b.w));}
/*2022*/public Vec4f min(float b) {return new Vec4f(MyMath.min(x, b), MyMath.min(y, b), MyMath.min(z, b), MyMath.min(w, b));}
/*2022*/public Vec4f min(float x, float y, float z, float w) {return new Vec4f(MyMath.min(this.x, x), MyMath.min(this.y, y), MyMath.min(this.z, z), MyMath.min(this.w, w));}
/*2022*/public Vec4f max(Vec4f b) {return new Vec4f(MyMath.max(x, b.x), MyMath.max(y, b.y), MyMath.max(z, b.z), MyMath.max(w, b.w));}
/*2022*/public Vec4f max(float b) {return new Vec4f(MyMath.max(x, b), MyMath.max(y, b), MyMath.max(z, b), MyMath.max(w, b));}
/*2022*/public Vec4f max(float x, float y, float z, float w) {return new Vec4f(MyMath.max(this.x, x), MyMath.max(this.y, y), MyMath.max(this.z, z), MyMath.max(this.w, w));}
/*2022*/public Vec4f cycle(Vec4f b) {return new Vec4f(MyMath.cycle(x, b.x), MyMath.cycle(y, b.y), MyMath.cycle(z, b.z), MyMath.cycle(w, b.w));}
/*2022*/public Vec4f cycle(float b) {return new Vec4f(MyMath.cycle(x, b), MyMath.cycle(y, b), MyMath.cycle(z, b), MyMath.cycle(w, b));}
/*2022*/public Vec4f cycle(float x, float y, float z, float w) {return new Vec4f(MyMath.cycle(this.x, x), MyMath.cycle(this.y, y), MyMath.cycle(this.z, z), MyMath.cycle(this.w, w));}
//2022 auto generated text

//gglsl auto generated text
public Vec4f plus(Vec4f arg1) {return Vec4f.v4(this.x + arg1.x, this.y + arg1.y, this.z + arg1.z, this.w + arg1.w);}
public Vec4f plus(float arg1) {return Vec4f.v4(this.x + arg1, this.y + arg1, this.z + arg1, this.w + arg1);}
public Vec4f plus(Float arg1) {return Vec4f.v4(this.x + arg1, this.y + arg1, this.z + arg1, this.w + arg1);}
public Vec4f plus(Number arg1) {return Vec4f.v4(this.x +(float)arg1, this.y +(float)arg1, this.z +(float)arg1, this.w +(float)arg1);}
public Vec4f minus(Vec4f arg1) {return Vec4f.v4(this.x - arg1.x, this.y - arg1.y, this.z - arg1.z, this.w - arg1.w);}
public Vec4f minus(float arg1) {return Vec4f.v4(this.x - arg1, this.y - arg1, this.z - arg1, this.w - arg1);}
public Vec4f minus(Float arg1) {return Vec4f.v4(this.x - arg1, this.y - arg1, this.z - arg1, this.w - arg1);}
public Vec4f minus(Number arg1) {return Vec4f.v4(this.x -(float)arg1, this.y -(float)arg1, this.z -(float)arg1, this.w -(float)arg1);}
public Vec4f multiply(Vec4f arg1) {return Vec4f.v4(this.x * arg1.x, this.y * arg1.y, this.z * arg1.z, this.w * arg1.w);}
public Vec4f multiply(float arg1) {return Vec4f.v4(this.x * arg1, this.y * arg1, this.z * arg1, this.w * arg1);}
public Vec4f multiply(Float arg1) {return Vec4f.v4(this.x * arg1, this.y * arg1, this.z * arg1, this.w * arg1);}
public Vec4f multiply(Number arg1) {return Vec4f.v4(this.x *(float)arg1, this.y *(float)arg1, this.z *(float)arg1, this.w *(float)arg1);}
public Vec4f div(Float arg1) {return Vec4f.v4(this.x / arg1, this.y / arg1, this.z / arg1, this.w / arg1);}
public Vec4f div(Number arg1) {return Vec4f.v4(this.x /(float)arg1, this.y /(float)arg1, this.z /(float)arg1, this.w /(float)arg1);}
public Vec4f radians() {return Vec4f.v4((float)(this.x/180f*Math.PI), (float)(this.y/180f*Math.PI), (float)(this.z/180f*Math.PI), (float)(this.w/180f*Math.PI));}
public Vec4f degrees() {return Vec4f.v4((float)(this.x/Math.PI*180), (float)(this.y/Math.PI*180), (float)(this.z/Math.PI*180), (float)(this.w/Math.PI*180));}
public Vec4f sin() {return Vec4f.v4((float)Math.sin(this.x), (float)Math.sin(this.y), (float)Math.sin(this.z), (float)Math.sin(this.w));}
public Vec4f cos() {return Vec4f.v4((float)Math.cos(this.x), (float)Math.cos(this.y), (float)Math.cos(this.z), (float)Math.cos(this.w));}
public Vec4f tan() {return Vec4f.v4((float)Math.tan(this.x), (float)Math.tan(this.y), (float)Math.tan(this.z), (float)Math.tan(this.w));}
public Vec4f asin() {return Vec4f.v4((float)Math.asin(this.x), (float)Math.asin(this.y), (float)Math.asin(this.z), (float)Math.asin(this.w));}
public Vec4f acos() {return Vec4f.v4((float)Math.acos(this.x), (float)Math.acos(this.y), (float)Math.acos(this.z), (float)Math.acos(this.w));}
public Vec4f atan() {return Vec4f.v4((float)Math.atan(this.x), (float)Math.atan(this.y), (float)Math.atan(this.z), (float)Math.atan(this.w));}
public Vec4f atan(Vec4f x) {return Vec4f.v4((float)Math.atan2(this.x, x.x), (float)Math.atan2(this.y, x.y), (float)Math.atan2(this.z, x.z), (float)Math.atan2(this.w, x.w));}
public Vec4f pow(Vec4f power) {return Vec4f.v4((float)Math.pow(this.x, power.x), (float)Math.pow(this.y, power.y), (float)Math.pow(this.z, power.z), (float)Math.pow(this.w, power.w));}
public Vec4f exp() {return Vec4f.v4((float)Math.exp(this.x), (float)Math.exp(this.y), (float)Math.exp(this.z), (float)Math.exp(this.w));}
public Vec4f log() {return Vec4f.v4((float)Math.log(this.x), (float)Math.log(this.y), (float)Math.log(this.z), (float)Math.log(this.w));}
public Vec4f sqrt() {return Vec4f.v4((float)Math.sqrt(this.x), (float)Math.sqrt(this.y), (float)Math.sqrt(this.z), (float)Math.sqrt(this.w));}
public Vec4f sign() {return Vec4f.v4(Math.signum(this.x), Math.signum(this.y), Math.signum(this.z), Math.signum(this.w));}
public Vec4f fract() {return Vec4f.v4(this.x - (float)Math.floor(this.x), this.y - (float)Math.floor(this.y), this.z - (float)Math.floor(this.z), this.w - (float)Math.floor(this.w));}
public Vec4f mod(Vec4f by) {return Vec4f.v4((float)(this.x-by.x*Math.floor(this.x/by.x)), (float)(this.y-by.y*Math.floor(this.y/by.y)), (float)(this.z-by.z*Math.floor(this.z/by.z)), (float)(this.w-by.w*Math.floor(this.w/by.w)));}
public Vec4f clamp(Vec4f min, Vec4f max) {return Vec4f.v4(Math.max(min.x, Math.min(this.x, max.x)), Math.max(min.y, Math.min(this.y, max.y)), Math.max(min.z, Math.min(this.z, max.z)), Math.max(min.w, Math.min(this.w, max.w)));}
public Vec4f clamp(float min, float max) {return Vec4f.v4(Math.max(min, Math.min(this.x, max)), Math.max(min, Math.min(this.y, max)), Math.max(min, Math.min(this.z, max)), Math.max(min, Math.min(this.w, max)));}
public Vec4f mix(Vec4f to, Vec4f progress) {return Vec4f.v4(this.x * (1 - progress.x) + to.x * progress.x, this.y * (1 - progress.y) + to.y * progress.y, this.z * (1 - progress.z) + to.z * progress.z, this.w * (1 - progress.w) + to.w * progress.w);}
public Vec4f mix(Vec4f to, float progress) {return Vec4f.v4(this.x * (1 - progress) + to.x * progress, this.y * (1 - progress) + to.y * progress, this.z * (1 - progress) + to.z * progress, this.w * (1 - progress) + to.w * progress);}
public Vec4f step(Vec4f value) {return Vec4f.v4(value.x < this.x ? 0 : 1, value.y < this.y ? 0 : 1, value.z < this.z ? 0 : 1, value.w < this.w ? 0 : 1);}
public Vec4f smoothstep(Vec4f to, Vec4f progress) {return Vec4f.v4(progress.x < this.x ? 0 : progress.x > to.x ? 1 : progress.x*progress.x*(3 - 2*progress.x), progress.y < this.y ? 0 : progress.y > to.y ? 1 : progress.y*progress.y*(3 - 2*progress.y), progress.z < this.z ? 0 : progress.z > to.z ? 1 : progress.z*progress.z*(3 - 2*progress.z), progress.w < this.w ? 0 : progress.w > to.w ? 1 : progress.w*progress.w*(3 - 2*progress.w));}
//gglsl auto generated text


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vec4f vec4f = (Vec4f) o;
        return Float.compare(x, vec4f.x) == 0 && Float.compare(y, vec4f.y) == 0 && Float.compare(z, vec4f.z) == 0 && Float.compare(w, vec4f.w) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z, w);
    }

    @Override
    public String toString() {
        return "w: " + w + " x: " + x + " y: " + y + " z: " + z;
    }

}