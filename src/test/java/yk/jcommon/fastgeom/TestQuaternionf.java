package yk.jcommon.fastgeom;

import org.junit.Test;

import java.util.function.Consumer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static yk.jcommon.fastgeom.Vec3f.v3;
import static yk.jcommon.utils.Util.PI;

/**
 * Created by Yuri Kravchik on 18/12/16.
 */
public class TestQuaternionf {
    @Test
    public void fromTwoVectors() throws Exception {
        Quaternionf q1 = Quaternionf.fromTwoVectors(v3(1, 0, 0), v3(0, 1, 0));
        assertTrue(q1.rotate(v3(1, 1, 0)).distance(-1, 1, 0) < 0.0001f);
    }

    @Test
    public void testFromAxes() {
        Quaternionf noRot = Quaternionf.fromAxes(
                v3( 1, 0, 0).normalized(),
                v3( 0, 1, 0).normalized(),
                v3( 0, 0, 1).normalized()
        );
        assertNoRot(noRot);

        Quaternionf aroundY = Quaternionf.fromAxes(
                v3( 0, 0, 1).normalized(),
                v3( 0, 1, 0).normalized(),
                v3(-1, 0, 0).normalized()
        );
        assertV(v3(0, 0,-1), aroundY.rotate(v3(1, 0, 0)));
        assertV(v3(0, 1, 0), aroundY.rotate(v3(0, 1, 0)));
        assertV(v3(1, 0, 0), aroundY.rotate(v3(0, 0, 1)));
        assertV(v3(1, 1,-1), aroundY.rotate(v3(1, 1, 1)));

        Quaternionf q1 = Quaternionf.fromAxes(
                v3( 1, 1, 0).normalized(),
                v3(-1, 1, 0).normalized(),
                v3( 0, 0, 1).normalized()
        );
        System.out.println(q1.conjug().rotate(v3(1, 0, 0)));
    }

    @Test
    public void testQToAxesXY() {
        testQToAxes(v3(1, 0, 0), v3(0, 1, 0), q -> assertNoRot(q));
        testQToAxes(v3(0, 0, 1), v3(0, 1, 0), q -> assertYRot90(q));
        testQToAxes(v3(-1, 0, 0), v3(0, 1, 0), q -> assertYRot180(q));
        testQToAxes(v3(1, 0, 0), v3(0, -1, 0), q -> assertXRot180(q));
        testQToAxes(v3(0, 0, 1), v3(0, -1, 0), q -> assertXZRot(q));
    }

    public static void testQToAxes(Vec3f X, Vec3f Y, Consumer<Quaternionf> tester) {
        Vec3f Z = X.crossProduct(Y);

        tester.accept(Quaternionf.qToAxesXY(X.mul(3), Y.mul(0.5f)));
        tester.accept(Quaternionf.qToAxesXY(X.mul(0.5f), Y.mul(3)));

        tester.accept(Quaternionf.qToAxes(X.mul(3), Y.mul(0.5f)));
        tester.accept(Quaternionf.qToAxes(X.mul(0.5f), Y.mul(3)));

        tester.accept(Quaternionf.qToAxesYX(Y, X));
        tester.accept(Quaternionf.qToAxesXZ(X, Z));
        tester.accept(Quaternionf.qToAxesZX(Z, X));
        tester.accept(Quaternionf.qToAxesYZ(Y, Z));
        tester.accept(Quaternionf.qToAxesZY(Z, Y));

        Vec3f nx = X.normalized();
        Vec3f ny = Y.normalized();
        Vec3f nz = Z.normalized();
        tester.accept(Quaternionf.qToAxes(nx.x, nx.y, nx.z, ny.x, ny.y, ny.z, nz.x, nz.y, nz.z));
        tester.accept(Quaternionf.qToAxes(nx, ny, nz));

        tester.accept(Quaternionf.fromAxes(X, Y, X.crossProduct(Y)).conjug());

    }

    private static void assertNoRot(Quaternionf noRot) {
        assertV(v3(1, 0, 0), noRot.rotate(v3(1, 0, 0)));
        assertV(v3(0, 1, 0), noRot.rotate(v3(0, 1, 0)));
        assertV(v3(0, 0, 1), noRot.rotate(v3(0, 0, 1)));
        assertV(v3(1, 1, 1), noRot.rotate(v3(1, 1, 1)));
    }

    private void assertYRot90(Quaternionf arountY) {
        assertV(v3(0, 0, 1), arountY.rotate(v3(1, 0, 0)));
        assertV(v3(0, 1, 0), arountY.rotate(v3(0, 1, 0)));
        assertV(v3(-1, 0, 0), arountY.rotate(v3(0, 0, 1)));
        assertV(v3(-1, 1, 1), arountY.rotate(v3(1, 1, 1)));
    }

    private void assertXRot180(Quaternionf aroundX) {
        assertV(v3(1, 0, 0), aroundX.rotate(v3(1, 0, 0)));
        assertV(v3(0, -1, 0), aroundX.rotate(v3(0, 1, 0)));
        assertV(v3(0, 0, -1), aroundX.rotate(v3(0, 0, 1)));
        assertV(v3(1, -1,-1), aroundX.rotate(v3(1, 1, 1)));
    }

    private void assertXZRot(Quaternionf q) {
        assertV(v3(0, 0, 1), q.rotate(v3(1, 0, 0)));
        assertV(v3(0, -1, 0), q.rotate(v3(0, 1, 0)));
        assertV(v3(1, 0, 0), q.rotate(v3(0, 0, 1)));
        assertV(v3(1, -1,1), q.rotate(v3(1, 1, 1)));
    }

    private void assertYRot180(Quaternionf q) {
        assertV(v3(-1, 0, 0), q.rotate(v3(1, 0, 0)));
        assertV(v3(0, 1, 0), q.rotate(v3(0, 1, 0)));
        assertV(v3(0, 0, -1), q.rotate(v3(0, 0, 1)));
        assertV(v3(-1, 1, -1), q.rotate(v3(1, 1, 1)));
    }

    public static void assertV(Vec3f expected, Vec3f actual) {
        float delta = 0.000001f;
        assertEquals(expected.x, actual.x, delta);
        assertEquals(expected.y, actual.y, delta);
        assertEquals(expected.z, actual.z, delta);
    }

    @Test
    public void angleAxis() {
        assertV(v3(1, 0, 0), Quaternionf.fromAngleAxisFast(PI / 2, new Vec3f(1, 0, 0)).rotate(new Vec3f(1, 0, 0)));
        assertV(v3(0, 0, 1), Quaternionf.fromAngleAxisFast(PI / 2, new Vec3f(1, 0, 0)).rotate(new Vec3f(0, 1, 0)));
        assertV(v3(0, 0, -1), Quaternionf.fromAngleAxisFast(PI / 2, new Vec3f(0, 1, 0)).rotate(new Vec3f(1, 0, 0)));
        assertV(v3(0, 1, 0), Quaternionf.fromAngleAxisFast(PI / 2, new Vec3f(0, 0, 1)).rotate(new Vec3f(1, 0, 0)));

    }
}