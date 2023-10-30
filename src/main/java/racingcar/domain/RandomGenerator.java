package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator {

    private final int MIN_RANGE_NUM = 0;
    private final int MAX_RANGE_NUM = 9;

    public RandomGenerator() {
    }

    public int createRandomNumber() {
        return Randoms.pickNumberInRange(MIN_RANGE_NUM, MAX_RANGE_NUM);
    }

}
