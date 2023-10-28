package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomDistanceGenerator {

    private static final int MIN_RANDOM_VALUE = 0;
    private static final int MAX_RANDOM_VALUE = 9;
    private static final int MOVE_LIMIT = 4;

    private int generateRandomValue() {
        return Randoms.pickNumberInRange(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
    }

    public int moveDistance() {
        int randomValue = generateRandomValue();
        return randomValue >= MOVE_LIMIT ? randomValue : MIN_RANDOM_VALUE;
    }
}
