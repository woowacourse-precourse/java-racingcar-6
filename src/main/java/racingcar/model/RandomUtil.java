package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtil {
    public static boolean moveForwardOrNot() {
        return getRandomInt() >= 4;
    }

    private static int getRandomInt() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
