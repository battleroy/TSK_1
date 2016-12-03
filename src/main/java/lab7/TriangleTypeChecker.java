package lab7;

public class TriangleTypeChecker {

    public static enum Type {
        EQUALITERAL,
        ISOSCELES,
        VERSATILE,
        ERRORNEOUS
    }


    public static Type getType(float a, float b, float c) {
        if ((a + b < c) || (a + c < b) || (b + c < a)) {
            return Type.ERRORNEOUS;
        }

        if (a == b && b == c) {
            return Type.EQUALITERAL;
        }

        if ((a == b && a != c) || (a == c && a != b) || (b == c && b != a)) {
            return Type.ISOSCELES;
        }

        return Type.VERSATILE;
    }

}
