package racingcar.validator;

public class CarNameValidator {

    private static final String CAR_NAME_LENGTH_ERROR_MESSAGE = "자동차의 이름은 5자 이하만 가능합니다.";

    public static void validateCarNames(String[] splitNames) {
        for (String name : splitNames) {
            checkNameLength(name);
        }
    }

    private static void checkNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR_MESSAGE);
        }
    }
}
