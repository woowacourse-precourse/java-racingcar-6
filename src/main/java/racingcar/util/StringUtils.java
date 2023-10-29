package racingcar.util;

public class StringUtils {
    public static int validUnicodeLengthOf(String s) {
        return s.codePointCount(0, s.length());
    }
}
