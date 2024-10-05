package racingcar.view;

import java.util.Arrays;

public class InputValidation {

    public void readNameValidation(String input) {
        if (!input.contains(",") || lengthValidation(input) || nameValidation(input)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean lengthValidation(String input) {
        String[] names = input.split(",");
        for (String name : names) {
            if (name.length() > 5) {
                return true;
            }
        }
        return false;
    }

    private boolean nameValidation(String input) {
        String[] names = input.split(",");
        for (String name : names) {
            if (isNotAlphabet(name)) {
                return true;
            }
        }
        return false;
    }

    private boolean isNotAlphabet(String name) {
        return !name.matches("[a-zA-Z]+");

    }

    public void readCountValidation(String input) {
        if (isNotNumber(input) || Integer.parseInt(input) <= 0) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isNotNumber(String input) {
        return (input.matches("[\\D+]]"));
    }
}
