package yk.jcommon.fastgeom;

import java.nio.FloatBuffer;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: yuri
 * Date: 06/01/15
 * Time: 19:26
 */
public class Matrix4 {
    private static final int S = 4;
    public float[] data = new float[S * S];

    public static Matrix4 identity() {
        return new Matrix4().setIdentity();
    }

    public static Matrix4 zero() {
        return new Matrix4();
    }

    public static Matrix4 scale(float x, float y, float z) {
        Matrix4 result = identity();
        result.set(0, 0, x);
        result.set(1, 1, y);
        result.set(2, 2, z);
        return result;
    }

    public static Matrix4 scale(float s) {
        Matrix4 result = identity();
        result.set(0, 0, s);
        result.set(1, 1, s);
        result.set(2, 2, s);
        return result;
    }

    @Deprecated
    public Matrix4() {
    }

    public void set(int i, int j, float d) {//TODO from 1
        data[i * 4 + j] = d;
    }

    public float get(int i, int j) {
        return data[i * 4 + j];
    }

    public static Matrix4 setIdentity(Matrix4 m) {
        m.data[0] = 1.0f;m.data[1] = 0.0f;m.data[2] = 0.0f;m.data[3] = 0.0f;
        m.data[4] = 0.0f;m.data[5] = 1.0f;m.data[6] = 0.0f;m.data[7] = 0.0f;
        m.data[8] = 0.0f;m.data[9] = 0.0f;m.data[10] = 1.0f;m.data[11] = 0.0f;
        m.data[12] = 0.0f;m.data[13] = 0.0f;m.data[14] = 0.0f;m.data[15] = 1.0f;
        return m;
    }

    public Matrix4 setIdentity() {
        return setIdentity(this);
    }

    public Matrix4 store(FloatBuffer buf) {
        buf.put(data);
        return this;
    }

    public Matrix4 multiply(Matrix4 by) {
        Matrix4 result = Matrix4.zero();
        seMultiply(this, by, result);
        //for (int i = 0; i < 4; i++) {
        //    for (int j = 0; j < 4; j++) {
        //        float r = 0;
        //        for (int k = 0; k < 4; k++) r += get(k, i) * by.get(j, k);
        //        result.set(j, i, r);
        //    }
        //}
        return result;
    }

    public void seMultiply(Matrix4 by, Matrix4 result) {
        seMultiply(this, by, result);
    }

