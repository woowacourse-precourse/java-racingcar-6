package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class CarMovementController implements MovableStrategy {

    private static final int MAX_MOVABLE_NUMBER = 9;
    private static final int MIN_MOVABLE_NUMBER = 0;
    private static final int MOVABLE_CONDITION_NUMBER = 4;

    @Override
    public boolean isMovable() {
        return Randoms.pickNumberInRange(MIN_MOVABLE_NUMBER, MAX_MOVABLE_NUMBER) >= MOVABLE_CONDITION_NUMBER;
    }
}
