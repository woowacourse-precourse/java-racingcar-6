package racingcar.domain;

import static racingcar.utils.Constants.Right_Number_MESSAGE;

import java.util.regex.Matcher;
import racingcar.utils.Constants;

public class RoundNumberValidator {
    private String roundNumber;

    public RoundNumberValidator(String roundNumber) {
        this.roundNumber = roundNumber;
        validate();
    }

    private void validate() {
        isNumber();
    }

    public void isNumber() {
        Matcher matcher = Constants.ROUND_NUMBER_PATTERN.matcher(roundNumber);
        if (!matcher.find()) {
            throw new IllegalArgumentException(Right_Number_MESSAGE);
        }
    }
}
