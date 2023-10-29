package racingcar.utils;

public class CarNamesInputValidator {
    public static void validate(String target) {
        validateIsNotBlank(target);
        validateFirstCharacterIsNotComma(target);
    }

    private static void validateIsNotBlank(String target) {
        if (target.isBlank()) {
            throw new IllegalArgumentException("자동차 이름을 입력해주세요.");
        }
    }

    private static void validateFirstCharacterIsNotComma(String target) {
        if (target.charAt(0) == ',') {
            throw new IllegalArgumentException("첫 번째 문자로 콤마(,)를 입력하면 안됩니다.");
        }
    }
}
