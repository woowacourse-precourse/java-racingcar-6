package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomForwardStrategy implements ForwardStrategy {
    private static final int MINIMUM_RANDOM_NUMBER = 0;
    private static final int MAXIMUM_RANDOM_NUMBER = 9;
    private static final int STANDARD_NUMBER = 4;

    @Override
    public boolean canMoveForward() {
        return Randoms.pickNumberInRange(MINIMUM_RANDOM_NUMBER, MAXIMUM_RANDOM_NUMBER) >= STANDARD_NUMBER;
    }
}
