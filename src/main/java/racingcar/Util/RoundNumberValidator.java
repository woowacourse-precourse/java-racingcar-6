package racingcar.Util;

public class RoundNumberValidator {
    public final String ROUND_NUM_STRING;

    public RoundNumberValidator(String roundNumString) {
        this.ROUND_NUM_STRING = roundNumString;
        validate();
    }

    public void validate() {
        isInt();
    }

    private void isInt() {

        if (!Rule.roundNumPattern.matcher(ROUND_NUM_STRING).matches()) {
            throw new IllegalArgumentException(Rule.ROUND_NUM_WRONG_ERROR);
        }
    }
}