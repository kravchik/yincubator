package yk.jcommon.scripts;

import yk.jcommon.utils.IO;
import yk.jcommon.utils.Tab;
import yk.jcommon.utils.Util;
import yk.ycollections.YList;
import yk.ycollections.YMap;

import java.util.function.Function;

import static java.lang.String.format;
import static yk.jcommon.scripts.GenVectorMethods.*;
import static yk.ycollections.YArrayList.al;
import static yk.ycollections.YHashMap.hm;

public class GenAdditionalVectors {

    public static YMap<String, YList<String>> VEC_FIELDS = hm(
        "Vec3BigInteger", al("x", "y", "z")
    );

    public static YMap<String, String> CLASS_FILES = hm(
        "Vec3BigInteger", "src/main/java/yk/jcommon/fastgeom/Vec3BigInteger.java"
    );


    public static void main(String[] args) {
        Tab tab = new Tab("    ").inc();
        for (String className : VEC_FIELDS.keySet()) {
            if (!className.equals("Vec3BigInteger")) continue;

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
                genMethods_V_I(className, m, METHOD_TO_OP.get(m), lines);
            }

            lines.add("//0 args functions");
            YMap<String, String> METHOD_TO_0_FUN = hm(
                //"round", "Math.round",
                //"floor", "MyMath.floorFast",
                //"ceil", "MyMath.ceil",
                "abs", ".abs"
            );
            for (String m : METHOD_TO_0_FUN.keySet()) {
                lines.addAll(genUnary(className, m, unaryOp(METHOD_TO_0_FUN.get(m))));
            }
            lines.add("//reducers");
            YMap<String, String> REDUCERS = hm(
                "sum", ".add",
                "product", ".multiply",
                "min", ".min",
                "max", ".max"
            );
            for (String m : REDUCERS.keySet()) {
                String op = REDUCERS.get(m);
                lines.addAll(genReducerUnary(className, m, binaryOp(op)));
            }

            lines.add("//distance");
            //lengthSquared
            lines.add(format("public %s lengthSquared() {return %s;}", elementClass, fields(className)
                .map(f -> format("%s.multiply(%s)", f, f)).reduce(binaryOp(".add"))));

            lines.addAll(genBinaryReducers(className, "distanceSquared",
                (arg1, arg2) -> unaryOp("BigIntegerMath.sqr").apply(binaryOp(".subtract").apply(arg1, arg2)),
                binaryOp(".add"), Function.identity()));

            lines.addAll(genReducerUnary(className, "manhattanLength", unaryOp(".abs"), binaryOp(".add")));
            lines.addAll(genBinaryReducers(className, "manhattanDistance",
                (arg1, arg2) -> unaryOp(".abs").apply(binaryOp(".subtract").apply(arg1, arg2)),
                binaryOp(".add"), Function.identity()));

            lines.add("//math");

            lines.addAll(genBinaryReducers(className, "dot", binaryOp(".multiply"), binaryOp(".add"), Function.identity()));
            lines.add(format("public %s scalarProduct(%s b) {return dot(b);}", elementClass, className));

            lines.add(format("public %s negative() {return new %s(%s);}", className, className,
                fields(className).map(f -> f + ".negate()").toString(", ")));

            lines.add("//binary functions");
            YMap<String, String> METHOD_TO_1_FUN = hm(
                "min", ".min",
                "max", ".max"
                //"cycle", "MyMath.cycle"
            );
            for (String m : METHOD_TO_1_FUN.keySet()) {
                genMethods_V_I(className, m, METHOD_TO_1_FUN.get(m), lines);
            }

            genMethods_V_II(className, "clamp", lines, null, "min", "max",
                (v, min, max) -> String.format("%s.max(%s).min(%s)", v, min, max));

            String fileName = CLASS_FILES.get(className);
            if (fileName != null) {
                System.out.println("Writing lines to " + fileName);
                IO.writeFile(fileName, Util.insertLines(IO.readFile(fileName), "2022", lines));
            } else {
                System.out.println("No file defined for " + className);
            }

        }
    }

    private static void genMethods_V_I(String className, String m, String op, YList<String> lines) {
        String elementClass = ELEMENT_CLASS.get(className);
        Tab tab = new Tab("    ").inc();

        YMap<String, String> ops = hm(
            "+", ".add",
            "-", ".subtract",
            "/", ".divide",
            "*", ".multiply"
        );
        op = ops.getOr(op, op);
        //v.min(v) -> v
        lines.addAll(genMethod_V_V(className, m, binaryOp(op)));
        //v.min(i) -> v
        lines.addAll(genMethod_V_S(className, m, binaryOp(op)));
        //v.min(x, y) -> v
        lines.addAll(genMethod_V_xyz(className, m, binaryOp(op)));
    }


}
