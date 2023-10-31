package racingcar;

public class InputValidator {

    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_TIMES = 1;

    public void validateName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public void validateTimes(int times) {
        if (times < MIN_TIMES) {
            throw new IllegalArgumentException();
        }
    }

}
