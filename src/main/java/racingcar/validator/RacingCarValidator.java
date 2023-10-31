package racingcar.validator;

public class RacingCarValidator {
    private final int MAX_NAME_LENGTH = 5;

    public void validateName(String name) {
        if (name == null || name.isBlank() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
