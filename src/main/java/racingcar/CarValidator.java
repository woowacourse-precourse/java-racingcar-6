package racingcar;

public class CarValidator {

    private static final int CAR_NAME_LENGTH = 5;

    public void validateNameLength(String input) {
        if (input.length() > CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("이름이 5자 이하지 않습니다.");
        }
    }

    public void validateNameUsingCommas(String input) {
        if (input.matches(".*[^a-zA-Z0-9,\\s].*")) {
            throw new IllegalArgumentException("쉼표 외 특수기호 사용 불가합니다.");
        }
    }
}
