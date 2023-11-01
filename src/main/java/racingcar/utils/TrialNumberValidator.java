package racingcar.utils;

import java.util.regex.Pattern;

public class TrialNumberValidator {
    public static final Pattern roundNumPattern = Pattern.compile("^[1-9][0-9]*$");
    public final String ROUND_NUM_STRING;

    public TrialNumberValidator(String roundNumString) {
        this.ROUND_NUM_STRING = roundNumString;
        validate();
    }

    public void validate() {
        isInt();
    }

    private void isInt() {
        if (!roundNumPattern.matcher(ROUND_NUM_STRING).matches()) {
            throw new IllegalArgumentException();
        }
    }
}
