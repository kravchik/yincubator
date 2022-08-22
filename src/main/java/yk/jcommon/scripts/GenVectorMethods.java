package yk.jcommon.scripts;

import yk.jcommon.collections.YList;
import yk.jcommon.collections.YMap;
import yk.jcommon.collections.YSet;
import yk.jcommon.utils.IO;
import yk.jcommon.utils.Tab;
import yk.jcommon.utils.Util;

import static java.lang.String.format;
import static yk.jcommon.collections.YArrayList.al;
import static yk.jcommon.collections.YCollections.zip;
import static yk.jcommon.collections.YHashMap.hm;
import static yk.jcommon.collections.YHashSet.hs;

public class GenVectorMethods {

    public static YMap<String, String> classToFile = hm(
            "Vec2f", "src/main/java/yk/jcommon/fastgeom/Vec2f.java",
            "Vec2i", "src/main/java/yk/jcommon/fastgeom/Vec2i.java",
            "Vec4i", "src/main/java/yk/jcommon/fastgeom/Vec4i.java",
            "Vec3f", "src/main/java/yk/jcommon/fastgeom/Vec3f.java",
            "Vec3i", "src/main/java/yk/jcommon/fastgeom/Vec3i.java",
            "Vec4f", "src/main/java/yk/jcommon/fastgeom/Vec4f.java"
    );

    public static YMap<String, YList<String>> classToFields = hm(
            "Vec2i", al("x", "y"),
            "Vec3i", al("x", "y", "z"),
            "Vec4i", al("x", "y", "z", "w"),
            "Vec2f", al("x", "y"),
            "Vec3f", al("x", "y", "z"),
            "Vec4f", al("x", "y", "z", "w")
    );

    public static YMap<String, String> classToScalar = hm(
            "Vec2i", "int",
            "Vec3i", "int",
            "Vec4i", "int",
            "Vec2f", "float",
            "Vec3f", "float",
            "Vec4f", "float"
    );

    public static YMap<String, YList<String>> classToOtherFields = classToFields.map((k, v) -> v.map(vv -> "other." + vv));

    public static YMap<String, String> methodToOp = hm(
            "add", "+",
            //"plus", "+",
            "sub", "-",
            //"minus", "-",
            "mul", "*",
            //"multiply", "*",
            "div", "/"
    );

    public static YMap<String, String> methodTo0Fun = hm(
            "floor", "MyMath.floorFast"
    );

    public static YMap<String, YSet<String>> classToMethodSkip = hm(
            "Vec2i", hs("floor"),
            "Vec3i", hs("floor")
    );

    public static YMap<String, String> methodTo1Fun = hm(
            "min", "MyMath.min",
            "max", "MyMath.max",
            "cycle", "MyMath.cycle"
    );

    public static YMap<String, String> methodTo2Fun = hm(
            "clamp", "MyMath.clamp"
    );

    //scalarOp   - vec.add(1)
    //vecOp      - vec.add(vec2)
    //elementsOp - vec.add(x, y, z)

    //fun0       - vec.floor()

    //scalarFun1
    //vecFun1
    //elementsFun1
    //vecOp      - vec.add(vec2)
    //elementsOp - vec.add(x, y, z)


    public static void main(String[] args) {
        YList<String> seLines = al();
        Tab tab = new Tab("    ").inc();
        for (String className : classToFields.keySet()) {
            YList<String> lines = al();

            for (String m : methodToOp.keySet()) {
                lines.addAll(genVecOp(className, m, methodToOp.get(m)));
                lines.addAll(genScalarOp(className, classToScalar.get(className), m, methodToOp.get(m)));
                lines.addAll(genElementsOp(className, m, methodToOp.get(m)));

                seLines.addAll(genSeVecOp(className, m, tab, methodToOp.get(m)));
                seLines.addAll(genSeVecOpA(className, m, tab, methodToOp.get(m)));
                seLines.addAll(genSeScalarOp(className, classToScalar.get(className), m, tab, methodToOp.get(m)));
                seLines.addAll(genSeScalarOpA(className, classToScalar.get(className), m, tab, methodToOp.get(m)));
            }
            for (String m : methodTo0Fun.keySet()) {
                if (classToMethodSkip.get(className) != null && classToMethodSkip.get(className).contains(m)) continue;

                lines.addAll(genVecFun0(className, m,methodTo0Fun.get(m)));

                seLines.addAll(genSeVecFun0(className, m, methodTo0Fun.get(m), tab));
            }
            for (String m : methodTo1Fun.keySet()) {
                if (classToMethodSkip.get(className) != null && classToMethodSkip.get(className).contains(m)) continue;

                lines.addAll(genVecFun1(className, className, m, methodTo1Fun.get(m)));
                lines.addAll(genScalarFun1(className, classToScalar.get(className), m, methodTo1Fun.get(m)));
                lines.addAll(genElementsFun1(className, classToScalar.get(className), m, methodTo1Fun.get(m)));

                seLines.addAll(genSeVecFun1(className, m, methodTo1Fun.get(m), tab));
            }
            //for (String m : methodTo1Fun.keySet()) {
            //    System.out.println(genVecFun1(className, className, m).toString("\n"));
            //    System.out.println(genScalarFun1(className, classToScalar.get(className), m).toString("\n"));
            //}
            //System.out.println();
            //System.out.println(genMethodBodyFun(className, classToFields.get(className), "MyMath.floor"));
            String fileName = classToFile.get(className);
            if (fileName != null) {
                System.out.println("Writing lines to " + fileName);
                IO.writeFile(fileName, Util.insertLines(IO.readFile(fileName), "2022", lines));
            } else {
                System.out.println("No file defined for " + className);
            }
        }


        String seFile = "src/main/java/yk/jcommon/fastgeom/VectorOperationsNoMalloc.java";
        System.out.println("Writing lines to " + seFile);
        IO.writeFile(seFile, Util.insertLines(IO.readFile(seFile), "2022", seLines));
    }

