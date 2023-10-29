package racingcar.validator;

public class CarNameValidator {

    private static void validateEmpty(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException("입력값은 비어있지 않아야 합니다.");
        }
    }
}
