package racingcar.validation;

public class CarNameValidator {
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;
    private static final String LENGTH_ERROR_MESSAGE = "자동차 이름은 1자 이상, 5자 이하만 가능합니다.";

    public static void checkValidLength(String name) {
        if (name == null || !isInRange(name)) {
            throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE);
        }
    }

    private static boolean isInRange(String name) {
        return name.length() >= MIN_LENGTH && name.length() <= MAX_LENGTH;
    }
}
