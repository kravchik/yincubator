package yk.jcommon.fastgeom;

import yk.jcommon.utils.MyMath;

public class VectorOperationsNoMalloc {

    public static void nmCrossProduct(Vec3f a, Vec3f b, Vec3f res) {
        float x = a.y * b.z - a.z * b.y;
        float y = a.z * b.x - a.x * b.z;
        float z = a.x * b.y - a.y * b.x;
        res.x = x;
        res.y = y;
        res.z = z;
    }

    public static void nmCrossProduct(Vec3f a, Vec3f b) {
        nmCrossProduct(a, b, a);
    }

    public static void nmNormalize(Vec3f a, float len, Vec3f res) {
        float m = len / (float)Math.sqrt(a.x * a.x + a.y * a.y + a.z * a.z);
        res.x = a.x * m;
        res.y = a.y * m;
        res.z = a.z * m;
    }

    public static void nmNormalize(Vec3f a, float len) {
        nmNormalize(a, len, a);
    }

    public static void nmNormalize(Vec3f a) {
        nmNormalize(a, 1, a);
    }

    public static void nmNormalize(Vec3f a, Vec3f res) {
        nmNormalize(a, 1, res);
    }

//2022 auto generated text
/*2022*/public static void nmAdd(Vec2i res, Vec2i a, Vec2i b) {
/*2022*/    res.x = a.x + b.x;
/*2022*/    res.y = a.y + b.y;
/*2022*/}
/*2022*/public static void nmAdd(Vec2i a_res, Vec2i b) {
/*2022*/    a_res.x = a_res.x + b.x;
/*2022*/    a_res.y = a_res.y + b.y;
/*2022*/}
/*2022*/public static void nmAdd(Vec2i res, Vec2i a, int b) {
/*2022*/    res.x = a.x + b;
/*2022*/    res.y = a.y + b;
/*2022*/}
/*2022*/public static void nmAdd(Vec2i a_res, int b) {
/*2022*/    a_res.x = a_res.x + b;
/*2022*/    a_res.y = a_res.y + b;
/*2022*/}
/*2022*/public static void nmSub(Vec2i res, Vec2i a, Vec2i b) {
/*2022*/    res.x = a.x - b.x;
/*2022*/    res.y = a.y - b.y;
/*2022*/}
/*2022*/public static void nmSub(Vec2i a_res, Vec2i b) {
/*2022*/    a_res.x = a_res.x - b.x;
/*2022*/    a_res.y = a_res.y - b.y;
/*2022*/}
/*2022*/public static void nmSub(Vec2i res, Vec2i a, int b) {
/*2022*/    res.x = a.x - b;
/*2022*/    res.y = a.y - b;
/*2022*/}
/*2022*/public static void nmSub(Vec2i a_res, int b) {
/*2022*/    a_res.x = a_res.x - b;
/*2022*/    a_res.y = a_res.y - b;
/*2022*/}
/*2022*/public static void nmMul(Vec2i res, Vec2i a, Vec2i b) {
/*2022*/    res.x = a.x * b.x;
/*2022*/    res.y = a.y * b.y;
/*2022*/}
/*2022*/public static void nmMul(Vec2i a_res, Vec2i b) {
/*2022*/    a_res.x = a_res.x * b.x;
/*2022*/    a_res.y = a_res.y * b.y;
/*2022*/}
/*2022*/public static void nmMul(Vec2i res, Vec2i a, int b) {
/*2022*/    res.x = a.x * b;
/*2022*/    res.y = a.y * b;
/*2022*/}
/*2022*/public static void nmMul(Vec2i a_res, int b) {
/*2022*/    a_res.x = a_res.x * b;
/*2022*/    a_res.y = a_res.y * b;
/*2022*/}
/*2022*/public static void nmDiv(Vec2i res, Vec2i a, Vec2i b) {
/*2022*/    res.x = a.x / b.x;
/*2022*/    res.y = a.y / b.y;
/*2022*/}
/*2022*/public static void nmDiv(Vec2i a_res, Vec2i b) {
/*2022*/    a_res.x = a_res.x / b.x;
/*2022*/    a_res.y = a_res.y / b.y;
/*2022*/}
/*2022*/public static void nmDiv(Vec2i res, Vec2i a, int b) {
/*2022*/    res.x = a.x / b;
/*2022*/    res.y = a.y / b;
/*2022*/}
/*2022*/public static void nmDiv(Vec2i a_res, int b) {
/*2022*/    a_res.x = a_res.x / b;
/*2022*/    a_res.y = a_res.y / b;
/*2022*/}
/*2022*/public static void nmAbs(Vec2i res, Vec2i a) {
/*2022*/    res.x = MyMath.abs(a.x);
/*2022*/    res.y = MyMath.abs(a.y);
/*2022*/}
/*2022*/public static void nmMin(Vec2i res, Vec2i a, Vec2i b) {
/*2022*/    res.x = MyMath.min(a.x, b.x);
/*2022*/    res.y = MyMath.min(a.y, b.y);
/*2022*/}
/*2022*/public static void nmMin(Vec2i a_res, Vec2i b) {
/*2022*/    a_res.x = MyMath.min(a_res.x, b.x);
/*2022*/    a_res.y = MyMath.min(a_res.y, b.y);
/*2022*/}
/*2022*/public static void nmMin(Vec2i res, Vec2i a, int b) {
/*2022*/    res.x = MyMath.min(a.x, b);
/*2022*/    res.y = MyMath.min(a.y, b);
/*2022*/}
/*2022*/public static void nmMin(Vec2i a_res, int b) {
/*2022*/    a_res.x = MyMath.min(a_res.x, b);
/*2022*/    a_res.y = MyMath.min(a_res.y, b);
/*2022*/}
/*2022*/public static void nmMax(Vec2i res, Vec2i a, Vec2i b) {
/*2022*/    res.x = MyMath.max(a.x, b.x);
/*2022*/    res.y = MyMath.max(a.y, b.y);
/*2022*/}
/*2022*/public static void nmMax(Vec2i a_res, Vec2i b) {
/*2022*/    a_res.x = MyMath.max(a_res.x, b.x);
/*2022*/    a_res.y = MyMath.max(a_res.y, b.y);
/*2022*/}
/*2022*/public static void nmMax(Vec2i res, Vec2i a, int b) {
/*2022*/    res.x = MyMath.max(a.x, b);
/*2022*/    res.y = MyMath.max(a.y, b);
/*2022*/}
/*2022*/public static void nmMax(Vec2i a_res, int b) {
/*2022*/    a_res.x = MyMath.max(a_res.x, b);
/*2022*/    a_res.y = MyMath.max(a_res.y, b);
/*2022*/}
/*2022*/public static void nmCycle(Vec2i res, Vec2i a, Vec2i b) {
/*2022*/    res.x = MyMath.cycle(a.x, b.x);
/*2022*/    res.y = MyMath.cycle(a.y, b.y);
/*2022*/}
/*2022*/public static void nmCycle(Vec2i a_res, Vec2i b) {
/*2022*/    a_res.x = MyMath.cycle(a_res.x, b.x);
/*2022*/    a_res.y = MyMath.cycle(a_res.y, b.y);
/*2022*/}
/*2022*/public static void nmCycle(Vec2i res, Vec2i a, int b) {
/*2022*/    res.x = MyMath.cycle(a.x, b);
/*2022*/    res.y = MyMath.cycle(a.y, b);
/*2022*/}
/*2022*/public static void nmCycle(Vec2i a_res, int b) {
/*2022*/    a_res.x = MyMath.cycle(a_res.x, b);
/*2022*/    a_res.y = MyMath.cycle(a_res.y, b);
/*2022*/}
/*2022*/public static void nmAdd(Vec3i res, Vec3i a, Vec3i b) {
/*2022*/    res.x = a.x + b.x;
/*2022*/    res.y = a.y + b.y;
/*2022*/    res.z = a.z + b.z;
/*2022*/}
/*2022*/public static void nmAdd(Vec3i a_res, Vec3i b) {
/*2022*/    a_res.x = a_res.x + b.x;
/*2022*/    a_res.y = a_res.y + b.y;
/*2022*/    a_res.z = a_res.z + b.z;
/*2022*/}
/*2022*/public static void nmAdd(Vec3i res, Vec3i a, int b) {
/*2022*/    res.x = a.x + b;
/*2022*/    res.y = a.y + b;
/*2022*/    res.z = a.z + b;
/*2022*/}
/*2022*/public static void nmAdd(Vec3i a_res, int b) {
/*2022*/    a_res.x = a_res.x + b;
/*2022*/    a_res.y = a_res.y + b;
/*2022*/    a_res.z = a_res.z + b;
/*2022*/}
/*2022*/public static void nmSub(Vec3i res, Vec3i a, Vec3i b) {
/*2022*/    res.x = a.x - b.x;
/*2022*/    res.y = a.y - b.y;
/*2022*/    res.z = a.z - b.z;
/*2022*/}
/*2022*/public static void nmSub(Vec3i a_res, Vec3i b) {
/*2022*/    a_res.x = a_res.x - b.x;
/*2022*/    a_res.y = a_res.y - b.y;
/*2022*/    a_res.z = a_res.z - b.z;
/*2022*/}
/*2022*/public static void nmSub(Vec3i res, Vec3i a, int b) {
/*2022*/    res.x = a.x - b;
/*2022*/    res.y = a.y - b;
/*2022*/    res.z = a.z - b;
/*2022*/}
/*2022*/public static void nmSub(Vec3i a_res, int b) {
/*2022*/    a_res.x = a_res.x - b;
/*2022*/    a_res.y = a_res.y - b;
/*2022*/    a_res.z = a_res.z - b;
/*2022*/}
/*2022*/public static void nmMul(Vec3i res, Vec3i a, Vec3i b) {
/*2022*/    res.x = a.x * b.x;
/*2022*/    res.y = a.y * b.y;
/*2022*/    res.z = a.z * b.z;
/*2022*/}
/*2022*/public static void nmMul(Vec3i a_res, Vec3i b) {
/*2022*/    a_res.x = a_res.x * b.x;
/*2022*/    a_res.y = a_res.y * b.y;
/*2022*/    a_res.z = a_res.z * b.z;
/*2022*/}
/*2022*/public static void nmMul(Vec3i res, Vec3i a, int b) {
/*2022*/    res.x = a.x * b;
/*2022*/    res.y = a.y * b;
/*2022*/    res.z = a.z * b;
/*2022*/}
/*2022*/public static void nmMul(Vec3i a_res, int b) {
/*2022*/    a_res.x = a_res.x * b;
/*2022*/    a_res.y = a_res.y * b;
/*2022*/    a_res.z = a_res.z * b;
/*2022*/}
/*2022*/public static void nmDiv(Vec3i res, Vec3i a, Vec3i b) {
/*2022*/    res.x = a.x / b.x;
/*2022*/    res.y = a.y / b.y;
/*2022*/    res.z = a.z / b.z;
/*2022*/}
/*2022*/public static void nmDiv(Vec3i a_res, Vec3i b) {
/*2022*/    a_res.x = a_res.x / b.x;
/*2022*/    a_res.y = a_res.y / b.y;
/*2022*/    a_res.z = a_res.z / b.z;
/*2022*/}
/*2022*/public static void nmDiv(Vec3i res, Vec3i a, int b) {
/*2022*/    res.x = a.x / b;
/*2022*/    res.y = a.y / b;
/*2022*/    res.z = a.z / b;
/*2022*/}
/*2022*/public static void nmDiv(Vec3i a_res, int b) {
/*2022*/    a_res.x = a_res.x / b;
/*2022*/    a_res.y = a_res.y / b;
/*2022*/    a_res.z = a_res.z / b;
/*2022*/}
/*2022*/public static void nmAbs(Vec3i res, Vec3i a) {
/*2022*/    res.x = MyMath.abs(a.x);
/*2022*/    res.y = MyMath.abs(a.y);
/*2022*/    res.z = MyMath.abs(a.z);
/*2022*/}
/*2022*/public static void nmMin(Vec3i res, Vec3i a, Vec3i b) {
/*2022*/    res.x = MyMath.min(a.x, b.x);
/*2022*/    res.y = MyMath.min(a.y, b.y);
/*2022*/    res.z = MyMath.min(a.z, b.z);
/*2022*/}
/*2022*/public static void nmMin(Vec3i a_res, Vec3i b) {
/*2022*/    a_res.x = MyMath.min(a_res.x, b.x);
/*2022*/    a_res.y = MyMath.min(a_res.y, b.y);
/*2022*/    a_res.z = MyMath.min(a_res.z, b.z);
/*2022*/}
/*2022*/public static void nmMin(Vec3i res, Vec3i a, int b) {
/*2022*/    res.x = MyMath.min(a.x, b);
/*2022*/    res.y = MyMath.min(a.y, b);
/*2022*/    res.z = MyMath.min(a.z, b);
/*2022*/}
/*2022*/public static void nmMin(Vec3i a_res, int b) {
/*2022*/    a_res.x = MyMath.min(a_res.x, b);
/*2022*/    a_res.y = MyMath.min(a_res.y, b);
/*2022*/    a_res.z = MyMath.min(a_res.z, b);
/*2022*/}
/*2022*/public static void nmMax(Vec3i res, Vec3i a, Vec3i b) {
/*2022*/    res.x = MyMath.max(a.x, b.x);
/*2022*/    res.y = MyMath.max(a.y, b.y);
/*2022*/    res.z = MyMath.max(a.z, b.z);
/*2022*/}
/*2022*/public static void nmMax(Vec3i a_res, Vec3i b) {
/*2022*/    a_res.x = MyMath.max(a_res.x, b.x);
/*2022*/    a_res.y = MyMath.max(a_res.y, b.y);
/*2022*/    a_res.z = MyMath.max(a_res.z, b.z);
/*2022*/}
/*2022*/public static void nmMax(Vec3i res, Vec3i a, int b) {
/*2022*/    res.x = MyMath.max(a.x, b);
/*2022*/    res.y = MyMath.max(a.y, b);
/*2022*/    res.z = MyMath.max(a.z, b);
/*2022*/}
/*2022*/public static void nmMax(Vec3i a_res, int b) {
/*2022*/    a_res.x = MyMath.max(a_res.x, b);
/*2022*/    a_res.y = MyMath.max(a_res.y, b);
/*2022*/    a_res.z = MyMath.max(a_res.z, b);
/*2022*/}
/*2022*/public static void nmCycle(Vec3i res, Vec3i a, Vec3i b) {
/*2022*/    res.x = MyMath.cycle(a.x, b.x);
/*2022*/    res.y = MyMath.cycle(a.y, b.y);
/*2022*/    res.z = MyMath.cycle(a.z, b.z);
/*2022*/}
/*2022*/public static void nmCycle(Vec3i a_res, Vec3i b) {
/*2022*/    a_res.x = MyMath.cycle(a_res.x, b.x);
/*2022*/    a_res.y = MyMath.cycle(a_res.y, b.y);
/*2022*/    a_res.z = MyMath.cycle(a_res.z, b.z);
/*2022*/}
/*2022*/public static void nmCycle(Vec3i res, Vec3i a, int b) {
/*2022*/    res.x = MyMath.cycle(a.x, b);
/*2022*/    res.y = MyMath.cycle(a.y, b);
/*2022*/    res.z = MyMath.cycle(a.z, b);
/*2022*/}
/*2022*/public static void nmCycle(Vec3i a_res, int b) {
/*2022*/    a_res.x = MyMath.cycle(a_res.x, b);
/*2022*/    a_res.y = MyMath.cycle(a_res.y, b);
/*2022*/    a_res.z = MyMath.cycle(a_res.z, b);
/*2022*/}
/*2022*/public static void nmAdd(Vec4i res, Vec4i a, Vec4i b) {
/*2022*/    res.x = a.x + b.x;
/*2022*/    res.y = a.y + b.y;
/*2022*/    res.z = a.z + b.z;
/*2022*/    res.w = a.w + b.w;
/*2022*/}
/*2022*/public static void nmAdd(Vec4i a_res, Vec4i b) {
/*2022*/    a_res.x = a_res.x + b.x;
/*2022*/    a_res.y = a_res.y + b.y;
/*2022*/    a_res.z = a_res.z + b.z;
/*2022*/    a_res.w = a_res.w + b.w;
/*2022*/}
/*2022*/public static void nmAdd(Vec4i res, Vec4i a, int b) {
/*2022*/    res.x = a.x + b;
/*2022*/    res.y = a.y + b;
/*2022*/    res.z = a.z + b;
/*2022*/    res.w = a.w + b;
/*2022*/}
/*2022*/public static void nmAdd(Vec4i a_res, int b) {
/*2022*/    a_res.x = a_res.x + b;
/*2022*/    a_res.y = a_res.y + b;
/*2022*/    a_res.z = a_res.z + b;
/*2022*/    a_res.w = a_res.w + b;
/*2022*/}
/*2022*/public static void nmSub(Vec4i res, Vec4i a, Vec4i b) {
/*2022*/    res.x = a.x - b.x;
/*2022*/    res.y = a.y - b.y;
/*2022*/    res.z = a.z - b.z;
/*2022*/    res.w = a.w - b.w;
/*2022*/}
/*2022*/public static void nmSub(Vec4i a_res, Vec4i b) {
/*2022*/    a_res.x = a_res.x - b.x;
/*2022*/    a_res.y = a_res.y - b.y;
/*2022*/    a_res.z = a_res.z - b.z;
/*2022*/    a_res.w = a_res.w - b.w;
/*2022*/}
/*2022*/public static void nmSub(Vec4i res, Vec4i a, int b) {
/*2022*/    res.x = a.x - b;
/*2022*/    res.y = a.y - b;
/*2022*/    res.z = a.z - b;
/*2022*/    res.w = a.w - b;
/*2022*/}
/*2022*/public static void nmSub(Vec4i a_res, int b) {
/*2022*/    a_res.x = a_res.x - b;
/*2022*/    a_res.y = a_res.y - b;
/*2022*/    a_res.z = a_res.z - b;
/*2022*/    a_res.w = a_res.w - b;
/*2022*/}
/*2022*/public static void nmMul(Vec4i res, Vec4i a, Vec4i b) {
/*2022*/    res.x = a.x * b.x;
/*2022*/    res.y = a.y * b.y;
/*2022*/    res.z = a.z * b.z;
/*2022*/    res.w = a.w * b.w;
/*2022*/}
/*2022*/public static void nmMul(Vec4i a_res, Vec4i b) {
/*2022*/    a_res.x = a_res.x * b.x;
/*2022*/    a_res.y = a_res.y * b.y;
/*2022*/    a_res.z = a_res.z * b.z;
/*2022*/    a_res.w = a_res.w * b.w;
/*2022*/}
/*2022*/public static void nmMul(Vec4i res, Vec4i a, int b) {
/*2022*/    res.x = a.x * b;
/*2022*/    res.y = a.y * b;
/*2022*/    res.z = a.z * b;
/*2022*/    res.w = a.w * b;
/*2022*/}
/*2022*/public static void nmMul(Vec4i a_res, int b) {
/*2022*/    a_res.x = a_res.x * b;
/*2022*/    a_res.y = a_res.y * b;
/*2022*/    a_res.z = a_res.z * b;
/*2022*/    a_res.w = a_res.w * b;
/*2022*/}
/*2022*/public static void nmDiv(Vec4i res, Vec4i a, Vec4i b) {
/*2022*/    res.x = a.x / b.x;
/*2022*/    res.y = a.y / b.y;
/*2022*/    res.z = a.z / b.z;
/*2022*/    res.w = a.w / b.w;
/*2022*/}
/*2022*/public static void nmDiv(Vec4i a_res, Vec4i b) {
/*2022*/    a_res.x = a_res.x / b.x;
/*2022*/    a_res.y = a_res.y / b.y;
/*2022*/    a_res.z = a_res.z / b.z;
/*2022*/    a_res.w = a_res.w / b.w;
/*2022*/}
/*2022*/public static void nmDiv(Vec4i res, Vec4i a, int b) {
/*2022*/    res.x = a.x / b;
/*2022*/    res.y = a.y / b;
/*2022*/    res.z = a.z / b;
/*2022*/    res.w = a.w / b;
/*2022*/}
/*2022*/public static void nmDiv(Vec4i a_res, int b) {
/*2022*/    a_res.x = a_res.x / b;
/*2022*/    a_res.y = a_res.y / b;
/*2022*/    a_res.z = a_res.z / b;
/*2022*/    a_res.w = a_res.w / b;
/*2022*/}
/*2022*/public static void nmAbs(Vec4i res, Vec4i a) {
/*2022*/    res.x = MyMath.abs(a.x);
/*2022*/    res.y = MyMath.abs(a.y);
/*2022*/    res.z = MyMath.abs(a.z);
/*2022*/    res.w = MyMath.abs(a.w);
/*2022*/}
/*2022*/public static void nmMin(Vec4i res, Vec4i a, Vec4i b) {
/*2022*/    res.x = MyMath.min(a.x, b.x);
/*2022*/    res.y = MyMath.min(a.y, b.y);
/*2022*/    res.z = MyMath.min(a.z, b.z);
/*2022*/    res.w = MyMath.min(a.w, b.w);
/*2022*/}
/*2022*/public static void nmMin(Vec4i a_res, Vec4i b) {
/*2022*/    a_res.x = MyMath.min(a_res.x, b.x);
/*2022*/    a_res.y = MyMath.min(a_res.y, b.y);
/*2022*/    a_res.z = MyMath.min(a_res.z, b.z);
/*2022*/    a_res.w = MyMath.min(a_res.w, b.w);
/*2022*/}
/*2022*/public static void nmMin(Vec4i res, Vec4i a, int b) {
/*2022*/    res.x = MyMath.min(a.x, b);
/*2022*/    res.y = MyMath.min(a.y, b);
/*2022*/    res.z = MyMath.min(a.z, b);
/*2022*/    res.w = MyMath.min(a.w, b);
/*2022*/}
/*2022*/public static void nmMin(Vec4i a_res, int b) {
/*2022*/    a_res.x = MyMath.min(a_res.x, b);
/*2022*/    a_res.y = MyMath.min(a_res.y, b);
/*2022*/    a_res.z = MyMath.min(a_res.z, b);
/*2022*/    a_res.w = MyMath.min(a_res.w, b);
/*2022*/}
/*2022*/public static void nmMax(Vec4i res, Vec4i a, Vec4i b) {
/*2022*/    res.x = MyMath.max(a.x, b.x);
/*2022*/    res.y = MyMath.max(a.y, b.y);
/*2022*/    res.z = MyMath.max(a.z, b.z);
/*2022*/    res.w = MyMath.max(a.w, b.w);
/*2022*/}
/*2022*/public static void nmMax(Vec4i a_res, Vec4i b) {
/*2022*/    a_res.x = MyMath.max(a_res.x, b.x);
/*2022*/    a_res.y = MyMath.max(a_res.y, b.y);
/*2022*/    a_res.z = MyMath.max(a_res.z, b.z);
/*2022*/    a_res.w = MyMath.max(a_res.w, b.w);
/*2022*/}
/*2022*/public static void nmMax(Vec4i res, Vec4i a, int b) {
/*2022*/    res.x = MyMath.max(a.x, b);
/*2022*/    res.y = MyMath.max(a.y, b);
/*2022*/    res.z = MyMath.max(a.z, b);
/*2022*/    res.w = MyMath.max(a.w, b);
/*2022*/}
/*2022*/public static void nmMax(Vec4i a_res, int b) {
/*2022*/    a_res.x = MyMath.max(a_res.x, b);
/*2022*/    a_res.y = MyMath.max(a_res.y, b);
/*2022*/    a_res.z = MyMath.max(a_res.z, b);
/*2022*/    a_res.w = MyMath.max(a_res.w, b);
/*2022*/}
/*2022*/public static void nmCycle(Vec4i res, Vec4i a, Vec4i b) {
/*2022*/    res.x = MyMath.cycle(a.x, b.x);
/*2022*/    res.y = MyMath.cycle(a.y, b.y);
/*2022*/    res.z = MyMath.cycle(a.z, b.z);
/*2022*/    res.w = MyMath.cycle(a.w, b.w);
/*2022*/}
/*2022*/public static void nmCycle(Vec4i a_res, Vec4i b) {
/*2022*/    a_res.x = MyMath.cycle(a_res.x, b.x);
/*2022*/    a_res.y = MyMath.cycle(a_res.y, b.y);
/*2022*/    a_res.z = MyMath.cycle(a_res.z, b.z);
/*2022*/    a_res.w = MyMath.cycle(a_res.w, b.w);
/*2022*/}
/*2022*/public static void nmCycle(Vec4i res, Vec4i a, int b) {
/*2022*/    res.x = MyMath.cycle(a.x, b);
/*2022*/    res.y = MyMath.cycle(a.y, b);
/*2022*/    res.z = MyMath.cycle(a.z, b);
/*2022*/    res.w = MyMath.cycle(a.w, b);
/*2022*/}
/*2022*/public static void nmCycle(Vec4i a_res, int b) {
/*2022*/    a_res.x = MyMath.cycle(a_res.x, b);
/*2022*/    a_res.y = MyMath.cycle(a_res.y, b);
/*2022*/    a_res.z = MyMath.cycle(a_res.z, b);
/*2022*/    a_res.w = MyMath.cycle(a_res.w, b);
/*2022*/}
/*2022*/public static void nmAdd(Vec2f res, Vec2f a, Vec2f b) {
/*2022*/    res.x = a.x + b.x;
/*2022*/    res.y = a.y + b.y;
/*2022*/}
/*2022*/public static void nmAdd(Vec2f a_res, Vec2f b) {
/*2022*/    a_res.x = a_res.x + b.x;
/*2022*/    a_res.y = a_res.y + b.y;
/*2022*/}
/*2022*/public static void nmAdd(Vec2f res, Vec2f a, float b) {
/*2022*/    res.x = a.x + b;
/*2022*/    res.y = a.y + b;
/*2022*/}
/*2022*/public static void nmAdd(Vec2f a_res, float b) {
/*2022*/    a_res.x = a_res.x + b;
/*2022*/    a_res.y = a_res.y + b;
/*2022*/}
/*2022*/public static void nmSub(Vec2f res, Vec2f a, Vec2f b) {
/*2022*/    res.x = a.x - b.x;
/*2022*/    res.y = a.y - b.y;
/*2022*/}
/*2022*/public static void nmSub(Vec2f a_res, Vec2f b) {
/*2022*/    a_res.x = a_res.x - b.x;
/*2022*/    a_res.y = a_res.y - b.y;
/*2022*/}
/*2022*/public static void nmSub(Vec2f res, Vec2f a, float b) {
/*2022*/    res.x = a.x - b;
/*2022*/    res.y = a.y - b;
/*2022*/}
/*2022*/public static void nmSub(Vec2f a_res, float b) {
/*2022*/    a_res.x = a_res.x - b;
/*2022*/    a_res.y = a_res.y - b;
/*2022*/}
/*2022*/public static void nmMul(Vec2f res, Vec2f a, Vec2f b) {
/*2022*/    res.x = a.x * b.x;
/*2022*/    res.y = a.y * b.y;
/*2022*/}
/*2022*/public static void nmMul(Vec2f a_res, Vec2f b) {
/*2022*/    a_res.x = a_res.x * b.x;
/*2022*/    a_res.y = a_res.y * b.y;
/*2022*/}
/*2022*/public static void nmMul(Vec2f res, Vec2f a, float b) {
/*2022*/    res.x = a.x * b;
/*2022*/    res.y = a.y * b;
/*2022*/}
/*2022*/public static void nmMul(Vec2f a_res, float b) {
/*2022*/    a_res.x = a_res.x * b;
/*2022*/    a_res.y = a_res.y * b;
/*2022*/}
/*2022*/public static void nmDiv(Vec2f res, Vec2f a, Vec2f b) {
/*2022*/    res.x = a.x / b.x;
/*2022*/    res.y = a.y / b.y;
/*2022*/}
/*2022*/public static void nmDiv(Vec2f a_res, Vec2f b) {
/*2022*/    a_res.x = a_res.x / b.x;
/*2022*/    a_res.y = a_res.y / b.y;
/*2022*/}
/*2022*/public static void nmDiv(Vec2f res, Vec2f a, float b) {
/*2022*/    res.x = a.x / b;
/*2022*/    res.y = a.y / b;
/*2022*/}
/*2022*/public static void nmDiv(Vec2f a_res, float b) {
/*2022*/    a_res.x = a_res.x / b;
/*2022*/    a_res.y = a_res.y / b;
/*2022*/}
/*2022*/public static void nmRound(Vec2f res, Vec2f a) {
/*2022*/    res.x = Math.round(a.x);
/*2022*/    res.y = Math.round(a.y);
/*2022*/}
/*2022*/public static void nmFloor(Vec2f res, Vec2f a) {
/*2022*/    res.x = MyMath.floorFast(a.x);
/*2022*/    res.y = MyMath.floorFast(a.y);
/*2022*/}
/*2022*/public static void nmCeil(Vec2f res, Vec2f a) {
/*2022*/    res.x = MyMath.ceil(a.x);
/*2022*/    res.y = MyMath.ceil(a.y);
/*2022*/}
/*2022*/public static void nmAbs(Vec2f res, Vec2f a) {
/*2022*/    res.x = MyMath.abs(a.x);
/*2022*/    res.y = MyMath.abs(a.y);
/*2022*/}
/*2022*/public static void nmMin(Vec2f res, Vec2f a, Vec2f b) {
/*2022*/    res.x = MyMath.min(a.x, b.x);
/*2022*/    res.y = MyMath.min(a.y, b.y);
/*2022*/}
/*2022*/public static void nmMin(Vec2f a_res, Vec2f b) {
/*2022*/    a_res.x = MyMath.min(a_res.x, b.x);
/*2022*/    a_res.y = MyMath.min(a_res.y, b.y);
/*2022*/}
/*2022*/public static void nmMin(Vec2f res, Vec2f a, float b) {
/*2022*/    res.x = MyMath.min(a.x, b);
/*2022*/    res.y = MyMath.min(a.y, b);
/*2022*/}
/*2022*/public static void nmMin(Vec2f a_res, float b) {
/*2022*/    a_res.x = MyMath.min(a_res.x, b);
/*2022*/    a_res.y = MyMath.min(a_res.y, b);
/*2022*/}
/*2022*/public static void nmMax(Vec2f res, Vec2f a, Vec2f b) {
/*2022*/    res.x = MyMath.max(a.x, b.x);
/*2022*/    res.y = MyMath.max(a.y, b.y);
/*2022*/}
/*2022*/public static void nmMax(Vec2f a_res, Vec2f b) {
/*2022*/    a_res.x = MyMath.max(a_res.x, b.x);
/*2022*/    a_res.y = MyMath.max(a_res.y, b.y);
/*2022*/}
/*2022*/public static void nmMax(Vec2f res, Vec2f a, float b) {
/*2022*/    res.x = MyMath.max(a.x, b);
/*2022*/    res.y = MyMath.max(a.y, b);
/*2022*/}
/*2022*/public static void nmMax(Vec2f a_res, float b) {
/*2022*/    a_res.x = MyMath.max(a_res.x, b);
/*2022*/    a_res.y = MyMath.max(a_res.y, b);
/*2022*/}
/*2022*/public static void nmCycle(Vec2f res, Vec2f a, Vec2f b) {
/*2022*/    res.x = MyMath.cycle(a.x, b.x);
/*2022*/    res.y = MyMath.cycle(a.y, b.y);
/*2022*/}
/*2022*/public static void nmCycle(Vec2f a_res, Vec2f b) {
/*2022*/    a_res.x = MyMath.cycle(a_res.x, b.x);
/*2022*/    a_res.y = MyMath.cycle(a_res.y, b.y);
/*2022*/}
/*2022*/public static void nmCycle(Vec2f res, Vec2f a, float b) {
/*2022*/    res.x = MyMath.cycle(a.x, b);
/*2022*/    res.y = MyMath.cycle(a.y, b);
/*2022*/}
/*2022*/public static void nmCycle(Vec2f a_res, float b) {
/*2022*/    a_res.x = MyMath.cycle(a_res.x, b);
/*2022*/    a_res.y = MyMath.cycle(a_res.y, b);
/*2022*/}
/*2022*/public static void nmAdd(Vec3f res, Vec3f a, Vec3f b) {
/*2022*/    res.x = a.x + b.x;
/*2022*/    res.y = a.y + b.y;
/*2022*/    res.z = a.z + b.z;
/*2022*/}
/*2022*/public static void nmAdd(Vec3f a_res, Vec3f b) {
/*2022*/    a_res.x = a_res.x + b.x;
/*2022*/    a_res.y = a_res.y + b.y;
/*2022*/    a_res.z = a_res.z + b.z;
/*2022*/}
/*2022*/public static void nmAdd(Vec3f res, Vec3f a, float b) {
/*2022*/    res.x = a.x + b;
/*2022*/    res.y = a.y + b;
/*2022*/    res.z = a.z + b;
/*2022*/}
/*2022*/public static void nmAdd(Vec3f a_res, float b) {
/*2022*/    a_res.x = a_res.x + b;
/*2022*/    a_res.y = a_res.y + b;
/*2022*/    a_res.z = a_res.z + b;
/*2022*/}
/*2022*/public static void nmSub(Vec3f res, Vec3f a, Vec3f b) {
/*2022*/    res.x = a.x - b.x;
/*2022*/    res.y = a.y - b.y;
/*2022*/    res.z = a.z - b.z;
/*2022*/}
/*2022*/public static void nmSub(Vec3f a_res, Vec3f b) {
/*2022*/    a_res.x = a_res.x - b.x;
/*2022*/    a_res.y = a_res.y - b.y;
/*2022*/    a_res.z = a_res.z - b.z;
/*2022*/}
/*2022*/public static void nmSub(Vec3f res, Vec3f a, float b) {
/*2022*/    res.x = a.x - b;
/*2022*/    res.y = a.y - b;
/*2022*/    res.z = a.z - b;
/*2022*/}
/*2022*/public static void nmSub(Vec3f a_res, float b) {
/*2022*/    a_res.x = a_res.x - b;
/*2022*/    a_res.y = a_res.y - b;
/*2022*/    a_res.z = a_res.z - b;
/*2022*/}
/*2022*/public static void nmMul(Vec3f res, Vec3f a, Vec3f b) {
/*2022*/    res.x = a.x * b.x;
/*2022*/    res.y = a.y * b.y;
/*2022*/    res.z = a.z * b.z;
/*2022*/}
/*2022*/public static void nmMul(Vec3f a_res, Vec3f b) {
/*2022*/    a_res.x = a_res.x * b.x;
/*2022*/    a_res.y = a_res.y * b.y;
/*2022*/    a_res.z = a_res.z * b.z;
/*2022*/}
/*2022*/public static void nmMul(Vec3f res, Vec3f a, float b) {
/*2022*/    res.x = a.x * b;
/*2022*/    res.y = a.y * b;
/*2022*/    res.z = a.z * b;
/*2022*/}
/*2022*/public static void nmMul(Vec3f a_res, float b) {
/*2022*/    a_res.x = a_res.x * b;
/*2022*/    a_res.y = a_res.y * b;
/*2022*/    a_res.z = a_res.z * b;
/*2022*/}
/*2022*/public static void nmDiv(Vec3f res, Vec3f a, Vec3f b) {
/*2022*/    res.x = a.x / b.x;
/*2022*/    res.y = a.y / b.y;
/*2022*/    res.z = a.z / b.z;
/*2022*/}
/*2022*/public static void nmDiv(Vec3f a_res, Vec3f b) {
/*2022*/    a_res.x = a_res.x / b.x;
/*2022*/    a_res.y = a_res.y / b.y;
/*2022*/    a_res.z = a_res.z / b.z;
/*2022*/}
/*2022*/public static void nmDiv(Vec3f res, Vec3f a, float b) {
/*2022*/    res.x = a.x / b;
/*2022*/    res.y = a.y / b;
/*2022*/    res.z = a.z / b;
/*2022*/}
/*2022*/public static void nmDiv(Vec3f a_res, float b) {
/*2022*/    a_res.x = a_res.x / b;
/*2022*/    a_res.y = a_res.y / b;
/*2022*/    a_res.z = a_res.z / b;
/*2022*/}
/*2022*/public static void nmRound(Vec3f res, Vec3f a) {
/*2022*/    res.x = Math.round(a.x);
/*2022*/    res.y = Math.round(a.y);
/*2022*/    res.z = Math.round(a.z);
/*2022*/}
/*2022*/public static void nmFloor(Vec3f res, Vec3f a) {
/*2022*/    res.x = MyMath.floorFast(a.x);
/*2022*/    res.y = MyMath.floorFast(a.y);
/*2022*/    res.z = MyMath.floorFast(a.z);
/*2022*/}
/*2022*/public static void nmCeil(Vec3f res, Vec3f a) {
/*2022*/    res.x = MyMath.ceil(a.x);
/*2022*/    res.y = MyMath.ceil(a.y);
/*2022*/    res.z = MyMath.ceil(a.z);
/*2022*/}
/*2022*/public static void nmAbs(Vec3f res, Vec3f a) {
/*2022*/    res.x = MyMath.abs(a.x);
/*2022*/    res.y = MyMath.abs(a.y);
/*2022*/    res.z = MyMath.abs(a.z);
/*2022*/}
/*2022*/public static void nmMin(Vec3f res, Vec3f a, Vec3f b) {
/*2022*/    res.x = MyMath.min(a.x, b.x);
/*2022*/    res.y = MyMath.min(a.y, b.y);
/*2022*/    res.z = MyMath.min(a.z, b.z);
/*2022*/}
/*2022*/public static void nmMin(Vec3f a_res, Vec3f b) {
/*2022*/    a_res.x = MyMath.min(a_res.x, b.x);
/*2022*/    a_res.y = MyMath.min(a_res.y, b.y);
/*2022*/    a_res.z = MyMath.min(a_res.z, b.z);
/*2022*/}
/*2022*/public static void nmMin(Vec3f res, Vec3f a, float b) {
/*2022*/    res.x = MyMath.min(a.x, b);
/*2022*/    res.y = MyMath.min(a.y, b);
/*2022*/    res.z = MyMath.min(a.z, b);
/*2022*/}
/*2022*/public static void nmMin(Vec3f a_res, float b) {
/*2022*/    a_res.x = MyMath.min(a_res.x, b);
/*2022*/    a_res.y = MyMath.min(a_res.y, b);
/*2022*/    a_res.z = MyMath.min(a_res.z, b);
/*2022*/}
/*2022*/public static void nmMax(Vec3f res, Vec3f a, Vec3f b) {
/*2022*/    res.x = MyMath.max(a.x, b.x);
/*2022*/    res.y = MyMath.max(a.y, b.y);
/*2022*/    res.z = MyMath.max(a.z, b.z);
/*2022*/}
/*2022*/public static void nmMax(Vec3f a_res, Vec3f b) {
/*2022*/    a_res.x = MyMath.max(a_res.x, b.x);
/*2022*/    a_res.y = MyMath.max(a_res.y, b.y);
/*2022*/    a_res.z = MyMath.max(a_res.z, b.z);
/*2022*/}
/*2022*/public static void nmMax(Vec3f res, Vec3f a, float b) {
/*2022*/    res.x = MyMath.max(a.x, b);
/*2022*/    res.y = MyMath.max(a.y, b);
/*2022*/    res.z = MyMath.max(a.z, b);
/*2022*/}
/*2022*/public static void nmMax(Vec3f a_res, float b) {
/*2022*/    a_res.x = MyMath.max(a_res.x, b);
/*2022*/    a_res.y = MyMath.max(a_res.y, b);
/*2022*/    a_res.z = MyMath.max(a_res.z, b);
/*2022*/}
/*2022*/public static void nmCycle(Vec3f res, Vec3f a, Vec3f b) {
/*2022*/    res.x = MyMath.cycle(a.x, b.x);
/*2022*/    res.y = MyMath.cycle(a.y, b.y);
/*2022*/    res.z = MyMath.cycle(a.z, b.z);
/*2022*/}
/*2022*/public static void nmCycle(Vec3f a_res, Vec3f b) {
/*2022*/    a_res.x = MyMath.cycle(a_res.x, b.x);
/*2022*/    a_res.y = MyMath.cycle(a_res.y, b.y);
/*2022*/    a_res.z = MyMath.cycle(a_res.z, b.z);
/*2022*/}
/*2022*/public static void nmCycle(Vec3f res, Vec3f a, float b) {
/*2022*/    res.x = MyMath.cycle(a.x, b);
/*2022*/    res.y = MyMath.cycle(a.y, b);
/*2022*/    res.z = MyMath.cycle(a.z, b);
/*2022*/}
/*2022*/public static void nmCycle(Vec3f a_res, float b) {
/*2022*/    a_res.x = MyMath.cycle(a_res.x, b);
/*2022*/    a_res.y = MyMath.cycle(a_res.y, b);
/*2022*/    a_res.z = MyMath.cycle(a_res.z, b);
/*2022*/}
/*2022*/public static void nmAdd(Vec4f res, Vec4f a, Vec4f b) {
/*2022*/    res.x = a.x + b.x;
/*2022*/    res.y = a.y + b.y;
/*2022*/    res.z = a.z + b.z;
/*2022*/    res.w = a.w + b.w;
/*2022*/}
/*2022*/public static void nmAdd(Vec4f a_res, Vec4f b) {
/*2022*/    a_res.x = a_res.x + b.x;
/*2022*/    a_res.y = a_res.y + b.y;
/*2022*/    a_res.z = a_res.z + b.z;
/*2022*/    a_res.w = a_res.w + b.w;
/*2022*/}
/*2022*/public static void nmAdd(Vec4f res, Vec4f a, float b) {
/*2022*/    res.x = a.x + b;
/*2022*/    res.y = a.y + b;
/*2022*/    res.z = a.z + b;
/*2022*/    res.w = a.w + b;
/*2022*/}
/*2022*/public static void nmAdd(Vec4f a_res, float b) {
/*2022*/    a_res.x = a_res.x + b;
/*2022*/    a_res.y = a_res.y + b;
/*2022*/    a_res.z = a_res.z + b;
/*2022*/    a_res.w = a_res.w + b;
/*2022*/}
/*2022*/public static void nmSub(Vec4f res, Vec4f a, Vec4f b) {
/*2022*/    res.x = a.x - b.x;
/*2022*/    res.y = a.y - b.y;
/*2022*/    res.z = a.z - b.z;
/*2022*/    res.w = a.w - b.w;
/*2022*/}
/*2022*/public static void nmSub(Vec4f a_res, Vec4f b) {
/*2022*/    a_res.x = a_res.x - b.x;
/*2022*/    a_res.y = a_res.y - b.y;
/*2022*/    a_res.z = a_res.z - b.z;
/*2022*/    a_res.w = a_res.w - b.w;
/*2022*/}
/*2022*/public static void nmSub(Vec4f res, Vec4f a, float b) {
/*2022*/    res.x = a.x - b;
/*2022*/    res.y = a.y - b;
/*2022*/    res.z = a.z - b;
/*2022*/    res.w = a.w - b;
/*2022*/}
/*2022*/public static void nmSub(Vec4f a_res, float b) {
/*2022*/    a_res.x = a_res.x - b;
/*2022*/    a_res.y = a_res.y - b;
/*2022*/    a_res.z = a_res.z - b;
/*2022*/    a_res.w = a_res.w - b;
/*2022*/}
/*2022*/public static void nmMul(Vec4f res, Vec4f a, Vec4f b) {
/*2022*/    res.x = a.x * b.x;
/*2022*/    res.y = a.y * b.y;
/*2022*/    res.z = a.z * b.z;
/*2022*/    res.w = a.w * b.w;
/*2022*/}
/*2022*/public static void nmMul(Vec4f a_res, Vec4f b) {
/*2022*/    a_res.x = a_res.x * b.x;
/*2022*/    a_res.y = a_res.y * b.y;
/*2022*/    a_res.z = a_res.z * b.z;
/*2022*/    a_res.w = a_res.w * b.w;
/*2022*/}
/*2022*/public static void nmMul(Vec4f res, Vec4f a, float b) {
/*2022*/    res.x = a.x * b;
/*2022*/    res.y = a.y * b;
/*2022*/    res.z = a.z * b;
/*2022*/    res.w = a.w * b;
/*2022*/}
/*2022*/public static void nmMul(Vec4f a_res, float b) {
/*2022*/    a_res.x = a_res.x * b;
/*2022*/    a_res.y = a_res.y * b;
/*2022*/    a_res.z = a_res.z * b;
/*2022*/    a_res.w = a_res.w * b;
/*2022*/}
/*2022*/public static void nmDiv(Vec4f res, Vec4f a, Vec4f b) {
/*2022*/    res.x = a.x / b.x;
/*2022*/    res.y = a.y / b.y;
/*2022*/    res.z = a.z / b.z;
/*2022*/    res.w = a.w / b.w;
/*2022*/}
/*2022*/public static void nmDiv(Vec4f a_res, Vec4f b) {
/*2022*/    a_res.x = a_res.x / b.x;
/*2022*/    a_res.y = a_res.y / b.y;
/*2022*/    a_res.z = a_res.z / b.z;
/*2022*/    a_res.w = a_res.w / b.w;
/*2022*/}
/*2022*/public static void nmDiv(Vec4f res, Vec4f a, float b) {
/*2022*/    res.x = a.x / b;
/*2022*/    res.y = a.y / b;
/*2022*/    res.z = a.z / b;
/*2022*/    res.w = a.w / b;
/*2022*/}
/*2022*/public static void nmDiv(Vec4f a_res, float b) {
/*2022*/    a_res.x = a_res.x / b;
/*2022*/    a_res.y = a_res.y / b;
/*2022*/    a_res.z = a_res.z / b;
/*2022*/    a_res.w = a_res.w / b;
/*2022*/}
/*2022*/public static void nmRound(Vec4f res, Vec4f a) {
/*2022*/    res.x = Math.round(a.x);
/*2022*/    res.y = Math.round(a.y);
/*2022*/    res.z = Math.round(a.z);
/*2022*/    res.w = Math.round(a.w);
/*2022*/}
/*2022*/public static void nmFloor(Vec4f res, Vec4f a) {
/*2022*/    res.x = MyMath.floorFast(a.x);
/*2022*/    res.y = MyMath.floorFast(a.y);
/*2022*/    res.z = MyMath.floorFast(a.z);
/*2022*/    res.w = MyMath.floorFast(a.w);
/*2022*/}
/*2022*/public static void nmCeil(Vec4f res, Vec4f a) {
/*2022*/    res.x = MyMath.ceil(a.x);
/*2022*/    res.y = MyMath.ceil(a.y);
/*2022*/    res.z = MyMath.ceil(a.z);
/*2022*/    res.w = MyMath.ceil(a.w);
/*2022*/}
/*2022*/public static void nmAbs(Vec4f res, Vec4f a) {
/*2022*/    res.x = MyMath.abs(a.x);
/*2022*/    res.y = MyMath.abs(a.y);
/*2022*/    res.z = MyMath.abs(a.z);
/*2022*/    res.w = MyMath.abs(a.w);
/*2022*/}
/*2022*/public static void nmMin(Vec4f res, Vec4f a, Vec4f b) {
/*2022*/    res.x = MyMath.min(a.x, b.x);
/*2022*/    res.y = MyMath.min(a.y, b.y);
/*2022*/    res.z = MyMath.min(a.z, b.z);
/*2022*/    res.w = MyMath.min(a.w, b.w);
/*2022*/}
/*2022*/public static void nmMin(Vec4f a_res, Vec4f b) {
/*2022*/    a_res.x = MyMath.min(a_res.x, b.x);
/*2022*/    a_res.y = MyMath.min(a_res.y, b.y);
/*2022*/    a_res.z = MyMath.min(a_res.z, b.z);
/*2022*/    a_res.w = MyMath.min(a_res.w, b.w);
/*2022*/}
/*2022*/public static void nmMin(Vec4f res, Vec4f a, float b) {
/*2022*/    res.x = MyMath.min(a.x, b);
/*2022*/    res.y = MyMath.min(a.y, b);
/*2022*/    res.z = MyMath.min(a.z, b);
/*2022*/    res.w = MyMath.min(a.w, b);
/*2022*/}
/*2022*/public static void nmMin(Vec4f a_res, float b) {
/*2022*/    a_res.x = MyMath.min(a_res.x, b);
/*2022*/    a_res.y = MyMath.min(a_res.y, b);
/*2022*/    a_res.z = MyMath.min(a_res.z, b);
/*2022*/    a_res.w = MyMath.min(a_res.w, b);
/*2022*/}
/*2022*/public static void nmMax(Vec4f res, Vec4f a, Vec4f b) {
/*2022*/    res.x = MyMath.max(a.x, b.x);
/*2022*/    res.y = MyMath.max(a.y, b.y);
/*2022*/    res.z = MyMath.max(a.z, b.z);
/*2022*/    res.w = MyMath.max(a.w, b.w);
/*2022*/}
/*2022*/public static void nmMax(Vec4f a_res, Vec4f b) {
/*2022*/    a_res.x = MyMath.max(a_res.x, b.x);
/*2022*/    a_res.y = MyMath.max(a_res.y, b.y);
/*2022*/    a_res.z = MyMath.max(a_res.z, b.z);
/*2022*/    a_res.w = MyMath.max(a_res.w, b.w);
/*2022*/}
/*2022*/public static void nmMax(Vec4f res, Vec4f a, float b) {
/*2022*/    res.x = MyMath.max(a.x, b);
/*2022*/    res.y = MyMath.max(a.y, b);
/*2022*/    res.z = MyMath.max(a.z, b);
/*2022*/    res.w = MyMath.max(a.w, b);
/*2022*/}
/*2022*/public static void nmMax(Vec4f a_res, float b) {
/*2022*/    a_res.x = MyMath.max(a_res.x, b);
/*2022*/    a_res.y = MyMath.max(a_res.y, b);
/*2022*/    a_res.z = MyMath.max(a_res.z, b);
/*2022*/    a_res.w = MyMath.max(a_res.w, b);
/*2022*/}
/*2022*/public static void nmCycle(Vec4f res, Vec4f a, Vec4f b) {
/*2022*/    res.x = MyMath.cycle(a.x, b.x);
/*2022*/    res.y = MyMath.cycle(a.y, b.y);
/*2022*/    res.z = MyMath.cycle(a.z, b.z);
/*2022*/    res.w = MyMath.cycle(a.w, b.w);
/*2022*/}
/*2022*/public static void nmCycle(Vec4f a_res, Vec4f b) {
/*2022*/    a_res.x = MyMath.cycle(a_res.x, b.x);
/*2022*/    a_res.y = MyMath.cycle(a_res.y, b.y);
/*2022*/    a_res.z = MyMath.cycle(a_res.z, b.z);
/*2022*/    a_res.w = MyMath.cycle(a_res.w, b.w);
/*2022*/}
/*2022*/public static void nmCycle(Vec4f res, Vec4f a, float b) {
/*2022*/    res.x = MyMath.cycle(a.x, b);
/*2022*/    res.y = MyMath.cycle(a.y, b);
/*2022*/    res.z = MyMath.cycle(a.z, b);
/*2022*/    res.w = MyMath.cycle(a.w, b);
/*2022*/}
/*2022*/public static void nmCycle(Vec4f a_res, float b) {
/*2022*/    a_res.x = MyMath.cycle(a_res.x, b);
/*2022*/    a_res.y = MyMath.cycle(a_res.y, b);
/*2022*/    a_res.z = MyMath.cycle(a_res.z, b);
/*2022*/    a_res.w = MyMath.cycle(a_res.w, b);
/*2022*/}
/*2022*/public static void nmAdd(Vec3l res, Vec3l a, Vec3l b) {
/*2022*/    res.x = a.x + b.x;
/*2022*/    res.y = a.y + b.y;
/*2022*/    res.z = a.z + b.z;
/*2022*/}
/*2022*/public static void nmAdd(Vec3l a_res, Vec3l b) {
/*2022*/    a_res.x = a_res.x + b.x;
/*2022*/    a_res.y = a_res.y + b.y;
/*2022*/    a_res.z = a_res.z + b.z;
/*2022*/}
/*2022*/public static void nmAdd(Vec3l res, Vec3l a, long b) {
/*2022*/    res.x = a.x + b;
/*2022*/    res.y = a.y + b;
/*2022*/    res.z = a.z + b;
/*2022*/}
/*2022*/public static void nmAdd(Vec3l a_res, long b) {
/*2022*/    a_res.x = a_res.x + b;
/*2022*/    a_res.y = a_res.y + b;
/*2022*/    a_res.z = a_res.z + b;
/*2022*/}
/*2022*/public static void nmSub(Vec3l res, Vec3l a, Vec3l b) {
/*2022*/    res.x = a.x - b.x;
/*2022*/    res.y = a.y - b.y;
/*2022*/    res.z = a.z - b.z;
/*2022*/}
/*2022*/public static void nmSub(Vec3l a_res, Vec3l b) {
/*2022*/    a_res.x = a_res.x - b.x;
/*2022*/    a_res.y = a_res.y - b.y;
/*2022*/    a_res.z = a_res.z - b.z;
/*2022*/}
/*2022*/public static void nmSub(Vec3l res, Vec3l a, long b) {
/*2022*/    res.x = a.x - b;
/*2022*/    res.y = a.y - b;
/*2022*/    res.z = a.z - b;
/*2022*/}
/*2022*/public static void nmSub(Vec3l a_res, long b) {
/*2022*/    a_res.x = a_res.x - b;
/*2022*/    a_res.y = a_res.y - b;
/*2022*/    a_res.z = a_res.z - b;
/*2022*/}
/*2022*/public static void nmMul(Vec3l res, Vec3l a, Vec3l b) {
/*2022*/    res.x = a.x * b.x;
/*2022*/    res.y = a.y * b.y;
/*2022*/    res.z = a.z * b.z;
/*2022*/}
/*2022*/public static void nmMul(Vec3l a_res, Vec3l b) {
/*2022*/    a_res.x = a_res.x * b.x;
/*2022*/    a_res.y = a_res.y * b.y;
/*2022*/    a_res.z = a_res.z * b.z;
/*2022*/}
/*2022*/public static void nmMul(Vec3l res, Vec3l a, long b) {
/*2022*/    res.x = a.x * b;
/*2022*/    res.y = a.y * b;
/*2022*/    res.z = a.z * b;
/*2022*/}
/*2022*/public static void nmMul(Vec3l a_res, long b) {
/*2022*/    a_res.x = a_res.x * b;
/*2022*/    a_res.y = a_res.y * b;
/*2022*/    a_res.z = a_res.z * b;
/*2022*/}
/*2022*/public static void nmDiv(Vec3l res, Vec3l a, Vec3l b) {
/*2022*/    res.x = a.x / b.x;
/*2022*/    res.y = a.y / b.y;
/*2022*/    res.z = a.z / b.z;
/*2022*/}
/*2022*/public static void nmDiv(Vec3l a_res, Vec3l b) {
/*2022*/    a_res.x = a_res.x / b.x;
/*2022*/    a_res.y = a_res.y / b.y;
/*2022*/    a_res.z = a_res.z / b.z;
/*2022*/}
/*2022*/public static void nmDiv(Vec3l res, Vec3l a, long b) {
/*2022*/    res.x = a.x / b;
/*2022*/    res.y = a.y / b;
/*2022*/    res.z = a.z / b;
/*2022*/}
/*2022*/public static void nmDiv(Vec3l a_res, long b) {
/*2022*/    a_res.x = a_res.x / b;
/*2022*/    a_res.y = a_res.y / b;
/*2022*/    a_res.z = a_res.z / b;
/*2022*/}
/*2022*/public static void nmAbs(Vec3l res, Vec3l a) {
/*2022*/    res.x = MyMath.abs(a.x);
/*2022*/    res.y = MyMath.abs(a.y);
/*2022*/    res.z = MyMath.abs(a.z);
/*2022*/}
/*2022*/public static void nmMin(Vec3l res, Vec3l a, Vec3l b) {
/*2022*/    res.x = MyMath.min(a.x, b.x);
/*2022*/    res.y = MyMath.min(a.y, b.y);
/*2022*/    res.z = MyMath.min(a.z, b.z);
/*2022*/}
/*2022*/public static void nmMin(Vec3l a_res, Vec3l b) {
/*2022*/    a_res.x = MyMath.min(a_res.x, b.x);
/*2022*/    a_res.y = MyMath.min(a_res.y, b.y);
/*2022*/    a_res.z = MyMath.min(a_res.z, b.z);
/*2022*/}
/*2022*/public static void nmMin(Vec3l res, Vec3l a, long b) {
/*2022*/    res.x = MyMath.min(a.x, b);
/*2022*/    res.y = MyMath.min(a.y, b);
/*2022*/    res.z = MyMath.min(a.z, b);
/*2022*/}
/*2022*/public static void nmMin(Vec3l a_res, long b) {
/*2022*/    a_res.x = MyMath.min(a_res.x, b);
/*2022*/    a_res.y = MyMath.min(a_res.y, b);
/*2022*/    a_res.z = MyMath.min(a_res.z, b);
/*2022*/}
/*2022*/public static void nmMax(Vec3l res, Vec3l a, Vec3l b) {
/*2022*/    res.x = MyMath.max(a.x, b.x);
/*2022*/    res.y = MyMath.max(a.y, b.y);
/*2022*/    res.z = MyMath.max(a.z, b.z);
/*2022*/}
/*2022*/public static void nmMax(Vec3l a_res, Vec3l b) {
/*2022*/    a_res.x = MyMath.max(a_res.x, b.x);
/*2022*/    a_res.y = MyMath.max(a_res.y, b.y);
/*2022*/    a_res.z = MyMath.max(a_res.z, b.z);
/*2022*/}
/*2022*/public static void nmMax(Vec3l res, Vec3l a, long b) {
/*2022*/    res.x = MyMath.max(a.x, b);
/*2022*/    res.y = MyMath.max(a.y, b);
/*2022*/    res.z = MyMath.max(a.z, b);
/*2022*/}
/*2022*/public static void nmMax(Vec3l a_res, long b) {
/*2022*/    a_res.x = MyMath.max(a_res.x, b);
/*2022*/    a_res.y = MyMath.max(a_res.y, b);
/*2022*/    a_res.z = MyMath.max(a_res.z, b);
/*2022*/}
/*2022*/public static void nmCycle(Vec3l res, Vec3l a, Vec3l b) {
/*2022*/    res.x = MyMath.cycle(a.x, b.x);
/*2022*/    res.y = MyMath.cycle(a.y, b.y);
/*2022*/    res.z = MyMath.cycle(a.z, b.z);
/*2022*/}
/*2022*/public static void nmCycle(Vec3l a_res, Vec3l b) {
/*2022*/    a_res.x = MyMath.cycle(a_res.x, b.x);
/*2022*/    a_res.y = MyMath.cycle(a_res.y, b.y);
/*2022*/    a_res.z = MyMath.cycle(a_res.z, b.z);
/*2022*/}
/*2022*/public static void nmCycle(Vec3l res, Vec3l a, long b) {
/*2022*/    res.x = MyMath.cycle(a.x, b);
/*2022*/    res.y = MyMath.cycle(a.y, b);
/*2022*/    res.z = MyMath.cycle(a.z, b);
/*2022*/}
/*2022*/public static void nmCycle(Vec3l a_res, long b) {
/*2022*/    a_res.x = MyMath.cycle(a_res.x, b);
/*2022*/    a_res.y = MyMath.cycle(a_res.y, b);
/*2022*/    a_res.z = MyMath.cycle(a_res.z, b);
/*2022*/}
/*2022*/public static void nmAdd(Vec3d res, Vec3d a, Vec3d b) {
/*2022*/    res.x = a.x + b.x;
/*2022*/    res.y = a.y + b.y;
/*2022*/    res.z = a.z + b.z;
/*2022*/}
/*2022*/public static void nmAdd(Vec3d a_res, Vec3d b) {
/*2022*/    a_res.x = a_res.x + b.x;
/*2022*/    a_res.y = a_res.y + b.y;
/*2022*/    a_res.z = a_res.z + b.z;
/*2022*/}
/*2022*/public static void nmAdd(Vec3d res, Vec3d a, double b) {
/*2022*/    res.x = a.x + b;
/*2022*/    res.y = a.y + b;
/*2022*/    res.z = a.z + b;
/*2022*/}
/*2022*/public static void nmAdd(Vec3d a_res, double b) {
/*2022*/    a_res.x = a_res.x + b;
/*2022*/    a_res.y = a_res.y + b;
/*2022*/    a_res.z = a_res.z + b;
/*2022*/}
/*2022*/public static void nmSub(Vec3d res, Vec3d a, Vec3d b) {
/*2022*/    res.x = a.x - b.x;
/*2022*/    res.y = a.y - b.y;
/*2022*/    res.z = a.z - b.z;
/*2022*/}
/*2022*/public static void nmSub(Vec3d a_res, Vec3d b) {
/*2022*/    a_res.x = a_res.x - b.x;
/*2022*/    a_res.y = a_res.y - b.y;
/*2022*/    a_res.z = a_res.z - b.z;
/*2022*/}
/*2022*/public static void nmSub(Vec3d res, Vec3d a, double b) {
/*2022*/    res.x = a.x - b;
/*2022*/    res.y = a.y - b;
/*2022*/    res.z = a.z - b;
/*2022*/}
/*2022*/public static void nmSub(Vec3d a_res, double b) {
/*2022*/    a_res.x = a_res.x - b;
/*2022*/    a_res.y = a_res.y - b;
/*2022*/    a_res.z = a_res.z - b;
/*2022*/}
/*2022*/public static void nmMul(Vec3d res, Vec3d a, Vec3d b) {
/*2022*/    res.x = a.x * b.x;
/*2022*/    res.y = a.y * b.y;
/*2022*/    res.z = a.z * b.z;
/*2022*/}
/*2022*/public static void nmMul(Vec3d a_res, Vec3d b) {
/*2022*/    a_res.x = a_res.x * b.x;
/*2022*/    a_res.y = a_res.y * b.y;
/*2022*/    a_res.z = a_res.z * b.z;
/*2022*/}
/*2022*/public static void nmMul(Vec3d res, Vec3d a, double b) {
/*2022*/    res.x = a.x * b;
/*2022*/    res.y = a.y * b;
/*2022*/    res.z = a.z * b;
/*2022*/}
/*2022*/public static void nmMul(Vec3d a_res, double b) {
/*2022*/    a_res.x = a_res.x * b;
/*2022*/    a_res.y = a_res.y * b;
/*2022*/    a_res.z = a_res.z * b;
/*2022*/}
/*2022*/public static void nmDiv(Vec3d res, Vec3d a, Vec3d b) {
/*2022*/    res.x = a.x / b.x;
/*2022*/    res.y = a.y / b.y;
/*2022*/    res.z = a.z / b.z;
/*2022*/}
/*2022*/public static void nmDiv(Vec3d a_res, Vec3d b) {
/*2022*/    a_res.x = a_res.x / b.x;
/*2022*/    a_res.y = a_res.y / b.y;
/*2022*/    a_res.z = a_res.z / b.z;
/*2022*/}
/*2022*/public static void nmDiv(Vec3d res, Vec3d a, double b) {
/*2022*/    res.x = a.x / b;
/*2022*/    res.y = a.y / b;
/*2022*/    res.z = a.z / b;
/*2022*/}
/*2022*/public static void nmDiv(Vec3d a_res, double b) {
/*2022*/    a_res.x = a_res.x / b;
/*2022*/    a_res.y = a_res.y / b;
/*2022*/    a_res.z = a_res.z / b;
/*2022*/}
/*2022*/public static void nmRound(Vec3d res, Vec3d a) {
/*2022*/    res.x = Math.round(a.x);
/*2022*/    res.y = Math.round(a.y);
/*2022*/    res.z = Math.round(a.z);
/*2022*/}
/*2022*/public static void nmFloor(Vec3d res, Vec3d a) {
/*2022*/    res.x = MyMath.floorFast(a.x);
/*2022*/    res.y = MyMath.floorFast(a.y);
/*2022*/    res.z = MyMath.floorFast(a.z);
/*2022*/}
/*2022*/public static void nmCeil(Vec3d res, Vec3d a) {
/*2022*/    res.x = MyMath.ceil(a.x);
/*2022*/    res.y = MyMath.ceil(a.y);
/*2022*/    res.z = MyMath.ceil(a.z);
/*2022*/}
/*2022*/public static void nmAbs(Vec3d res, Vec3d a) {
/*2022*/    res.x = MyMath.abs(a.x);
/*2022*/    res.y = MyMath.abs(a.y);
/*2022*/    res.z = MyMath.abs(a.z);
/*2022*/}
/*2022*/public static void nmMin(Vec3d res, Vec3d a, Vec3d b) {
/*2022*/    res.x = MyMath.min(a.x, b.x);
/*2022*/    res.y = MyMath.min(a.y, b.y);
/*2022*/    res.z = MyMath.min(a.z, b.z);
/*2022*/}
/*2022*/public static void nmMin(Vec3d a_res, Vec3d b) {
/*2022*/    a_res.x = MyMath.min(a_res.x, b.x);
/*2022*/    a_res.y = MyMath.min(a_res.y, b.y);
/*2022*/    a_res.z = MyMath.min(a_res.z, b.z);
/*2022*/}
/*2022*/public static void nmMin(Vec3d res, Vec3d a, double b) {
/*2022*/    res.x = MyMath.min(a.x, b);
/*2022*/    res.y = MyMath.min(a.y, b);
/*2022*/    res.z = MyMath.min(a.z, b);
/*2022*/}
/*2022*/public static void nmMin(Vec3d a_res, double b) {
/*2022*/    a_res.x = MyMath.min(a_res.x, b);
/*2022*/    a_res.y = MyMath.min(a_res.y, b);
/*2022*/    a_res.z = MyMath.min(a_res.z, b);
/*2022*/}
/*2022*/public static void nmMax(Vec3d res, Vec3d a, Vec3d b) {
/*2022*/    res.x = MyMath.max(a.x, b.x);
/*2022*/    res.y = MyMath.max(a.y, b.y);
/*2022*/    res.z = MyMath.max(a.z, b.z);
/*2022*/}
/*2022*/public static void nmMax(Vec3d a_res, Vec3d b) {
/*2022*/    a_res.x = MyMath.max(a_res.x, b.x);
/*2022*/    a_res.y = MyMath.max(a_res.y, b.y);
/*2022*/    a_res.z = MyMath.max(a_res.z, b.z);
/*2022*/}
/*2022*/public static void nmMax(Vec3d res, Vec3d a, double b) {
/*2022*/    res.x = MyMath.max(a.x, b);
/*2022*/    res.y = MyMath.max(a.y, b);
/*2022*/    res.z = MyMath.max(a.z, b);
/*2022*/}
/*2022*/public static void nmMax(Vec3d a_res, double b) {
/*2022*/    a_res.x = MyMath.max(a_res.x, b);
/*2022*/    a_res.y = MyMath.max(a_res.y, b);
/*2022*/    a_res.z = MyMath.max(a_res.z, b);
/*2022*/}
/*2022*/public static void nmCycle(Vec3d res, Vec3d a, Vec3d b) {
/*2022*/    res.x = MyMath.cycle(a.x, b.x);
/*2022*/    res.y = MyMath.cycle(a.y, b.y);
/*2022*/    res.z = MyMath.cycle(a.z, b.z);
/*2022*/}
/*2022*/public static void nmCycle(Vec3d a_res, Vec3d b) {
/*2022*/    a_res.x = MyMath.cycle(a_res.x, b.x);
/*2022*/    a_res.y = MyMath.cycle(a_res.y, b.y);
/*2022*/    a_res.z = MyMath.cycle(a_res.z, b.z);
/*2022*/}
/*2022*/public static void nmCycle(Vec3d res, Vec3d a, double b) {
/*2022*/    res.x = MyMath.cycle(a.x, b);
/*2022*/    res.y = MyMath.cycle(a.y, b);
/*2022*/    res.z = MyMath.cycle(a.z, b);
/*2022*/}
/*2022*/public static void nmCycle(Vec3d a_res, double b) {
/*2022*/    a_res.x = MyMath.cycle(a_res.x, b);
/*2022*/    a_res.y = MyMath.cycle(a_res.y, b);
/*2022*/    a_res.z = MyMath.cycle(a_res.z, b);
/*2022*/}
//2022 auto generated text
}