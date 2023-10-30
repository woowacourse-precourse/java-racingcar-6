package racingcar.domain.round;

import static racingcar.Constant.*;

public class RoundFactory {

    public Round create(String input) {
        int number = checkIsNumber(input);
        checkNegative(number);
        return new Round(number);
    }

    private void checkNegative(int number) {
        if (number < 0)
            throw new IllegalArgumentException(ERROR_INPUT_ROUND);
    }

    private int checkIsNumber(String input) {
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_INPUT_ROUND);
        }
        return number;
    }
}
