package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public final class RandomGeneratorImpl implements RandomGenerator{

    private static final int MIN_BOUND = 0;
    private static final int MAX_BOUND = 9;
    @Override
    public int getRandomNumber() {
        return Randoms.pickNumberInRange(MIN_BOUND, MAX_BOUND);
    }
}
