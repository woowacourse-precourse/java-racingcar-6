package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Constants;

public class RandomUtils {
    public static int createRandomNumber(int minRandomNumber, int maxRandomNumber) {
        return Randoms.pickNumberInRange(minRandomNumber, maxRandomNumber);
    }

    public static boolean isMove(int randomNumber) {

        if (randomNumber <= Constants.MOVE_NUMBER) {
            return true;
        }
        return false;
    }
}
