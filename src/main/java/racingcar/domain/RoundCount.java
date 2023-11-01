package racingcar.domain;

import static racingcar.util.GameConstants.LAST_ROUND;
import static racingcar.util.Utils.convertStringToInt;
import static racingcar.util.Validator.validateEmpty;
import static racingcar.util.Validator.validateInteger;
import static racingcar.util.Validator.validateAboveZero;

public class RoundCount {
    private int roundCount;

    private RoundCount(int convertedUserInput) {
        this.roundCount = convertedUserInput;
    }

    public static RoundCount store(String userInput) {
        validateEmpty(userInput);
        validateInteger(userInput);
        validateAboveZero(userInput);
        int convertedUserInput = convertStringToInt(userInput);

        return new RoundCount(convertedUserInput);
    }

    public boolean hasRemain() {
        roundCount--;
        return roundCount >= LAST_ROUND.getValue();
    }
}
