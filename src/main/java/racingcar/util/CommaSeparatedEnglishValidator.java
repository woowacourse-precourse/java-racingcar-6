package racingcar.util;

import java.util.regex.Pattern;

public final class CommaSeparatedEnglishValidator {
    private static final Pattern ENGLISH_WITH_COMMA_SEPARATED = Pattern.compile("[A-Za-z]+(,[A-Za-z]+)*");
    private static final String FORMAT_EXCEPTION = "영어와 ',' 형식만 입력 가능합니다.";

    private CommaSeparatedEnglishValidator() {
    }

    public static void validate(String input) {
        if (!matchesPattern(input, ENGLISH_WITH_COMMA_SEPARATED)) {
            throw new IllegalArgumentException(FORMAT_EXCEPTION);
        }
    }

    private static boolean matchesPattern(String input, Pattern pattern) {
        return pattern.matcher(input).matches();
    }
}
