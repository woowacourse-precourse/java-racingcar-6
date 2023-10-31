package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class Generator {
    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 9;

    public static int createRandomNumber() {
        return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
    }
}