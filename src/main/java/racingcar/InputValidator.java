package racingcar;

import java.util.regex.Pattern;

public class InputValidator {
    private static final int MAXIMUM_LENGTH_OF_NAME = 5;

    public boolean lengthOfCarNameValidate (String carName) {
        if(carName.length() > MAXIMUM_LENGTH_OF_NAME) {
            throw new IllegalArgumentException("The name must be no more than five characters long.");
        }
        return true;
    }

    public boolean gameCountValidate (String gameCount) {
        if (!Pattern.matches("^[0-9]", gameCount)) {
            throw new IllegalArgumentException("Only numbers can be entered");
        }
        return true;
    }
}
