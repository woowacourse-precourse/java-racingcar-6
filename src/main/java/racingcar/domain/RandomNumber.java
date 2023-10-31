package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {
    private final static int MINIMUM = 0;
    private final static int MAXIMUM = 9;

    public int createRandomNumber() {
        return Randoms.pickNumberInRange(MINIMUM, MAXIMUM);
    }
}
