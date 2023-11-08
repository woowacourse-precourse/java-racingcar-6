package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements RandomNumber {

    private static final int RANDOM_NUMBER_START = 0;
    private static final int RANDOM_NUMBER_END = 9;
    private static final int RANDOM_NUMBER_TO_MOVE = 4;

    private int generate() {
        return Randoms.pickNumberInRange(RANDOM_NUMBER_START, RANDOM_NUMBER_END);
    }

    @Override
    public boolean isMovable() {
        return generate() >= RANDOM_NUMBER_TO_MOVE;
    }
}