    public static void seMultiply(Matrix4 a, Matrix4 b, Matrix4 result) {
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 4; j++) {
//                float r = 0;
//                for (int k = 0; k < 4; k++) r += a.get(k, i) * b.get(j, k);
//                result.set(j, i, r);
//            }
//        }
        //optimized
        float r0 = 0;
        r0 = (r0 + (a.data[0] * b.data[0]));r0 = (r0 + (a.data[4] * b.data[1]));r0 = (r0 + (a.data[8] * b.data[2]));r0 = (r0 + (a.data[12] * b.data[3]));
        float r4 = 0;
        r4 = (r4 + (a.data[0] * b.data[4]));r4 = (r4 + (a.data[4] * b.data[5]));r4 = (r4 + (a.data[8] * b.data[6]));r4 = (r4 + (a.data[12] * b.data[7]));
        float r8 = 0;
        r8 = (r8 + (a.data[0] * b.data[8]));r8 = (r8 + (a.data[4] * b.data[9]));r8 = (r8 + (a.data[8] * b.data[10]));r8 = (r8 + (a.data[12] * b.data[11]));
        float r12 = 0;
        r12 = (r12 + (a.data[0] * b.data[12]));r12 = (r12 + (a.data[4] * b.data[13]));r12 = (r12 + (a.data[8] * b.data[14]));r12 = (r12 + (a.data[12] * b.data[15]));
        float r1 = 0;
        r1 = (r1 + (a.data[1] * b.data[0]));r1 = (r1 + (a.data[5] * b.data[1]));r1 = (r1 + (a.data[9] * b.data[2]));r1 = (r1 + (a.data[13] * b.data[3]));
        float r5 = 0;
        r5 = (r5 + (a.data[1] * b.data[4]));r5 = (r5 + (a.data[5] * b.data[5]));r5 = (r5 + (a.data[9] * b.data[6]));r5 = (r5 + (a.data[13] * b.data[7]));
        float r9 = 0;
        r9 = (r9 + (a.data[1] * b.data[8]));r9 = (r9 + (a.data[5] * b.data[9]));r9 = (r9 + (a.data[9] * b.data[10]));r9 = (r9 + (a.data[13] * b.data[11]));
        float r13 = 0;
        r13 = (r13 + (a.data[1] * b.data[12]));r13 = (r13 + (a.data[5] * b.data[13]));r13 = (r13 + (a.data[9] * b.data[14]));r13 = (r13 + (a.data[13] * b.data[15]));
        float r2 = 0;
        r2 = (r2 + (a.data[2] * b.data[0]));r2 = (r2 + (a.data[6] * b.data[1]));r2 = (r2 + (a.data[10] * b.data[2]));r2 = (r2 + (a.data[14] * b.data[3]));
        float r6 = 0;
        r6 = (r6 + (a.data[2] * b.data[4]));r6 = (r6 + (a.data[6] * b.data[5]));r6 = (r6 + (a.data[10] * b.data[6]));r6 = (r6 + (a.data[14] * b.data[7]));
        float r10 = 0;
        r10 = (r10 + (a.data[2] * b.data[8]));r10 = (r10 + (a.data[6] * b.data[9]));r10 = (r10 + (a.data[10] * b.data[10]));r10 = (r10 + (a.data[14] * b.data[11]));
        float r14 = 0;
        r14 = (r14 + (a.data[2] * b.data[12]));r14 = (r14 + (a.data[6] * b.data[13]));r14 = (r14 + (a.data[10] * b.data[14]));r14 = (r14 + (a.data[14] * b.data[15]));
        float r3 = 0;
        r3 = (r3 + (a.data[3] * b.data[0]));r3 = (r3 + (a.data[7] * b.data[1]));r3 = (r3 + (a.data[11] * b.data[2]));r3 = (r3 + (a.data[15] * b.data[3]));
        float r7 = 0;
        r7 = (r7 + (a.data[3] * b.data[4]));r7 = (r7 + (a.data[7] * b.data[5]));r7 = (r7 + (a.data[11] * b.data[6]));r7 = (r7 + (a.data[15] * b.data[7]));
        float r11 = 0;
        r11 = (r11 + (a.data[3] * b.data[8]));r11 = (r11 + (a.data[7] * b.data[9]));r11 = (r11 + (a.data[11] * b.data[10]));r11 = (r11 + (a.data[15] * b.data[11]));

        //TODO better optimization output
        //float r15 = 0;
        //r15 = (r15 + (a.data[3] * b.data[12]));r15 = (r15 + (a.data[7] * b.data[13]));r15 = (r15 + (a.data[11] * b.data[14]));r15 = (r15 + (a.data[15] * b.data[15]));
        float r15 = 0f + a.data[3] * b.data[12] + a.data[7] * b.data[13] + a.data[11] * b.data[14] + a.data[15] * b.data[15];

        result.data[0] = r0;
        result.data[4] = r4;
        result.data[8] = r8;
        result.data[12] = r12;
        result.data[1] = r1;
        result.data[5] = r5;
        result.data[9] = r9;
        result.data[13] = r13;
        result.data[2] = r2;
        result.data[6] = r6;
        result.data[10] = r10;
        result.data[14] = r14;
        result.data[3] = r3;
        result.data[7] = r7;
        result.data[11] = r11;
        result.data[15] = r15;
    }

    public static void copy(Matrix4 from, Matrix4 to) {
        for (int i = 0; i < from.data.length; i++) {
            to.data[i] = from.data[i];
        }
    }

    public Matrix4 translate(Vec3f v) {
        Matrix4 result = Matrix4.zero();
        result.copyFrom(this);
//        System.arraycopy(data, 0, result.data, 0, data.length);
        result.set(3, 0, result.get(3, 0) + v.x);
        result.set(3, 1, result.get(3, 1) + v.y);
        result.set(3, 2, result.get(3, 2) + v.z);
        return result;
    }

    public void translateSe(Vec3f v) {
        set(3, 0, get(3, 0) + v.x);
        set(3, 1, get(3, 1) + v.y);
        set(3, 2, get(3, 2) + v.z);
    }

    public void setTranslation(Vec3f v) {
        set(3, 0, v.x);
        set(3, 1, v.y);
        set(3, 2, v.z);
    }

    public void copyFrom(Matrix4 other) {
        for (int i = 0; i < data.length; i++) data[i] = other.data[i];
    }

    public static Matrix4 ortho(float l, float r, float b, float t, float n, float f) {
        Matrix4 result = Matrix4.zero();
        result.set(0, 0, 2/(r-l));
        result.set(1, 1, 2/(t-b));
        result.set(2, 2, -2/(f-n));
        result.set(3, 3, 1);

        result.set(3, 0, -(r+l)/(r-l));
        result.set(3, 1, -(t+b)/(t-b));
        result.set(3, 2, -(f+n)/(f-n));
        return result;
    }

