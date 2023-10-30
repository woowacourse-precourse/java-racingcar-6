package racingcar.domain;

import static racingcar.util.GameConfig.LAST_ROUND;
import static racingcar.util.Utils.convertStringToInt;
import static racingcar.util.Validator.validateEmpty;
import static racingcar.util.Validator.validateInteger;
import static racingcar.util.Validator.validatePositive;

public class RoundCount {
    private int roundCount;

    private RoundCount(String userInput) {
        validateEmpty(userInput);
        validateInteger(userInput);
        validatePositive(userInput);

        this.roundCount = convertStringToInt(userInput);
    }

    public static RoundCount store(String userInput) {
        return new RoundCount(userInput);
    }
    public boolean hasRemainRound() {
        roundCount--;
        return roundCount >= LAST_ROUND.getValue();
    }

}
