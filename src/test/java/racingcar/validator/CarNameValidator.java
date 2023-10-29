package racingcar.validator;

public class CarNameValidator {

    public static void validateForString(String carName) {
        validateEmpty(carName);
        validateContainsComma(carName);
    }

    private static void validateEmpty(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException("입력값은 비어있지 않아야 합니다.");
        }
    }

    private static void validateContainsComma(String carName) {
        if (!carName.contains(",")) {
            throw new IllegalArgumentException("입력값은 쉼표(,)를 기준으로 구분되어야 합니다.");
        }
    }
}
