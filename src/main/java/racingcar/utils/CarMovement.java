package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class CarMovement implements Movement {
    private static final Integer MIN_NUMBER_RANGE = 0;
    private static final Integer MAX_NUMBER_RANGE = 9;
    private static final Integer MOVE_STANDARD = 4;


    @Override
    public boolean canMove() {
        int number = Randoms.pickNumberInRange(MIN_NUMBER_RANGE, MAX_NUMBER_RANGE);
        return number >= MOVE_STANDARD;
    }
}
