package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

    private static final int MIN = 0;
    private static final int MAX = 9;

    public static int createRandomNumber() {
        return Randoms.pickNumberInRange(MIN, MAX);
    }
}
