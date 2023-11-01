package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Constants;

public class RandomUtils {
    public static int createRandomNumber() {
        return Randoms.pickNumberInRange(Constants.MIN_RANDOM_NUMBER, Constants.MAX_RANDOM_NUMBER);
    }

    public static boolean isMove(int randomNumber) {

        if (randomNumber <= Constants.MOVE_NUMBER) {
            return true;
        }
        return false;
    }
}
