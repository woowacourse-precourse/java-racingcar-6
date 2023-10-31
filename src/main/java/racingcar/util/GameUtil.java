package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.Number;

public class GameUtil {
    public static int createRandomNumber() {
        int random = Randoms.pickNumberInRange(Number.MIN.getNumber(), Number.MAX.getNumber());
        return random;
    }

    public static boolean moveOrStop(int number) {
        if (number >= Number.STANDARD.getNumber()) {
            return true;
        }
        return false;
    }
}
