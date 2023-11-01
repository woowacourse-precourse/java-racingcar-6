package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class GameUtil {
    private static final int RANDOM_MIN = 1;
    private static final int RANDOM_MAX = 9;

    public static int randomNumber() {
        return Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX);
    }
}
