package racingcar;

public class InputValidator {

    private static final int MAX_NAME_LENGTH = 5;

    public void validateName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public void validateTimes(int times) {
        if (times < 0) {
            throw new IllegalArgumentException();
        }
    }

}
