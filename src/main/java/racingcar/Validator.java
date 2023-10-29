package racingcar;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Validator {
    public static boolean isInteger(String input) {
        try {
            Integer.valueOf(input);
            return true;
        } catch (NumberFormatException ex) {
            //not a number
            return false;
        }
    }

    public static boolean isPositiveInteger(String input) {
        return Integer.parseInt(input) > 0;
    }

    public static boolean hasNoWhitespace(String input) {
        return !input.contains(" ");
    }

    public static boolean hasNoConsecutiveCommas(String input) {
        // 정규 표현식 패턴: 연속된 쉼표(,) 검색
        Pattern pattern = Pattern.compile(",{2,}");
        Matcher matcher = pattern.matcher(input);
        return !matcher.find();
    }
}
