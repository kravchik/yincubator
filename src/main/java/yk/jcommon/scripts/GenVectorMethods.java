package yk.jcommon.scripts;

import yk.jcommon.utils.IO;
import yk.jcommon.utils.Tab;
import yk.jcommon.utils.Util;
import yk.ycollections.YArrayList;
import yk.ycollections.YList;
import yk.ycollections.YMap;
import yk.ycollections.YSet;

import java.util.function.BiFunction;
import java.util.function.Function;

import static java.lang.String.format;
import static yk.ycollections.YArrayList.al;
import static yk.ycollections.YHashMap.hm;
import static yk.ycollections.YHashSet.hs;
public class GenVectorMethods {

    public static YSet<String> OPERATORS = hs(
            "+", "-", "*", "/", "%"
    );

    public static YMap<String, String> CLASS_FILES = hm(
            "Vec2f", "src/main/java/yk/jcommon/fastgeom/Vec2f.java",
            "Vec2i", "src/main/java/yk/jcommon/fastgeom/Vec2i.java",
            "Vec4i", "src/main/java/yk/jcommon/fastgeom/Vec4i.java",
            "Vec3f", "src/main/java/yk/jcommon/fastgeom/Vec3f.java",
            "Vec3i", "src/main/java/yk/jcommon/fastgeom/Vec3i.java",
            "Vec4f", "src/main/java/yk/jcommon/fastgeom/Vec4f.java"
    );

    public static YMap<String, YList<String>> VEC_FIELDS = hm(
            "Vec2i", al("x", "y"),
            "Vec3i", al("x", "y", "z"),
            "Vec4i", al("x", "y", "z", "w"),
            "Vec2f", al("x", "y"),
            "Vec3f", al("x", "y", "z"),
            "Vec4f", al("x", "y", "z", "w")
    );

    public static YMap<String, String> CLASS_TO_CONSTRUCTOR_NAME = hm(
            "Vec2i", "v2i",
            "Vec3i", "v3i",
            "Vec4i", "v4i",
            "Vec2f", "v2",
            "Vec3f", "v3",
            "Vec4f", "v4"
    );
    public static YMap<String, String> ELEMENT_CLASS = hm(
            "Vec2i", "int",
            "Vec3i", "int",
            "Vec4i", "int",
            "Vec2f", "float",
            "Vec3f", "float",
            "Vec4f", "float"
    );

    public static YMap<String, String> METHOD_TO_OP = hm(
            "add", "+",
            //"plus", "+",
            "sub", "-",
            //"minus", "-",
            "mul", "*",
            //"multiply", "*",
            "div", "/"
    );

    public static final YSet<String> FLOAT_ONLY = hs("floor", "ceil", "round", "length", "normalized");

    public static final YMap<String, String> METHOD_TO_0_FUN = hm(
            "round", "Math.round",
            "floor", "MyMath.floorFast",
            "ceil", "MyMath.ceil",
            "abs", "MyMath.abs"
    );

    public static final YMap<String, String> REDUCERS = hm(
            "sum", "+",
            "product", "*",
            "min", "MyMath.min",
            "max", "MyMath.max"
    );

    public static YMap<String, String> METHOD_TO_1_FUN = hm(
            "min", "MyMath.min",
            "max", "MyMath.max",
            "cycle", "MyMath.cycle"
    );

    public static YMap<String, String> METHOD_TO_2_FUN = hm(
            "clamp", "MyMath.clamp"
    );

