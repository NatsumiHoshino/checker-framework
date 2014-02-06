/*
 * @test
 * @summary Test that defaulted types are stored in bytecode.
 *
 * @compile Driver.java ReferenceInfoUtil.java Methods.java
 * @run main Driver Methods
 */

import static com.sun.tools.classfile.TypeAnnotation.TargetType.*;

public class Methods {

    @TADescriptions({
        @TADescription(annotation = "checkers/nullness/quals/NonNull", type = METHOD_FORMAL_PARAMETER, paramIndex=0),
        @TADescription(annotation = "checkers/initialization/quals/Initialized", type = METHOD_FORMAL_PARAMETER, paramIndex=0),
        @TADescription(annotation = "checkers/nullness/quals/UnknownKeyFor", type = METHOD_FORMAL_PARAMETER, paramIndex=0),
    })
    public String paramDefault1() {
        return "void pm1(Object o) {}";
    }

    @TADescriptions({
        @TADescription(annotation = "checkers/nullness/quals/NonNull", type = METHOD_RETURN),
        @TADescription(annotation = "checkers/initialization/quals/Initialized", type = METHOD_RETURN),
        @TADescription(annotation = "checkers/nullness/quals/UnknownKeyFor", type = METHOD_RETURN),
    })
    public String retDefault1() {
        return "Object rm1() { return new Object(); }";
    }

    @TADescriptions({
        @TADescription(annotation = "checkers/nullness/quals/NonNull", type = THROWS, typeIndex=0),
        @TADescription(annotation = "checkers/initialization/quals/Initialized", type = THROWS, typeIndex=0),
        @TADescription(annotation = "checkers/nullness/quals/UnknownKeyFor", type = THROWS, typeIndex=0),
    })
    public String throwsDefault1() {
        return "void tm1() throws Throwable {}";
    }

    @TADescriptions({
        @TADescription(annotation = "checkers/nullness/quals/NonNull", type = THROWS, typeIndex=0),
        @TADescription(annotation = "checkers/initialization/quals/Initialized", type = THROWS, typeIndex=0),
        @TADescription(annotation = "checkers/nullness/quals/UnknownKeyFor", type = THROWS, typeIndex=0), // from KeyFor
        @TADescription(annotation = "checkers/nullness/quals/NonNull", type = THROWS, typeIndex=1),
        @TADescription(annotation = "checkers/initialization/quals/Initialized", type = THROWS, typeIndex=1),
        @TADescription(annotation = "checkers/nullness/quals/UnknownKeyFor", type = THROWS, typeIndex=1),
    })
    public String throwsDefault2() {
        return "void tm2() throws ArrayIndexOutOfBoundsException, NullPointerException {}";
    }

    @TADescriptions({
        @TADescription(annotation = "checkers/nullness/quals/NonNull", type = METHOD_RECEIVER),
        @TADescription(annotation = "checkers/initialization/quals/Initialized", type = METHOD_RECEIVER),
        @TADescription(annotation = "checkers/nullness/quals/UnknownKeyFor", type = METHOD_RECEIVER),
    })
    public String recvDefault1() {
        return "void rd1(Test this) {}";
    }

    @TADescriptions({
        @TADescription(annotation = "checkers/nullness/quals/Nullable", type = METHOD_TYPE_PARAMETER_BOUND, paramIndex=0, boundIndex=0),
        @TADescription(annotation = "checkers/initialization/quals/Initialized", type = METHOD_TYPE_PARAMETER_BOUND, paramIndex=0, boundIndex=0),
        @TADescription(annotation = "checkers/nullness/quals/UnknownKeyFor", type = METHOD_TYPE_PARAMETER_BOUND, paramIndex=0, boundIndex=0),
    })
    public String typeParams1() {
        return "<M1> void foo(M1 p) {}";
    }

    @TADescriptions({
        @TADescription(annotation = "checkers/nullness/quals/NonNull", type = METHOD_TYPE_PARAMETER_BOUND, paramIndex=0, boundIndex=0),
        @TADescription(annotation = "checkers/initialization/quals/Initialized", type = METHOD_TYPE_PARAMETER_BOUND, paramIndex=0, boundIndex=0),
        @TADescription(annotation = "checkers/nullness/quals/UnknownKeyFor", type = METHOD_TYPE_PARAMETER_BOUND, paramIndex=0, boundIndex=0),
    })
    public String typeParams2() {
        return "<M1 extends Object> void foo(M1 p) {}";
    }

    @TADescriptions({
        @TADescription(annotation = "checkers/nullness/quals/NonNull", type = METHOD_TYPE_PARAMETER_BOUND, paramIndex=0, boundIndex=1),
        @TADescription(annotation = "checkers/initialization/quals/Initialized", type = METHOD_TYPE_PARAMETER_BOUND, paramIndex=0, boundIndex=1),
        @TADescription(annotation = "checkers/nullness/quals/UnknownKeyFor", type = METHOD_TYPE_PARAMETER_BOUND, paramIndex=0, boundIndex=1),
    })
    public String typeParams3() {
        return "<M2 extends Comparable<M2>> void bar(M2 p) {}";
    }
}