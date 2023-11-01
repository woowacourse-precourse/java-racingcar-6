package racingcar.model;

import racingcar.exception.ErrorMessage;
import racingcar.exception.InvalidInputException;

public class NumberOfMove {

    private static final int MIN_NUMBER_OF_MOVE = 0;

    private final int numberOfMove;
    private int currentLap;

    private NumberOfMove(int numberOfMove) {
        this.numberOfMove = numberOfMove;
        currentLap = MIN_NUMBER_OF_MOVE;
    }

    public static NumberOfMove create(String input) {
        return new NumberOfMove(validate(input));
    }

    private static int validate(String input) {
        int number = toNumber(input);
        if (number < MIN_NUMBER_OF_MOVE) {
            throw InvalidInputException.with(ErrorMessage.INVALID_NUMBER);
        }
        return number;
    }

    private static int toNumber(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw InvalidInputException.with(ErrorMessage.INVALID_NUMBER);
        }
    }

    public boolean isLeft() {
        if (numberOfMove == currentLap) {
            return false;
        }
        currentLap++;
        return true;
    }
}
