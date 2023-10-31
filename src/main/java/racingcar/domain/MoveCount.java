package racingcar.domain;

import static racingcar.constant.CarConstant.MAX_MOVE_COUNT;
import static racingcar.constant.CarConstant.MIN_MOVE_COUNT;

import racingcar.validator.Validator;

/*
 *  시도할 횟수를 담당
 * */

public class MoveCount {
    private final int count;

    private MoveCount(String input) {
        validate(input);
        this.count = Integer.parseInt(input);
    }

    public static MoveCount fromInput(String input) {
        return new MoveCount(input);
    }

    private void validate(String input) {
        Validator.commandToInteger(input);
        Validator.commandValueInRange(Integer.parseInt(input), MIN_MOVE_COUNT, MAX_MOVE_COUNT);
    }


    public int getCount() {
        return count;
    }
}
