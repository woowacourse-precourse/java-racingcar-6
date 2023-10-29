package racingcar.validator;

public class CarNameValidator {

    public static void validateForString(String carNames) {
        validateEmptyForString(carNames);
        validateContainsCommaForString(carNames);
    }

    private static void validateEmptyForString(String carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("입력값은 비어있지 않아야 합니다.");
        }
    }

    private static void validateContainsCommaForString(String carNames) {
        if (!carNames.contains(",")) {
            throw new IllegalArgumentException("입력값은 쉼표(,)를 기준으로 구분되어야 합니다.");
        }
    }

}
