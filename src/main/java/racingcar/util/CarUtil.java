package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class CarUtil {

    private static final int START_RANDOM_NUMBER_RANGE = 0;
    private static final int FINISH_RANDOM_NUMBER_RANGE = 9;

    public static int getRandomValue() {
        return Randoms.pickNumberInRange(START_RANDOM_NUMBER_RANGE, FINISH_RANDOM_NUMBER_RANGE);
    }
}
