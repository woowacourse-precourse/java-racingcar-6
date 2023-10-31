package racingcar.utils;

import java.util.List;

public class Utils {
    private final static int MAXIMUM_CAR_NAME_LENGTH = 5;

    public static void validateStringLength(List<String> carNames) {
        for (String name : carNames) {
            if (name.length() > MAXIMUM_CAR_NAME_LENGTH) {
                throw new IllegalArgumentException("자동차의 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    public static void validateStringDigit(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("숫자를 입력해주세요.");
            }
        }
    }
}
