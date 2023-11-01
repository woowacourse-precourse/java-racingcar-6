package racingcar.common;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtil {

    public static boolean isMoveForward() {
        int number = Randoms.pickNumberInRange(Constants.NUMBER_RANGE_MIN, Constants.NUMBER_RANGE_MAX);
        return number >= Constants.MOVE_FORWARD;
    }

}
