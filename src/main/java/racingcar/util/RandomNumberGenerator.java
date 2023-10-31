package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements RandomGenerator {

    private static final int MIN_RANGE = 0;
    private static final int MAX_RANGE = 9;
    private static final int MAXIMUM_FORWARD_NUMBER = 4;

    @Override
    public boolean isCanMove() {
        int randomNumber = Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE);
        return randomNumber >= MAXIMUM_FORWARD_NUMBER;
    }
}
