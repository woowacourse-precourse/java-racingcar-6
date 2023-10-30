package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator {
    public static final int MIN_NUMBER = 0;
    public static final int MAX_NUMBER = 9;

    public int createNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }
}
