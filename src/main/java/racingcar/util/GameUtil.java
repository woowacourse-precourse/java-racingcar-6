package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.Number;

public class GameUtil {
    public static int createRandomNumber() {
        return Randoms.pickNumberInRange(Number.MIN.getNumber(), Number.MAX.getNumber());
    }

    public static boolean moveOrStop(int number) {
        if (number >= Number.STANDARD.getNumber()) {
            return true;
        }
        return false;
    }
}
