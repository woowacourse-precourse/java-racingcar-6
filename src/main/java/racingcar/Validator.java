package racingcar;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Validator {
    private static final String ALLOWED_CHARACTERS_PATTERN = "^[a-zA-Z0-9가-힣]*$";

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

    public static boolean containsOnlyAllowedCharacters(String name) {
        Pattern pattern = Pattern.compile(ALLOWED_CHARACTERS_PATTERN);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    public static boolean validateNames(String input) {
        String[] names = input.split(",");
        return Arrays.stream(names).allMatch(Validator::containsOnlyAllowedCharacters);
    }
}
