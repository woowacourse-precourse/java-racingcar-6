package racingcar.domain.numbergenerator;

import racingcar.RacingConst;
import racingcar.exception.RacingException;

public class MoveNumber {
    int number;

    public MoveNumber(int number) {
        validateNumber(number);
        this.number = number;
    }

    private void validateNumber(int number) {
        if (number < RacingConst.RACING_NUMBER_START || number > RacingConst.RACING_NUMBER_END) {
            throw RacingException.INVALID_NUMBERS.makeException();
        }
    }

    public boolean canMove() {
        return this.number >= RacingConst.RACING_NUMBER_MOVE;
    }
}
