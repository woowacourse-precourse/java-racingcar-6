package racingcar.validator;

public class Validator {
    public static void validateSeparatedByComma(String carNames) {
        if (!carNames.contains(",")) {
            throw new IllegalArgumentException("자동차 이름은 쉼표(,)를 기준으로 구분해주세요.");
        }
    }
}
