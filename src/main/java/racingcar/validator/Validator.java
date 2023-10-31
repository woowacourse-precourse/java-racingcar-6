package racingcar.validator;

public class Validator {

    private final static int LENGTH_STANDARD = 5;

    public void checkLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("Length must be less or equal than" + LENGTH_STANDARD);
        }
    }
}
