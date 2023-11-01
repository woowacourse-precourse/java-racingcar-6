package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {
    public static final int RANDOM_MAX = 9;
    public static final int RANDOM_MIN = 0;
    public static final int MOVABLE_MIN = 4;

    public static int generateRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX);
    }
}
