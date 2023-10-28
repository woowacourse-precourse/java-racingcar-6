package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class CarAccelerator {

    private static final int MINIMUM_RANGE_OF_RANDOM_NUMBER = 0;
    private static final int MAXIMUM_RANGE_OF_RANDOM_NUMBER = 9;
    private static final int ACCELERATE_CRITERION = 4;

    public boolean shouldAccelerate() {
        if (Randoms.pickNumberInRange(MINIMUM_RANGE_OF_RANDOM_NUMBER,
            MAXIMUM_RANGE_OF_RANDOM_NUMBER) >= ACCELERATE_CRITERION) {
            return true;
        }

        return false;
    }
}
