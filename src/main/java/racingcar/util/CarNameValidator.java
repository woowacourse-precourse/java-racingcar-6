package racingcar.util;

import java.util.Objects;

public class CarNameValidator {
    private static final int LENGTH_LIMIT = 5;

    public static void validate(String carName) {
        validateNullCheck(carName);
        validateLengthCheck(carName);
        validateNameCheck(carName);
    }

    private static void validateNameCheck(String carName) {
        if (carName.contains(" ")) {
            throw new IllegalArgumentException("이름에 공백이 존재할 수 없습니다.");
        }

    }

    private static void validateLengthCheck(String carName) {
        if (carName.length() > LENGTH_LIMIT) {
            throw new IllegalArgumentException(String.format("이름의 길이는 %d를 초과할 수 없습니다.", LENGTH_LIMIT));
        }
    }

    private static void validateNullCheck(String carName) {
        if (Objects.isNull(carName)) {
            throw new IllegalArgumentException("이름을 입력하지 않았습니다.");
        }
    }

}
