package racingcar;

import java.util.regex.Pattern;

public class InputValidator {
    private final static int MAX_CAR_NAME_LENGTH = 5;

    public static boolean carName(String[] inputs) {
        for (String input : inputs)
            if (!Pattern.matches("^[a-zA-Z]*$", input) || input.length()>MAX_CAR_NAME_LENGTH || input.isEmpty()) {
                return false;
            }
        return true;
    }
}
