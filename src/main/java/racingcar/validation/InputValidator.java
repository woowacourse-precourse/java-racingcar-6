package racingcar.validation;

import racingcar.Constants;
public class InputValidator {
    public static void validateCarName(String name) {
        if (name.length() > Constants.CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("자동차 이름이 5글자를 초과해선 안됩니다.");
        }

        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름이 비어있거나 공백입니다.");
        }
    }

    public static void validateMovement(int movement) {
        if (movement <= 0) {
            throw new IllegalArgumentException("이동횟수가 0 이하입니다.");
        }
    }

    public static void validateInputFormat(String input) {
        if (input.endsWith(",")) {
            throw new IllegalArgumentException("입력형식이 올바르지 않습니다.");
        }
    }
}
