package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class CarUtil {

    private static final int MORE_THAN_NUMBER = 4;
    private static final int START_RANDOM_NUMBER_RANGE = 0;
    private static final int FINISH_RANDOM_NUMBER_RANGE = 9;

    public static boolean isCanMove() {
        return CarUtil.getRandomValue() >= MORE_THAN_NUMBER;
    }

    private static int getRandomValue() {
        return Randoms.pickNumberInRange(START_RANDOM_NUMBER_RANGE, FINISH_RANDOM_NUMBER_RANGE);
    }
}