    //operators
    public static YList<String> genVecOp(String className, String methodName, String op) {
        return al(format("public %s %s(%s other) {", className, methodName, className)
                + genConstructorOp(className, fields(className), op, classToOtherFields.get(className)) + "}"
        );
    }
    public static YList<String> genElementsOp(String className, String methodName, String op) {
        return al(format("public %s %s(%s) {", className, methodName, fields(className).map(f -> classToScalar.get(className) + " " + f).toString(", "))
                + genConstructorOp(className, fields(className).map(f -> "this." + f), op, fields(className)) + "}"
        );
    }

    public static YList<String> genScalarOp(String c1, String c2, String methodName, String op) {
        return al(format("public %s %s(%s v) {", c1, methodName, c2)
                + genConstructorOp(c1, fields(c1), op, fields(c1).map(f -> "v")) + "}");
    }


    public static YList<String> genSeVecOp(String className, String methodName, Tab tab, String op) {
        return al(format("public static void nm%s(%s a, %s b, %s res) {", capitalize(methodName), className, className, className))
                .with(genSeBodyOp("a", "res", fields(className), fields(className).map(l -> "b." + l), op).map(l -> tab + l)).with("}");
    }

    public static YList<String> genSeVecOpA(String className, String methodName, Tab tab, String op) {
        return al(format("public static void nm%s(%s a_res, %s b) {", capitalize(methodName), className, className, className))
                .with(genSeBodyOp("a_res", "a_res", fields(className), fields(className).map(l -> "b." + l), op).map(l -> tab + l)).with("}");
    }

    public static YList<String> genSeScalarOp(String className, String c2, String methodName, Tab tab, String op) {
        return al(format("public static void nm%s(%s a, %s b, %s res) {", capitalize(methodName), className, c2, className))
                .with(genSeBodyOp("a", "res", fields(className), fields(className).map(l -> "b"), op).map(l -> tab + l)).with("}");
    }

    public static YList<String> genSeScalarOpA(String className, String c2, String methodName, Tab tab, String op) {
        return al(format("public static void nm%s(%s a_res, %s b) {", capitalize(methodName), className, c2, className))
                .with(genSeBodyOp("a_res", "a_res", fields(className), fields(className).map(l -> "b"), op).map(l -> tab + l)).with("}");
    }

    //fun0
    public static YList<String> genVecFun0(String c1, String m, String call) {
        return al(format("public %s %s() {", c1, m)
                + genConstructorFun(c1, fields(c1), fields(c1).map(f -> null), call) + "}"
        );
    }

    public static YList<String> genSeVecFun0(String c1, String m, String call, Tab tab) {
        return al(format("public static void nm%s(%s v, %s res) {", capitalize(m), c1, c1))
                .with(genSeBodyFun("v", "res", fields(c1), fields(c1).map(f -> al()), call).map(l -> tab + l)).with("}");
    }
    //fun1
    public static YList<String> genVecFun1(String c1, String c2, String m, String call) {
        return al(format("public %s %s(%s b) {", c1, m, c2)
                + genConstructorFun(c1, fields(c1), fields(c1).map(f -> "b." + f), call) + "}"
        );
    }
    public static YList<String> genScalarFun1(String c1, String c2, String m, String call) {
        return al(format("public %s %s(%s b) {", c1, m, c2)
                + genConstructorFun(c1, fields(c1), fields(c1).map(f -> "b"), call) + "}"
        );
    }
    public static YList<String> genElementsFun1(String c1, String c2, String m, String call) {
        return al(format("public %s %s(%s) {", c1, m, fields(c1).map(f -> classToScalar.get(c1) + " " + f).toString(", "))
                + genConstructorFun(c1, fields(c1).map(f -> "this." + f), fields(c1), call) + "}"
        );
    }
    public static YList<String> genSeVecFun1(String c1, String m, String call, Tab tab) {
        return al(format("public static void nm%s(%s v1, %s v2, %s res) {", capitalize(m), c1, c1, c1))
                .with(genSeBodyFun("v1", "res", fields(c1), fields(c1).map(f -> al("v2." + f)), call).map(l -> tab + l)).with("}");
    }


    //body
    public static YList<String> genSeBodyOp(String v1Name, String resName, YList<String> fields, YList<String> V2s, String op) {
        return zip(fields, V2s, (f, of) -> format("%s.%s = %s.%s %s %s;", resName, f, v1Name, f, op, of));
    }
    public static YList<String> genSeBodyFun(String v1Name, String resName, YList<String> fields, YList<YList<String>> V2s, String op) {
        return zip(fields, V2s, (f, of) -> format("%s.%s = %s(%s);", resName, f, op, al(v1Name + "." + f).with(of).toString(", ")));
    }
    public static String genConstructorFun(String className, YList<String> firsts, YList<String> restFields, String method) {
        return format("return new %s(%s);", className, zip(firsts, restFields, (f, rest) -> method + "(" + f + (rest == null ? "" : (", " + rest)) + ")").toString(", "));
    }
    public static String genConstructorOp(String className, YList<String> lefts, String op, YList<String> rights) {
        return format("return new %s(%s);", className, zip(lefts, rights, (f, of) -> f + " " + op + " " + of).toString(", "));
    }

    private static String capitalize(String methodName) {
        return methodName.substring(0, 1).toUpperCase() + methodName.substring(1);
    }

    public static YList<String> fields(String className) {
        return classToFields.get(className);
    }
}
