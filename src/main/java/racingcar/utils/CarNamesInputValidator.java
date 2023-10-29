package racingcar.utils;

public class CarNamesInputValidator {
    public static void validate(String target) {
        validateIsNotBlank(target);
        validateFirstCharacterIsNotComma(target);
        validateLastCharacterIsNotComma(target);

        String[] elements = target.split(",");
        validateEachElementIsNotBlank(elements);
        validateEachElementCorrectLength(elements);
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

    private static void validateLastCharacterIsNotComma(String target) {
        if (target.charAt(target.length() - 1) == ',') {
            throw new IllegalArgumentException("마지막 문자로 콤마(,)를 입력하면 안됩니다.");
        }
    }

    private static void validateEachElementIsNotBlank(String[] targets) {
        for (String target : targets) {
            if (target.isBlank()) {
                throw new IllegalArgumentException("공백 문자로만 입력하면 안됩니다.");
            }
        }
    }

    private static void validateEachElementCorrectLength(String[] targets) {
        for (String target : targets) {
            if (target.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5글자 이하여야 합니다.");
            }
        }
    }
}
