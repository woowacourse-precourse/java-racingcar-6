package racingcar.util;

public class Validator {

    public void checkName(String name) {
        validateNameLength(name);
        validateNameBlank(name);
    }

    private void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNameBlank(String name) {
        if (name.contains(" ")) {
            throw new IllegalArgumentException();
        }
    }

}
