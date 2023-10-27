package racingcar.view.validator;

import org.junit.platform.commons.util.StringUtils;

import java.util.regex.Pattern;

public class InputValidator {
    private static Pattern onlyNumbers = Pattern.compile("-?[0-9]+");

    public static void validateInput(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException("입력은 공백일 수 없습니다.");
        }
    }

    public static void validateRaceCount(String input) {
        validateInput(input);

        if (isNotDigit(input)) {
            throw new IllegalArgumentException("경주를 시도할 횟수에 대한 입력은 숫자만 가능합니다.");
        }
    }

    private static boolean isNotDigit(String input) {
        return !onlyNumbers.matcher(input)
                .matches();
    }
}
