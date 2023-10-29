package racingcar;

import java.util.regex.Pattern;

public class InputValidator {

    public boolean carNamesValidate (String carNames) {
        if(carNames.contains(" ")) {
            throw new IllegalArgumentException("Blank should not be included");
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
