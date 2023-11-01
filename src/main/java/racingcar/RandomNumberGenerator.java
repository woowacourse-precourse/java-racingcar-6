package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    public static final int MIN_RANDOM_INTEGER = 0;
    public static final int MAX_RANDOM_INTEGER = 9;

    public Integer getRandomInteger() {
        return Randoms.pickNumberInRange(MIN_RANDOM_INTEGER,MAX_RANDOM_INTEGER);
    }
}