    public static Matrix4 orthoPixel(float l, float r, float b, float t, float n, float f) {
        Matrix4 result = Matrix4.zero();
        result.set(0, 0, 2/(r-l));
        result.set(1, 1, 2/(t-b));
        result.set(2, 2, -2/(f-n));
        result.set(3, 3, 1);

        result.set(3, 0, -(r+l-1)/(r-l));//-1 is to make pixel coordinates [0, w) instead of (0, w]
        result.set(3, 1, -(t+b-1)/(t-b));
        result.set(3, 2, -(f+n)/(f-n));
        return result;
    }

    public static Matrix4 perspective(float fovy, float aspect, float zNear, float zFar) {
        float sine, cotangent, deltaZ;
        float radians = fovy / 2 * (float) Math.PI / 180;

        deltaZ = zFar - zNear;
        sine = (float) Math.sin(radians);

        if ((deltaZ == 0) || (sine == 0) || (aspect == 0)) return null;

        cotangent = (float) Math.cos(radians) / sine;

        Matrix4 result = Matrix4.zero();
        result.set(0, 0, cotangent / aspect);
        result.set(1, 1, cotangent);
        result.set(2, 2, -(zFar + zNear) / deltaZ);
        result.set(2, 3, -1);
        result.set(3, 2, -2 * zNear * zFar / deltaZ);
        //result.set(3, 3, 0);

        return result;
        //matrix.put(0 * 4 + 0, cotangent / aspect);
        //matrix.put(1 * 4 + 1, cotangent);
        //matrix.put(2 * 4 + 2, - (zFar + zNear) / deltaZ);
        //matrix.put(2 * 4 + 3, -1);
        //matrix.put(3 * 4 + 2, -2 * zNear * zFar / deltaZ);
        //matrix.put(3 * 4 + 3, 0);

    }

    public Matrix4 invert() {
        Matrix4 result = new Matrix4();
        if (!gluInvertMatrix(data, result.data)) throw new RuntimeException("can't invert matrix");
        return result;
    }

    private boolean gluInvertMatrix(float m[], float invOut[])//http://stackoverflow.com/questions/1148309/inverting-a-4x4-matrix
    {
        float inv[] = new float[16], det;
        int i;

        inv[0] = m[5] * m[10] * m[15] -
                m[5] * m[11] * m[14] -
                m[9] * m[6] * m[15] +
                m[9] * m[7] * m[14] +
                m[13] * m[6] * m[11] -
                m[13] * m[7] * m[10];

        inv[4] = -m[4] * m[10] * m[15] +
                m[4] * m[11] * m[14] +
                m[8] * m[6] * m[15] -
                m[8] * m[7] * m[14] -
                m[12] * m[6] * m[11] +
                m[12] * m[7] * m[10];

        inv[8] = m[4] * m[9] * m[15] -
                m[4] * m[11] * m[13] -
                m[8] * m[5] * m[15] +
                m[8] * m[7] * m[13] +
                m[12] * m[5] * m[11] -
                m[12] * m[7] * m[9];

        inv[12] = -m[4] * m[9] * m[14] +
                m[4] * m[10] * m[13] +
                m[8] * m[5] * m[14] -
                m[8] * m[6] * m[13] -
                m[12] * m[5] * m[10] +
                m[12] * m[6] * m[9];

        inv[1] = -m[1] * m[10] * m[15] +
                m[1] * m[11] * m[14] +
                m[9] * m[2] * m[15] -
                m[9] * m[3] * m[14] -
                m[13] * m[2] * m[11] +
                m[13] * m[3] * m[10];

        inv[5] = m[0] * m[10] * m[15] -
                m[0] * m[11] * m[14] -
                m[8] * m[2] * m[15] +
                m[8] * m[3] * m[14] +
                m[12] * m[2] * m[11] -
                m[12] * m[3] * m[10];

        inv[9] = -m[0] * m[9] * m[15] +
                m[0] * m[11] * m[13] +
                m[8] * m[1] * m[15] -
                m[8] * m[3] * m[13] -
                m[12] * m[1] * m[11] +
                m[12] * m[3] * m[9];

        inv[13] = m[0] * m[9] * m[14] -
                m[0] * m[10] * m[13] -
                m[8] * m[1] * m[14] +
                m[8] * m[2] * m[13] +
                m[12] * m[1] * m[10] -
                m[12] * m[2] * m[9];

        inv[2] = m[1] * m[6] * m[15] -
                m[1] * m[7] * m[14] -
                m[5] * m[2] * m[15] +
                m[5] * m[3] * m[14] +
                m[13] * m[2] * m[7] -
                m[13] * m[3] * m[6];

        inv[6] = -m[0] * m[6] * m[15] +
                m[0] * m[7] * m[14] +
                m[4] * m[2] * m[15] -
                m[4] * m[3] * m[14] -
                m[12] * m[2] * m[7] +
                m[12] * m[3] * m[6];

        inv[10] = m[0] * m[5] * m[15] -
                m[0] * m[7] * m[13] -
                m[4] * m[1] * m[15] +
                m[4] * m[3] * m[13] +
                m[12] * m[1] * m[7] -
                m[12] * m[3] * m[5];

        inv[14] = -m[0] * m[5] * m[14] +
                m[0] * m[6] * m[13] +
                m[4] * m[1] * m[14] -
                m[4] * m[2] * m[13] -
                m[12] * m[1] * m[6] +
                m[12] * m[2] * m[5];

        inv[3] = -m[1] * m[6] * m[11] +
                m[1] * m[7] * m[10] +
                m[5] * m[2] * m[11] -
                m[5] * m[3] * m[10] -
                m[9] * m[2] * m[7] +
                m[9] * m[3] * m[6];

        inv[7] = m[0] * m[6] * m[11] -
                m[0] * m[7] * m[10] -
                m[4] * m[2] * m[11] +
                m[4] * m[3] * m[10] +
                m[8] * m[2] * m[7] -
                m[8] * m[3] * m[6];

        inv[11] = -m[0] * m[5] * m[11] +
                m[0] * m[7] * m[9] +
                m[4] * m[1] * m[11] -
                m[4] * m[3] * m[9] -
                m[8] * m[1] * m[7] +
                m[8] * m[3] * m[5];

        inv[15] = m[0] * m[5] * m[10] -
                m[0] * m[6] * m[9] -
                m[4] * m[1] * m[10] +
                m[4] * m[2] * m[9] +
                m[8] * m[1] * m[6] -
                m[8] * m[2] * m[5];

        det = m[0] * inv[0] + m[1] * inv[4] + m[2] * inv[8] + m[3] * inv[12];

        if (det == 0)
            return false;

        det = 1f / det;

        for (i = 0; i < 16; i++)
            invOut[i] = inv[i] * det;

        return true;
    }

