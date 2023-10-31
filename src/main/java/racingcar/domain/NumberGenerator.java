package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {

    private static final int RANDOM_NUMBER_MINIMUM = 0;
    private static final int RANDOM_NUMBER_MAXIMUM = 9;

    public static int createRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_NUMBER_MINIMUM, RANDOM_NUMBER_MAXIMUM);
    }
}
