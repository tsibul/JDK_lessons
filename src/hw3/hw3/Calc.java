package hw3.hw3;

public class Calc {

    public static <T1 extends Number, T2 extends Number> Number sum(T1 a, T2 b) {
        if (a instanceof Integer && b instanceof Integer) {
            return a.intValue() + b.intValue();
        }
        return a.floatValue() + b.floatValue();
    }

    public static <T1 extends Number, T2 extends Number> Number multiply(T1 a, T2 b) {
        if (a instanceof Integer && b instanceof Integer) {
            return a.intValue() * b.intValue();
        }
        return a.floatValue() * b.floatValue();

    }

    public static <T1 extends Number, T2 extends Number> Number subtract(T1 a, T2 b) {
        if (a instanceof Integer && b instanceof Integer) {
            return a.intValue() - b.intValue();
        }
        return a.floatValue() - b.floatValue();

    }

    public static <T1 extends Number, T2 extends Number> Number divide(T1 a, T2 b) {
        if (a instanceof Integer && b instanceof Integer) {
            if (b.intValue() != 0) {
                return a.intValue() / b.intValue();
            }
        }
        if (b.floatValue() != 0f) {
            return a.floatValue() + b.floatValue();
        }
        return null;
    }
}
