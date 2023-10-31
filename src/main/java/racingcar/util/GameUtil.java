package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class GameUtil {
    private static final int RANDOM_MIN = 1;
    private static final int RANDOM_MAX = 9;
    private static final int MOVE_CONDITION = 4;

    public static boolean move() {
        return MOVE_CONDITION <= randomNumber();
    }

    private static int randomNumber() {
        return Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX);
    }
}
