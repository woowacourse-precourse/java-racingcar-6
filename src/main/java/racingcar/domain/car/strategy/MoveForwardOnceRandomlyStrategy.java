package racingcar.domain.car.strategy;

import camp.nextstep.edu.missionutils.Randoms;

public class MoveForwardOnceRandomlyStrategy implements CarMovementStrategy {

    private static final int MIN_RANDOM_VALUE = 0;
    private static final int MAX_RANDOM_VALUE = 9;
    private static final int FORWARD_STANDARD_VALUE = 4;
    private static final int MOVE_INCREMENT_VALUE = 1;
    private static final int STOP_INCREMENT_VALUE = 0;

    public int getIncrementValue() {
        int randomValue = getRandomValue();
        boolean moveForward = isOverForwardStandard(randomValue);
        if (moveForward) {
            return MOVE_INCREMENT_VALUE;
        }
        return STOP_INCREMENT_VALUE;
    }

    private int getRandomValue() {
        return Randoms.pickNumberInRange(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
    }

    private boolean isOverForwardStandard(int value) {
        return value >= FORWARD_STANDARD_VALUE;
    }

}