    //http://www.java2s.com/Code/Java/2D-Graphics-GUI/A3x3matriximplementation.htm
    ///**
    // * Compute the inverse of the matrix A, place the result in C
    // */
    //public static Matrix3 inverse( final Matrix3 A, final Matrix3 C ) {
    //    double d = (A.a31*A.a12*A.a23-A.a31*A.a13*A.a22-A.a21*A.a12*A.a33+A.a21*A.a13*A.a32+A.a11*A.a22*A.a33-A.a11*A.a23*A.a32);
    //    double t11 =  (A.a22*A.a33-A.a23*A.a32)/d;
    //    double t12 = -(A.a12*A.a33-A.a13*A.a32)/d;
    //    double t13 =  (A.a12*A.a23-A.a13*A.a22)/d;
    //    double t21 = -(-A.a31*A.a23+A.a21*A.a33)/d;
    //    double t22 =  (-A.a31*A.a13+A.a11*A.a33)/d;
    //    double t23 = -(-A.a21*A.a13+A.a11*A.a23)/d;
    //    double t31 =  (-A.a31*A.a22+A.a21*A.a32)/d;
    //    double t32 = -(-A.a31*A.a12+A.a11*A.a32)/d;
    //    double t33 =  (-A.a21*A.a12+A.a11*A.a22)/d;
    //
    //    C.a11 = t11; C.a12 = t12; C.a13 = t13;
    //    C.a21 = t21; C.a22 = t22; C.a23 = t23;
    //    C.a31 = t31; C.a32 = t32; C.a33 = t33;
    //    return C;
    //}

    public Matrix3 get33() {
        Matrix3 result = new Matrix3();
        for (int i = 1; i <= 3; i++) for (int j = 1; j <= 3; j++) result.set(i, j, get(i - 1, j - 1));
        return result;
    }

    public Matrix4 transpose() {
        Matrix4 result = new Matrix4();
        for (int i = 0; i < S; i++) for (int j = 0; j < S; j++) result.set(j, i, get(i, j));
        return result;
    }


    public Vec4f multiply(Vec4f v) {
        return Vec4f.v4(v.x * get(0, 0) + v.y * get(1, 0) + v.z * get(2, 0) + v.w * get(3, 0),
                        v.x * get(0, 1) + v.y * get(1, 1) + v.z * get(2, 1) + v.w * get(3, 1),
                        v.x * get(0, 2) + v.y * get(1, 2) + v.z * get(2, 2) + v.w * get(3, 2),
                        v.x * get(0, 3) + v.y * get(1, 3) + v.z * get(2, 3) + v.w * get(3, 3)
        );

    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }
}