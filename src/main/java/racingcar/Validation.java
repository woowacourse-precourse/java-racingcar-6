package racingcar;

import static racingcar.Utils.checkSize;

import java.util.ArrayList;

public class Validation {
    public static void validateLengthOfName(String input) {
        if (checkSize(input) == Constants.MIN_NAME_LENGTH || checkSize(input) > Constants.MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차의 이름을 1자 이상, 5자 이하로 설정해주세요.");
        }
    }

    public static void isNotNumber(String digit) {
        if (!Character.isDigit(digit.charAt(0))) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    public static void endsWithComma(String input) {
        if (input.endsWith(",")) {
            throw new IllegalArgumentException("올바르지 않은 입력이에요.");
        }
    }

    public static void isEmpty(ArrayList<String> input) {
        if (input.isEmpty()) { // 입력된 문자열이 비어있을 경우
            throw new IllegalArgumentException("올바르지 않은 입력이에요.");
        }
    }
}
