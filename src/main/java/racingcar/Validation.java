package racingcar;

import static racingcar.Utils.checkSize;

public class Validation {
    private Validation() {
    }

    public static void validateLengthOfName(String input) {
        if (checkSize(input) == Constants.MIN_NAME_LENGTH || checkSize(input) > Constants.MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차의 이름을 1자 이상, 5자 이하로 설정해주세요.");
        }
    }

    public static void endsWithComma(String input) {
        if (input.endsWith(",")) {
            throw new IllegalArgumentException("이름 마지막에 ,(comma)를 붙이지 말아주세요.");
        }
    }

    public static void isNotNumber(String digit) {
        if (digit != null && !Character.isDigit(digit.charAt(0))) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    public static void isEmpty(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("아무 값도 입력하지 않았어요.");
        }
    }
}
