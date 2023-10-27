package racingcar.util;

import java.util.Arrays;
import java.util.IllformedLocaleException;

public class Validator {


    public static void validateNumericInput(String input) {
        if (!input.matches("^[1-9]+$")) {
            throw new IllegalArgumentException("숫자를 입력해 주세요");
        }
    }

    public static void validateCarNames(String input) {
        if (!validateBlank(input) && validateNameLength(input)) {
            throw new IllformedLocaleException("잘못된 값을 입력하셨습니다");
        }
    }

    private static boolean validateBlank(String input) {
        return input.contains(" ");
    }

    private static boolean validateNameLength(String input) {
        return Arrays.stream(input.split(","))
                .map(String::length)
                .noneMatch(i -> i > 5);
    }


}
