package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberUtils {
    private static final int START_RANGE_NUMBER = 0;
    private static final int END_RANGE_NUMBER = 9;

    private RandomNumberUtils() {
    }

    public static int createRandomNumber() {
        return Randoms.pickNumberInRange(START_RANGE_NUMBER, END_RANGE_NUMBER);
    }
}