    public static void main(String[] args) {
        YList<String> seLines = al();
        Tab tab = new Tab("    ").inc();
        for (String className : VEC_FIELDS.keySet()) {
            //if (!className.equals("Vec2i")) continue;

            YList<String> lines = al();

            lines.add("//constructors");
            String elementClass = ELEMENT_CLASS.get(className);
            lines.add(format("public %s(%s) {%s}", className,
                    fields(className).map(f -> format("%s %s", elementClass, f)).toString(", "),
                    fields(className).map(f -> format("this.%s = %s", f, f)).toStringSuffix(";")));
            lines.add(format("public %s(%s other) {%s}", className, className,
                    fields(className).map(f -> format("%s = other.%s", f, f)).toStringSuffix(";")));
            lines.add(format("public %s(%s b) {%s}", className, elementClass,
                    fields(className).map(f -> format("%s = b", f)).toStringSuffix(";")));

            lines.add(format("public static %s %s(%s) {return new %s(%s);}",
                    className, CLASS_TO_CONSTRUCTOR_NAME.get(className),
                    fields(className).map(f -> format("%s %s", elementClass, f)).toString(", "),
                    className, fields(className).toString(", ")));
            lines.add(format("public static %s %s(%s b) {return new %s(%s);}", className,
                    CLASS_TO_CONSTRUCTOR_NAME.get(className), elementClass,
                    className, fields(className).map(f -> "b").toString(", ")));
            lines.add(format("public void fillFrom(%s other) {%s}", className,
                    fields(className).map(f -> format("%s = other.%s", f, f)).toStringSuffix(";")));

            lines.add("//operators");
            for (String m : METHOD_TO_OP.keySet()) {
                genVariants(className, m, METHOD_TO_OP.get(m), lines, seLines);
            }

            lines.add("//0 args functions");
            for (String m : METHOD_TO_0_FUN.keySet()) {
                if (elementClass.equals("int") && FLOAT_ONLY.contains(m)) continue;
                //v.floor() -> v
                lines.addAll(genUnary(className, m, unaryOp(METHOD_TO_0_FUN.get(m))));

                //VectorOperationsNoMalloc.nmFloor(vInput, vRes)
                seLines.addAll(genSe_Vo_V(className, m, tab, unaryOp(METHOD_TO_0_FUN.get(m))));
            }
            lines.add("//reducers");
            for (String m : REDUCERS.keySet()) {
                if (elementClass.equals("int") && FLOAT_ONLY.contains(m)) continue;
                //v.sum() -> i
                String op = REDUCERS.get(m);
                lines.addAll(genReducerUnary(className, m, binaryOp(op)));
            }

            //lines.addAll(genReducerUnary(className, "maxAbs",
            //        ff -> ff.map(unaryOp("Math.abs")).reduce(
            //                (res, cur) -> format("Math.max(%s, %s)", res, cur))));
            //lines.addAll(genReducerUnary(className, "minAbs",
            //        ff -> ff.map(unaryOp("Math.abs")).reduce(
            //                (res, cur) -> format("Math.min(%s, %s)", res, cur))));

            lines.add("//distance");
            //lengthSquared
            lines.add(format("public %s lengthSquared() {return %s;}", elementClass, fields(className).map(f -> f + " * " + f).reduce(binaryOp("+"))));

            lines.addAll(genBinaryReducers(className, "distanceSquared",
                    (arg1, arg2) -> unaryOp("MyMath.sqr").apply(binaryOp("-").apply(arg1, arg2)),
                    binaryOp("+"), Function.identity()));

            lines.addAll(genReducerUnary(className, "manhattanLength", unaryOp("Math.abs"), binaryOp("+")));
            lines.addAll(genBinaryReducers(className, "manhattanDistance",
                    (arg1, arg2) -> unaryOp("MyMath.abs").apply(binaryOp("-").apply(arg1, arg2)),
                    binaryOp("+"), Function.identity()));

            if (elementClass.equals("float")) {
                //length
                lines.add(format("public %s length() {return MyMath.sqrt(%s);}", elementClass, fields(className).map(f -> f + " * " + f).reduce(binaryOp("+"))));
                //normalized
                lines.add(format("public %s normalized() {", className));
                lines.add(tab + format("float m = 1f / MyMath.sqrt(%s);", fields(className)
                        .map(f -> format("%s * %s", f, f)).reduce(binaryOp("+"))));
                lines.add(tab + format("return new %s(%s);", className, fields(className)
                        .map(f -> format("%s * m", f)).toString(", ")));
                lines.add("}");
                //normalized(len)
                lines.add(format("public %s normalized(%s len) {", className, elementClass));
                lines.add(tab + format("float m = len / (float)Math.sqrt(%s);", fields(className)
                        .map(f -> format("%s * %s", f, f)).reduce(binaryOp("+"))));
                lines.add(tab + format("return new %s(%s);", className, fields(className)
                        .map(f -> format("%s * m", f)).toString(", ")));
                lines.add("}");

                lines.addAll(genBinaryReducers(className, "distance",
                        (arg1, arg2) -> unaryOp("MyMath.sqr").apply(binaryOp("-").apply(arg1, arg2)),
                        binaryOp("+"), unaryOp("MyMath.sqrt")));
                //lines.add(format("public %s distance(%s to) {return %s;}", elementClass, className,
                //        "MyMath.sqrt(" + fields(className).map(f -> format("MyMath.sqr(%s - to.%s)", f, f)).reduce(binaryOp("+")) + ")"));
            }
            
            lines.add("//math");

            lines.addAll(genBinaryReducers(className, "dot", binaryOp("*"), binaryOp("+"), Function.identity()));
            lines.add(format("public %s scalarProduct(%s b) {return dot(b);}", elementClass, className));

            lines.add(format("public %s negative() {return new %s(%s);}", className, className,
                    fields(className).map(f -> "-" + f).toString(", ")));


            lines.add("//binary functions");
            for (String m : METHOD_TO_1_FUN.keySet()) {
                genVariants(className, m, METHOD_TO_1_FUN.get(m), lines, seLines);
            }

            String fileName = CLASS_FILES.get(className);
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

    private static YList<String> genBinaryReducers(String className, String methodName,
                           BiFunction<String, String, String> combine, BiFunction<String, String, String> reduce,
                            Function<String, String> map) {
        YList<String> lines = al();

        lines.addAll(genBinaryReducer(className, methodName, combine, reduce, map));
        lines.addAll(genBinaryReducerAllElements(className, methodName, combine, reduce, map));

        return lines;
    }

    private static void genVariants(String className, String m, String op, YList<String> lines, YList<String> seLines) {
        Tab tab = new Tab("    ").inc();
        //v.min(v) -> v
        lines.addAll(genBinaryMethod(className, m, binaryOp(op)));
        //v.min(i) -> v
        lines.addAll(genBinaryMethodBy1Element(className, m, binaryOp(op)));
        //v.min(x, y) -> v
        lines.addAll(genBinaryMethodByAllElements(className, m, binaryOp(op)));

        //VectorOperationsNoMalloc.nmMin(v1, v2, vRes)

        seLines.addAll(genSe_Vo_VV(className, m, tab, binaryOp(op)));
        seLines.addAll(genSe_Vio_V(className, m, tab, binaryOp(op)));
        seLines.addAll(genSe_Vo_VS(className, m, tab, binaryOp(op)));
        seLines.addAll(genSe_Vio_S(className, m, tab, binaryOp(op)));
    }

    public static YList<String> genSe_Vo_VV(String className, String methodName, Tab tab,
                                            BiFunction<String, String, String> forField) {
        return genSe(className, tab, format("public static void nm%s(%s res, %s a, %s b) {",
                        capitalize(methodName), className, className, className),
                f -> format("res.%s = %s", f, forField.apply("a." + f, "b." + f)));
    }

    public static YList<String> genSe_Vio_V(String className, String methodName, Tab tab,
                                            BiFunction<String, String, String> forField) {
        return genSe(className, tab, format("public static void nm%s(%s a_res, %s b) {",
                        capitalize(methodName), className, className),
                f -> format("a_res.%s = %s", f, forField.apply("a_res." + f, "b." + f)));
    }

    public static YList<String> genSe_Vo_VS(String className, String methodName, Tab tab,
                                            BiFunction<String, String, String> forField) {
        return genSe(className, tab, format("public static void nm%s(%s res, %s a, %s b) {",
                        capitalize(methodName), className, className, ELEMENT_CLASS.get(className)),
                f -> format("res.%s = %s", f, forField.apply("a." + f, "b")));
    }

    public static YList<String> genSe_Vo_V(String className, String methodName, Tab tab,
                                           Function<String, String> forField) {
        return genSe(className, tab, format("public static void nm%s(%s res, %s a) {",
                capitalize(methodName), className, className),
                f -> format("res.%s = %s", f, forField.apply("a." + f)));
    }

    private static YArrayList<String> genSe(String className, Tab tab, String header,
                                            Function<String, String> calculation) {
        return al(header).withAll(fields(className)
                        .map(calculation)
                        .map(l -> tab + l + ";"))
                .with("}");
    }

    public static YList<String> genSe_Vio_S(String className, String methodName, Tab tab,
                                            BiFunction<String, String, String> forField) {
        return al(format("public static void nm%s(%s a_res, %s b) {",
                capitalize(methodName), className, ELEMENT_CLASS.get(className)))
                .withAll(fields(className)
                        .map(f -> format("a_res.%s = %s", f, forField.apply("a_res." + f, "b")))
                        .map(l -> tab + l + ";"))
                .with("}");
    }

    public static YList<String> genBinaryMethod(String className, String method,
                                                BiFunction<String, String, String> forField) {
        //TODO if too long
        return al(format("public %s %s(%s b) {return new %s(%s);}",
                className, method, className, className, fields(className).map(f -> forField.apply(f, "b." + f)).toString(", ")));
    }

    public static YList<String> genBinaryReducer(String className, String method,
                                                BiFunction<String, String, String> forField) {
        return genBinaryReducer(className, method, forField, reduceComma(), Function.identity());
    }
    public static YList<String> genBinaryReducer(String className, String method,
                                                BiFunction<String, String, String> combine,
                                                BiFunction<String, String, String> reduce,
                                                Function<String, String> map) {
        //TODO if too long
        return al(format("public %s %s(%s b) {return %s;}",
                ELEMENT_CLASS.get(className), method, className,
                map.apply(fields(className).map(f -> combine.apply(f, "b." + f)).reduce(reduce))
        ));
    }

    public static YList<String> genBinaryReducerAllElements(String className, String method,
                                                BiFunction<String, String, String> forField) {
        return genBinaryReducer(className, method, forField, reduceComma(), Function.identity());
    }
    public static YList<String> genBinaryReducerAllElements(String className, String method,
                                                BiFunction<String, String, String> combine,
                                                BiFunction<String, String, String> reduce,
                                                Function<String, String> map) {
        //TODO if too long
        return al(format("public %s %s(%s) {return %s;}",
                ELEMENT_CLASS.get(className), method, fields(className)
                        .map(f -> format("%s %s", ELEMENT_CLASS.get(className), f)).toString(", "),
                map.apply(fields(className).map(f -> combine.apply("this." + f, f)).reduce(reduce))));
    }

    public static YList<String> genBinaryMethodByAllElements(String className, String method,
                                                             BiFunction<String, String, String> forField) {
        return genBinaryMethodByAllElements(className, method, forField, reduceComma());
    }

    public static YList<String> genBinaryMethodByAllElements(String className, String method,
                                                             BiFunction<String, String, String> map,
                                                             BiFunction<String, String, String> reduce) {
        //TODO if too long
        return al(format("public %s %s(%s) {return new %s(%s);}",
                className, method,
                fields(className).map(f -> format("%s %s", ELEMENT_CLASS.get(className), f)).toString(", "),
                className,
                fields(className).map(f -> map.apply("this." + f, f)).reduce(reduce)));
    }

    public static YList<String> genBinaryMethodBy1Element(String className, String method,
                                                          BiFunction<String, String, String> forField) {
        //TODO if too long
        return al(format("public %s %s(%s %s) {return new %s(%s);}",
                className, method, ELEMENT_CLASS.get(className), "b", className,
                fields(className).map(f -> forField.apply(f, "b")).toString(", ")));
    }

    public static YList<String> genUnary(String className, String method, Function<String, String> forField) {
        //TODO if too long
        return al(format("public %s %s() {return new %s(%s);}",
                className, method, className,
                fields(className).map(forField).toString(", ")));
    }

    public static YList<String> genReducerUnary(String className, String method, BiFunction<String, String, String> forField) {
        //TODO if too long
        return al(format("public %s %s() {return %s;}",
                ELEMENT_CLASS.get(className), method,
                fields(className).reduce(forField)));
    }

    public static YList<String> genReducerUnary(String className, String method,
                                                Function<String, String> map,
                                                BiFunction<String, String, String> reduce) {
        return genReducerUnary(className, method, ff -> ff.map(map).reduce(reduce));
    }

    public static YList<String> genReducerUnary(String className, String method,
                                                Function<YList<String>, String> map) {
        //TODO if too long
        return al(format("public %s %s() {return %s;}",
                ELEMENT_CLASS.get(className), method,
                map.apply(fields(className))));
    }

    public static BiFunction<String, String, String> binaryOp(String op) {
        return (arg1, arg2) -> OPERATORS.contains(op)
                ? format("%s %s %s", arg1, op, arg2)
                : format("%s(%s, %s)", op, arg1, arg2);
    }

    public static Function<String, String> binaryOpWithB(String op) {
        return f -> binaryOp(op).apply(f, "b." + f);
    }

    public static Function<String, String> unaryOp(String op) {
        return (arg) -> format("%s(%s)", op, arg);
    }

    public static Function<String, String> unaryOp(String op, Function<String, String> arg) {
        return (a) -> format("%s(%s)", op, arg.apply(a));
    }

    private static String capitalize(String methodName) {
        return methodName.substring(0, 1).toUpperCase() + methodName.substring(1);
    }

    public static YList<String> fields(String className) {
        return VEC_FIELDS.get(className);
    }

    private static BiFunction<String, String, String> reduceComma() {
        return (res, cur) -> res + ", " + cur;
    }
}
