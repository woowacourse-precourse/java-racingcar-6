package racingcar.validate;

import racingcar.domain.Constants;

public class CarNameValidate {
    public static void validateCarName(String name) {
        isCarNameLength(name);
        isCommaPresent(name);
    }

    private static void isCarNameLength(String name) {
        if (name.length() >= Constants.MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5글자 이하로만 입력해주세요.");
        }
    }

    private static void isCommaPresent(String name) {
        if (name.contains(" ")) {
            throw new IllegalArgumentException("자동차 이름에 공백을 제외해주세요.");
        }
    }
}
