package racingcar.utils;

public class Validator {
    private static final Validator validator = new Validator();

    private Validator() {
    }

    public static Validator getInstance() {
        return validator;
    }

    public void carNames(final String carNames) {
        if (carNames.isBlank()) {
            throw new IllegalArgumentException("자동차의 이름은 1글자 이상이어야 합니다.");
        }
        if (!carNames.contains(",")) {
            throw new IllegalArgumentException("두 개 이상의 자동차 이름을 쉼표로 구분하여 입력해주세요.");
        }
    }
}
