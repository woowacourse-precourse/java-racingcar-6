package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public final class RandomGenerator {
    public static final int START_INCLUSIVE = 0;
    public static final int END_INCLUSIVE = 9;
    public static int pickNumber() {
        int randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
        return randomNumber;
    }
}
