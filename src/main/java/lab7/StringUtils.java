package lab7;

public class StringUtils {

    public static String concatLhsRhsIfContainsUppercaseCharElseConcatRhsLhs(String lhs, String rhs) {

        boolean containsUppercaseChar = false;
        for (char aChar: lhs.toCharArray()) {
            containsUppercaseChar |= (Character.isUpperCase(aChar));
        }

        for (char aChar: rhs.toCharArray()) {
            containsUppercaseChar |= (Character.isUpperCase(aChar));
        }

        if (containsUppercaseChar) {
            return lhs + rhs;
        }

        return rhs + lhs;
    }


    public static String reverseIfContainsSpace(String source) {

        for (char aChar: source.toCharArray()) {
            if (Character.isSpaceChar(aChar)) {

                StringBuilder result = new StringBuilder();

                for (char bChar: source.toCharArray()) {
                    result.insert(0, bChar);
                }

                return result.toString();

            }
        }

        return source;
    }

}
