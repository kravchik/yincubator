package yk.jcommon.fastgeom;

import yk.jcommon.utils.MyMath;

public class VectorOperationsNoMalloc {
//2022 auto generated text
/*2022*/public static void nmAdd(Vec2i a, Vec2i b, Vec2i res) {
/*2022*/    res.x = a.x + b.x;
/*2022*/    res.y = a.y + b.y;
/*2022*/}
/*2022*/public static void nmAdd(Vec2i a, int b, Vec2i res) {
/*2022*/    res.x = a.x + b;
/*2022*/    res.y = a.y + b;
/*2022*/}
/*2022*/public static void nmSub(Vec2i a, Vec2i b, Vec2i res) {
/*2022*/    res.x = a.x - b.x;
/*2022*/    res.y = a.y - b.y;
/*2022*/}
/*2022*/public static void nmSub(Vec2i a, int b, Vec2i res) {
/*2022*/    res.x = a.x - b;
/*2022*/    res.y = a.y - b;
/*2022*/}
/*2022*/public static void nmMul(Vec2i a, Vec2i b, Vec2i res) {
/*2022*/    res.x = a.x * b.x;
/*2022*/    res.y = a.y * b.y;
/*2022*/}
/*2022*/public static void nmMul(Vec2i a, int b, Vec2i res) {
/*2022*/    res.x = a.x * b;
/*2022*/    res.y = a.y * b;
/*2022*/}
/*2022*/public static void nmDiv(Vec2i a, Vec2i b, Vec2i res) {
/*2022*/    res.x = a.x / b.x;
/*2022*/    res.y = a.y / b.y;
/*2022*/}
/*2022*/public static void nmDiv(Vec2i a, int b, Vec2i res) {
/*2022*/    res.x = a.x / b;
/*2022*/    res.y = a.y / b;
/*2022*/}
/*2022*/public static void nmMin(Vec2i v1, Vec2i v2, Vec2i res) {
/*2022*/    res.x = MyMath.min(v1.x, v2.x);
/*2022*/    res.y = MyMath.min(v1.y, v2.y);
/*2022*/}
/*2022*/public static void nmMax(Vec2i v1, Vec2i v2, Vec2i res) {
/*2022*/    res.x = MyMath.max(v1.x, v2.x);
/*2022*/    res.y = MyMath.max(v1.y, v2.y);
/*2022*/}
/*2022*/public static void nmCycle(Vec2i v1, Vec2i v2, Vec2i res) {
/*2022*/    res.x = MyMath.cycle(v1.x, v2.x);
/*2022*/    res.y = MyMath.cycle(v1.y, v2.y);
/*2022*/}
/*2022*/public static void nmAdd(Vec3i a, Vec3i b, Vec3i res) {
/*2022*/    res.x = a.x + b.x;
/*2022*/    res.y = a.y + b.y;
/*2022*/    res.z = a.z + b.z;
/*2022*/}
/*2022*/public static void nmAdd(Vec3i a, int b, Vec3i res) {
/*2022*/    res.x = a.x + b;
/*2022*/    res.y = a.y + b;
/*2022*/    res.z = a.z + b;
/*2022*/}
/*2022*/public static void nmSub(Vec3i a, Vec3i b, Vec3i res) {
/*2022*/    res.x = a.x - b.x;
/*2022*/    res.y = a.y - b.y;
/*2022*/    res.z = a.z - b.z;
/*2022*/}
/*2022*/public static void nmSub(Vec3i a, int b, Vec3i res) {
/*2022*/    res.x = a.x - b;
/*2022*/    res.y = a.y - b;
/*2022*/    res.z = a.z - b;
/*2022*/}
/*2022*/public static void nmMul(Vec3i a, Vec3i b, Vec3i res) {
/*2022*/    res.x = a.x * b.x;
/*2022*/    res.y = a.y * b.y;
/*2022*/    res.z = a.z * b.z;
/*2022*/}
/*2022*/public static void nmMul(Vec3i a, int b, Vec3i res) {
/*2022*/    res.x = a.x * b;
/*2022*/    res.y = a.y * b;
/*2022*/    res.z = a.z * b;
/*2022*/}
/*2022*/public static void nmDiv(Vec3i a, Vec3i b, Vec3i res) {
/*2022*/    res.x = a.x / b.x;
/*2022*/    res.y = a.y / b.y;
/*2022*/    res.z = a.z / b.z;
/*2022*/}
/*2022*/public static void nmDiv(Vec3i a, int b, Vec3i res) {
/*2022*/    res.x = a.x / b;
/*2022*/    res.y = a.y / b;
/*2022*/    res.z = a.z / b;
/*2022*/}
/*2022*/public static void nmMin(Vec3i v1, Vec3i v2, Vec3i res) {
/*2022*/    res.x = MyMath.min(v1.x, v2.x);
/*2022*/    res.y = MyMath.min(v1.y, v2.y);
/*2022*/    res.z = MyMath.min(v1.z, v2.z);
/*2022*/}
/*2022*/public static void nmMax(Vec3i v1, Vec3i v2, Vec3i res) {
/*2022*/    res.x = MyMath.max(v1.x, v2.x);
/*2022*/    res.y = MyMath.max(v1.y, v2.y);
/*2022*/    res.z = MyMath.max(v1.z, v2.z);
/*2022*/}
/*2022*/public static void nmCycle(Vec3i v1, Vec3i v2, Vec3i res) {
/*2022*/    res.x = MyMath.cycle(v1.x, v2.x);
/*2022*/    res.y = MyMath.cycle(v1.y, v2.y);
/*2022*/    res.z = MyMath.cycle(v1.z, v2.z);
/*2022*/}
/*2022*/public static void nmAdd(Vec4i a, Vec4i b, Vec4i res) {
/*2022*/    res.x = a.x + b.x;
/*2022*/    res.y = a.y + b.y;
/*2022*/    res.z = a.z + b.z;
/*2022*/    res.w = a.w + b.w;
/*2022*/}
/*2022*/public static void nmAdd(Vec4i a, int b, Vec4i res) {
/*2022*/    res.x = a.x + b;
/*2022*/    res.y = a.y + b;
/*2022*/    res.z = a.z + b;
/*2022*/    res.w = a.w + b;
/*2022*/}
/*2022*/public static void nmSub(Vec4i a, Vec4i b, Vec4i res) {
/*2022*/    res.x = a.x - b.x;
/*2022*/    res.y = a.y - b.y;
/*2022*/    res.z = a.z - b.z;
/*2022*/    res.w = a.w - b.w;
/*2022*/}
/*2022*/public static void nmSub(Vec4i a, int b, Vec4i res) {
/*2022*/    res.x = a.x - b;
/*2022*/    res.y = a.y - b;
/*2022*/    res.z = a.z - b;
/*2022*/    res.w = a.w - b;
/*2022*/}
/*2022*/public static void nmMul(Vec4i a, Vec4i b, Vec4i res) {
/*2022*/    res.x = a.x * b.x;
/*2022*/    res.y = a.y * b.y;
/*2022*/    res.z = a.z * b.z;
/*2022*/    res.w = a.w * b.w;
/*2022*/}
/*2022*/public static void nmMul(Vec4i a, int b, Vec4i res) {
/*2022*/    res.x = a.x * b;
/*2022*/    res.y = a.y * b;
/*2022*/    res.z = a.z * b;
/*2022*/    res.w = a.w * b;
/*2022*/}
/*2022*/public static void nmDiv(Vec4i a, Vec4i b, Vec4i res) {
/*2022*/    res.x = a.x / b.x;
/*2022*/    res.y = a.y / b.y;
/*2022*/    res.z = a.z / b.z;
/*2022*/    res.w = a.w / b.w;
/*2022*/}
/*2022*/public static void nmDiv(Vec4i a, int b, Vec4i res) {
/*2022*/    res.x = a.x / b;
/*2022*/    res.y = a.y / b;
/*2022*/    res.z = a.z / b;
/*2022*/    res.w = a.w / b;
/*2022*/}
/*2022*/public static void nmFloor(Vec4i v, Vec4i res) {
/*2022*/    res.x = MyMath.floorFast(v.x);
/*2022*/    res.y = MyMath.floorFast(v.y);
/*2022*/    res.z = MyMath.floorFast(v.z);
/*2022*/    res.w = MyMath.floorFast(v.w);
/*2022*/}
/*2022*/public static void nmMin(Vec4i v1, Vec4i v2, Vec4i res) {
/*2022*/    res.x = MyMath.min(v1.x, v2.x);
/*2022*/    res.y = MyMath.min(v1.y, v2.y);
/*2022*/    res.z = MyMath.min(v1.z, v2.z);
/*2022*/    res.w = MyMath.min(v1.w, v2.w);
/*2022*/}
/*2022*/public static void nmMax(Vec4i v1, Vec4i v2, Vec4i res) {
/*2022*/    res.x = MyMath.max(v1.x, v2.x);
/*2022*/    res.y = MyMath.max(v1.y, v2.y);
/*2022*/    res.z = MyMath.max(v1.z, v2.z);
/*2022*/    res.w = MyMath.max(v1.w, v2.w);
/*2022*/}
/*2022*/public static void nmCycle(Vec4i v1, Vec4i v2, Vec4i res) {
/*2022*/    res.x = MyMath.cycle(v1.x, v2.x);
/*2022*/    res.y = MyMath.cycle(v1.y, v2.y);
/*2022*/    res.z = MyMath.cycle(v1.z, v2.z);
/*2022*/    res.w = MyMath.cycle(v1.w, v2.w);
/*2022*/}
/*2022*/public static void nmAdd(Vec2f a, Vec2f b, Vec2f res) {
/*2022*/    res.x = a.x + b.x;
/*2022*/    res.y = a.y + b.y;
/*2022*/}
/*2022*/public static void nmAdd(Vec2f a, float b, Vec2f res) {
/*2022*/    res.x = a.x + b;
/*2022*/    res.y = a.y + b;
/*2022*/}
/*2022*/public static void nmSub(Vec2f a, Vec2f b, Vec2f res) {
/*2022*/    res.x = a.x - b.x;
/*2022*/    res.y = a.y - b.y;
/*2022*/}
/*2022*/public static void nmSub(Vec2f a, float b, Vec2f res) {
/*2022*/    res.x = a.x - b;
/*2022*/    res.y = a.y - b;
/*2022*/}
/*2022*/public static void nmMul(Vec2f a, Vec2f b, Vec2f res) {
/*2022*/    res.x = a.x * b.x;
/*2022*/    res.y = a.y * b.y;
/*2022*/}
/*2022*/public static void nmMul(Vec2f a, float b, Vec2f res) {
/*2022*/    res.x = a.x * b;
/*2022*/    res.y = a.y * b;
/*2022*/}
/*2022*/public static void nmDiv(Vec2f a, Vec2f b, Vec2f res) {
/*2022*/    res.x = a.x / b.x;
/*2022*/    res.y = a.y / b.y;
/*2022*/}
/*2022*/public static void nmDiv(Vec2f a, float b, Vec2f res) {
/*2022*/    res.x = a.x / b;
/*2022*/    res.y = a.y / b;
/*2022*/}
/*2022*/public static void nmFloor(Vec2f v, Vec2f res) {
/*2022*/    res.x = MyMath.floorFast(v.x);
/*2022*/    res.y = MyMath.floorFast(v.y);
/*2022*/}
/*2022*/public static void nmMin(Vec2f v1, Vec2f v2, Vec2f res) {
/*2022*/    res.x = MyMath.min(v1.x, v2.x);
/*2022*/    res.y = MyMath.min(v1.y, v2.y);
/*2022*/}
/*2022*/public static void nmMax(Vec2f v1, Vec2f v2, Vec2f res) {
/*2022*/    res.x = MyMath.max(v1.x, v2.x);
/*2022*/    res.y = MyMath.max(v1.y, v2.y);
/*2022*/}
/*2022*/public static void nmCycle(Vec2f v1, Vec2f v2, Vec2f res) {
/*2022*/    res.x = MyMath.cycle(v1.x, v2.x);
/*2022*/    res.y = MyMath.cycle(v1.y, v2.y);
/*2022*/}
/*2022*/public static void nmAdd(Vec3f a, Vec3f b, Vec3f res) {
/*2022*/    res.x = a.x + b.x;
/*2022*/    res.y = a.y + b.y;
/*2022*/    res.z = a.z + b.z;
/*2022*/}
/*2022*/public static void nmAdd(Vec3f a, float b, Vec3f res) {
/*2022*/    res.x = a.x + b;
/*2022*/    res.y = a.y + b;
/*2022*/    res.z = a.z + b;
/*2022*/}
/*2022*/public static void nmSub(Vec3f a, Vec3f b, Vec3f res) {
/*2022*/    res.x = a.x - b.x;
/*2022*/    res.y = a.y - b.y;
/*2022*/    res.z = a.z - b.z;
/*2022*/}
/*2022*/public static void nmSub(Vec3f a, float b, Vec3f res) {
/*2022*/    res.x = a.x - b;
/*2022*/    res.y = a.y - b;
/*2022*/    res.z = a.z - b;
/*2022*/}
/*2022*/public static void nmMul(Vec3f a, Vec3f b, Vec3f res) {
/*2022*/    res.x = a.x * b.x;
/*2022*/    res.y = a.y * b.y;
/*2022*/    res.z = a.z * b.z;
/*2022*/}
/*2022*/public static void nmMul(Vec3f a, float b, Vec3f res) {
/*2022*/    res.x = a.x * b;
/*2022*/    res.y = a.y * b;
/*2022*/    res.z = a.z * b;
/*2022*/}
/*2022*/public static void nmDiv(Vec3f a, Vec3f b, Vec3f res) {
/*2022*/    res.x = a.x / b.x;
/*2022*/    res.y = a.y / b.y;
/*2022*/    res.z = a.z / b.z;
/*2022*/}
/*2022*/public static void nmDiv(Vec3f a, float b, Vec3f res) {
/*2022*/    res.x = a.x / b;
/*2022*/    res.y = a.y / b;
/*2022*/    res.z = a.z / b;
/*2022*/}
/*2022*/public static void nmFloor(Vec3f v, Vec3f res) {
/*2022*/    res.x = MyMath.floorFast(v.x);
/*2022*/    res.y = MyMath.floorFast(v.y);
/*2022*/    res.z = MyMath.floorFast(v.z);
/*2022*/}
/*2022*/public static void nmMin(Vec3f v1, Vec3f v2, Vec3f res) {
/*2022*/    res.x = MyMath.min(v1.x, v2.x);
/*2022*/    res.y = MyMath.min(v1.y, v2.y);
/*2022*/    res.z = MyMath.min(v1.z, v2.z);
/*2022*/}
/*2022*/public static void nmMax(Vec3f v1, Vec3f v2, Vec3f res) {
/*2022*/    res.x = MyMath.max(v1.x, v2.x);
/*2022*/    res.y = MyMath.max(v1.y, v2.y);
/*2022*/    res.z = MyMath.max(v1.z, v2.z);
/*2022*/}
/*2022*/public static void nmCycle(Vec3f v1, Vec3f v2, Vec3f res) {
/*2022*/    res.x = MyMath.cycle(v1.x, v2.x);
/*2022*/    res.y = MyMath.cycle(v1.y, v2.y);
/*2022*/    res.z = MyMath.cycle(v1.z, v2.z);
/*2022*/}
/*2022*/public static void nmAdd(Vec4f a, Vec4f b, Vec4f res) {
/*2022*/    res.x = a.x + b.x;
/*2022*/    res.y = a.y + b.y;
/*2022*/    res.z = a.z + b.z;
/*2022*/    res.w = a.w + b.w;
/*2022*/}
/*2022*/public static void nmAdd(Vec4f a, float b, Vec4f res) {
/*2022*/    res.x = a.x + b;
/*2022*/    res.y = a.y + b;
/*2022*/    res.z = a.z + b;
/*2022*/    res.w = a.w + b;
/*2022*/}
/*2022*/public static void nmSub(Vec4f a, Vec4f b, Vec4f res) {
/*2022*/    res.x = a.x - b.x;
/*2022*/    res.y = a.y - b.y;
/*2022*/    res.z = a.z - b.z;
/*2022*/    res.w = a.w - b.w;
/*2022*/}
/*2022*/public static void nmSub(Vec4f a, float b, Vec4f res) {
/*2022*/    res.x = a.x - b;
/*2022*/    res.y = a.y - b;
/*2022*/    res.z = a.z - b;
/*2022*/    res.w = a.w - b;
/*2022*/}
/*2022*/public static void nmMul(Vec4f a, Vec4f b, Vec4f res) {
/*2022*/    res.x = a.x * b.x;
/*2022*/    res.y = a.y * b.y;
/*2022*/    res.z = a.z * b.z;
/*2022*/    res.w = a.w * b.w;
/*2022*/}
/*2022*/public static void nmMul(Vec4f a, float b, Vec4f res) {
/*2022*/    res.x = a.x * b;
/*2022*/    res.y = a.y * b;
/*2022*/    res.z = a.z * b;
/*2022*/    res.w = a.w * b;
/*2022*/}
/*2022*/public static void nmDiv(Vec4f a, Vec4f b, Vec4f res) {
/*2022*/    res.x = a.x / b.x;
/*2022*/    res.y = a.y / b.y;
/*2022*/    res.z = a.z / b.z;
/*2022*/    res.w = a.w / b.w;
/*2022*/}
/*2022*/public static void nmDiv(Vec4f a, float b, Vec4f res) {
/*2022*/    res.x = a.x / b;
/*2022*/    res.y = a.y / b;
/*2022*/    res.z = a.z / b;
/*2022*/    res.w = a.w / b;
/*2022*/}
/*2022*/public static void nmFloor(Vec4f v, Vec4f res) {
/*2022*/    res.x = MyMath.floorFast(v.x);
/*2022*/    res.y = MyMath.floorFast(v.y);
/*2022*/    res.z = MyMath.floorFast(v.z);
/*2022*/    res.w = MyMath.floorFast(v.w);
/*2022*/}
/*2022*/public static void nmMin(Vec4f v1, Vec4f v2, Vec4f res) {
/*2022*/    res.x = MyMath.min(v1.x, v2.x);
/*2022*/    res.y = MyMath.min(v1.y, v2.y);
/*2022*/    res.z = MyMath.min(v1.z, v2.z);
/*2022*/    res.w = MyMath.min(v1.w, v2.w);
/*2022*/}
/*2022*/public static void nmMax(Vec4f v1, Vec4f v2, Vec4f res) {
/*2022*/    res.x = MyMath.max(v1.x, v2.x);
/*2022*/    res.y = MyMath.max(v1.y, v2.y);
/*2022*/    res.z = MyMath.max(v1.z, v2.z);
/*2022*/    res.w = MyMath.max(v1.w, v2.w);
/*2022*/}
/*2022*/public static void nmCycle(Vec4f v1, Vec4f v2, Vec4f res) {
/*2022*/    res.x = MyMath.cycle(v1.x, v2.x);
/*2022*/    res.y = MyMath.cycle(v1.y, v2.y);
/*2022*/    res.z = MyMath.cycle(v1.z, v2.z);
/*2022*/    res.w = MyMath.cycle(v1.w, v2.w);
/*2022*/}
//2022 auto generated text
}