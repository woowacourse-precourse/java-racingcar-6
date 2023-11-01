package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMovingCar extends Car {

    private static final int MOVING_FORWARD = 4;
    private static final int MIN_MOVE_RANGE = 0;
    private static final int MAX_MOVE_RANGE = 9;

    public RandomMovingCar(String name) {
        super(name);
    }
    @Override
    public boolean isMovable() {
        return Randoms.pickNumberInRange(MIN_MOVE_RANGE, MAX_MOVE_RANGE) >= MOVING_FORWARD;
    }
}
