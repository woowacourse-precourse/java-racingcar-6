package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

    private static final int MINIMUM = 0;
    private static final int MAXIMUM = 9;
    public static int getRandomNumber() {
       return Randoms.pickNumberInRange(MINIMUM, MAXIMUM);
    }
}
