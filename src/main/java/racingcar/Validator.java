package racingcar;

public class Validator {
    private void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    private void validateEmptyName(String name) {
        if (name.length() < 1) {
            throw new IllegalArgumentException();
        }
    }
}
