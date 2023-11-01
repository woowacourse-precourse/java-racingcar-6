package racingcar.util;

public class Validator {

    public void checkName(String name) {
        validateNameLength(name);
    }

    private void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

}
