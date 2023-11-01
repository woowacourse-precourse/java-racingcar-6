package racingcar.game.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtil {

    public static Boolean isRandomBiggerThanEqual(int standard) {
        return (generateNew() >= standard);
    }

    private static int generateNew() {
        return Randoms.pickNumberInRange(0, 9);
    }

}
