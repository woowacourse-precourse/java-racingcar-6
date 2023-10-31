package racingcar.Util;

public class Validation {

    public static String validationEmpty(String input) {
        if (input.length() == 0) {
            ErrorCollection.IllegalEmptyInput();
        }

        return input;
    }

    public static int validationAttempts(String attempts) {
        int verifiedAttempts = -1;
        try {
            verifiedAttempts = Integer.parseInt(attempts);
            if (verifiedAttempts < 0)
                ErrorCollection.IllegalAttempts();
        } catch (NumberFormatException e) {
            ErrorCollection.IllegalAttempts();
        }

        return verifiedAttempts;
    }

    public static String validationCarName(String name) {
        if (name.length() > 5 ) {
            ErrorCollection.IllegalCarNames();
        }

        return name;
    }
}
