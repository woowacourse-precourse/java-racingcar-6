package racingcar.validator;

public class Validator {

    public static final int INPUT_NAME_LENGTH = 5;

    public static void validateName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름을 입력해야 합니다,");
        }
        if (name.length() > INPUT_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5글자 이하여야 합니다.");
        }
    }

    public static void validatePosition(String position) {
        if (!position.matches("[0-9]")) {
            throw new IllegalArgumentException("반복 횟수는 숫자만 입력이 가능합니다.");
        }
    }
}
