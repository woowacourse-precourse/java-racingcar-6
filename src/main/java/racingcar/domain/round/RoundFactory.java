package racingcar.domain.round;

import static racingcar.Constant.*;

public class RoundFactory {

    public Round create(String input) {
        int round = toInt(input);
        checkNegative(round);
        return new Round(round);
    }

    //==검증로직==//

    private int toInt(String input) {
        int round;
        try {
            round = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_INPUT_ROUND);
        }
        return round;
    }

    private void checkNegative(int round) {
        if (round < 0)
            throw new IllegalArgumentException(ERROR_INPUT_ROUND);
    }
}
