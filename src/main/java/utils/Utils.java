package utils;

import java.util.Arrays;

public class Utils {
    final static int MAX_INPUT_LENGTH = 5;
    final static String INPUT_IS_EMPTY = "입력은 공백일 수 없습니다.";
    final static String INPUT_HAS_SPACE = "입력은 공백이 포함될 수 없습니다.";
    final static String INPUT_OVER_LENGTH = "입력은 5자 이하여야 합니다.";
    final static String DUPLICATION_NAME = "자동차의 이름은 중복되지 않은 고유한 값이어야 합니다.";
    final static String NOT_NUMBER = "시도 횟수는 0 이상의 정수이어야 합니다.";
    final static String NEGATIVE_NUMBER = "시도 횟수는 음수가 될 수 없습니다.";

    public void hasSpace(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException(INPUT_HAS_SPACE);
        }
    }

    public void isEmpty(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(INPUT_IS_EMPTY);
        }
    }

    public void isOverLength(String input) {
        if (input.length() > MAX_INPUT_LENGTH) {
            throw new IllegalArgumentException(INPUT_OVER_LENGTH);
        }
    }

    public void duplicateCarName(String input) {

        boolean duplicationName = Arrays.stream(input.split(",")).distinct().count() != input.split(",").length;

        if (duplicationName) {
            throw new IllegalArgumentException(DUPLICATION_NAME);
        }
    }

    public String[] splitByDelimiter(String carNames) {
        return carNames.split(",");
    }

    public void convertStringToInt(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER);
        }
    }

    public void isPositiveNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER);
        }
    }


}
