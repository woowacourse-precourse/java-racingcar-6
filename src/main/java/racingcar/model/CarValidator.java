package racingcar.model;

public class CarValidator {
    private static final Integer MIN_NAME_RANGE = 1;
    private static final Integer MAX_NAME_RANGE = 5;

    private static final String NAME_BLANK_ERROR = "빈값은 허용하지 않습니다.";
    private static final String NAME_RANGE_ERROR = "자동차 이름은 1글자 이상, 5글자 이하만을 허용합니다.";

    public static void validate(String name) {
        validateBlank(name);
        validateNameRange(name);
    }

    private static void validateNameRange(String name) {
        if (name.length() < MIN_NAME_RANGE || name.length() > MAX_NAME_RANGE) {
            throw new IllegalArgumentException(NAME_RANGE_ERROR);
        }
    }

    private static void validateBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(NAME_BLANK_ERROR);
        }
    }
}
