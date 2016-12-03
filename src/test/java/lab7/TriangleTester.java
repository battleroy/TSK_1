package lab7;

import org.testng.annotations.Test;

@Test
public class TriangleTester {

    public void error() {
        float a = 1.0f, b = 2.0f, c = 4.0f;

        assert(TriangleTypeChecker.getType(a, b, c) == TriangleTypeChecker.Type.ERRORNEOUS);
    }


    public void equaliteral() {
        float a = 1.0f, b = 1.0f, c = 1.0f;

        assert(TriangleTypeChecker.getType(a, b, c) == TriangleTypeChecker.Type.EQUALITERAL);
    }


    public void isosceles() {
        float a = 1.0f, b = 1.0f, c = 1.5f;

        assert(TriangleTypeChecker.getType(a, b, c) == TriangleTypeChecker.Type.ISOSCELES);
    }


    public void versatile() {
        float a = 1.0f, b = 1.2f, c = 1.5f;

        assert(TriangleTypeChecker.getType(a, b, c) == TriangleTypeChecker.Type.VERSATILE);
    }

}
