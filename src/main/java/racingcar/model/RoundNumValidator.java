package racingcar.model;

public class RoundNumValidator {
    public final String ROUND_NUM_STRING;

    public RoundNumValidator(String roundNumString) {
        this.ROUND_NUM_STRING = roundNumString;
        validate();
    }
}
