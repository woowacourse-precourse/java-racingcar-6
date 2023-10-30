package racingcar.util;

import java.util.regex.Pattern;

public class Validator {

    private static final Pattern nameValidatePattern = Pattern.compile("([\\S]{1,})");
    private static final Pattern numberValidatePattern = Pattern.compile("([\\d]{1,})");

    public static void validateInputSpace(String input) {
        if (!validateInputPattern(input, nameValidatePattern)) {
            throw new IllegalArgumentException("공백을 제거해주세요.");
        }
    }

    public static void validateInputLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 1~5글자로 작성해주세요.");
        }
    }

    public static void validateInputNumberZero(String input) {
        if (input.equals("0")) {
            throw new IllegalArgumentException("1이상의 정수만 입력해주세요.");
        }
    }

    public static void validateInputNumber(String input) {
        if (!validateInputPattern(input, numberValidatePattern)) {
            throw new IllegalArgumentException("1이상의 정수만 입력해주세요.");
        }
    }

    private static boolean validateInputPattern(String input, Pattern pattern) {
        return pattern.matcher(input).matches();
    }
}
