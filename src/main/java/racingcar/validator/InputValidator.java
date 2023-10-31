package racingcar.validator;

import java.math.BigInteger;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {
    private static final String NOT_CAR_FORMAT_REGEX = "[^a-zA-Z,]+";
    private static final Pattern NOT_CAR_PATTERN = Pattern.compile(NOT_CAR_FORMAT_REGEX);
    private static final String DELIMITER = ",";

    public static void validateCarsFormat(String input) {
        Matcher matcher = NOT_CAR_PATTERN.matcher(input);
        if (matcher.matches() || input.endsWith(DELIMITER) || input.startsWith(DELIMITER)) {
            throw new IllegalArgumentException("[ERROR] 형식에 맞게 입력해주세요.");
        }
    }

    public static void validateCarNameValid(List<String> inputs) {
        for (String input : inputs) {
            if (input.length() > 5) {
                throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하로 작성해주세요.");
            } else if (input.isBlank()) {
                throw new IllegalArgumentException("[ERROR] 형식에 맞게 입력해주세요.");
            }
        }
    }

    public static void validateTryNumber(String input) {
        if (!Character.isDigit(input.charAt(0))) {
            throw new IllegalArgumentException("[ERROR] 올바른 시도 횟수를 입력해주세요.");
        }
    }
}