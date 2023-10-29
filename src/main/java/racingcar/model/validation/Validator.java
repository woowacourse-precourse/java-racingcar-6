package racingcar.model.validation;

public class Validator {
    protected Validator() {
    }

    public static void isEmpty(String string, String message) {
        if (string.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void hasSpace(String string, String message) {
        if (string.contains(" ")) {
            throw new IllegalArgumentException(message);
        }
    }

}
