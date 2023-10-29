package racingcar.utils;

public class CarNamesInputValidator {
    public static void validate(String target) {
        validateIsNotBlank(target);
    }

    private static void validateIsNotBlank(String target) {
        if (target.isBlank()) {
            throw new IllegalArgumentException("자동차 이름을 입력해주세요.");
        }
    }
}
