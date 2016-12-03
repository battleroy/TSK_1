package lab7;

import org.testng.annotations.Test;

@Test
public class StringUtilsTester {

    public void concatWithUppercase() {
        String lhs = "Privet";
        String rhs = "Mir";
        String expected = "PrivetMir";

        String actual = StringUtils.concatLhsRhsIfContainsUppercaseCharElseConcatRhsLhs(lhs, rhs);

        assert(expected.equals(actual));
    }


    public void concatWithoutUppercase() {
        String lhs = "privet";
        String rhs = "mir";

        assert(StringUtils.concatLhsRhsIfContainsUppercaseCharElseConcatRhsLhs(lhs, rhs).equals("mirprivet"));
    }


    public void reverseWithSpace() {
        String source = "baton hleb";

        assert(StringUtils.reverseIfContainsSpace(source).equals("belh notab"));
    }


    public void reverseWithoutSpace() {
        String source = "аргентинаманитнегра";

        assert(StringUtils.reverseIfContainsSpace(source).equals(source));
    }

}
