package racingcar;

public class CarValidator {

    private static final int CAR_NAME_LENGTH = 5;

    // static 은 편의를 위해 작성한 것, 이후 삭제
    public static void validateNameLength(String input) {
        if (input.length() > CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5글자 이하여야 합니다.");
        }
    }

    public static void validateNameUsingCommas(String input) {
        if (input.matches(".*[^a-zA-Z0-9,\\s].*")) {
            throw new IllegalArgumentException("입력값은 숫자, 영문, 쉼표로만 구성되어야합니다.");
        }
    }
}
