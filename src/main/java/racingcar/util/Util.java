package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class Util {
    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(Constant.MIN_RANDOM_NUM, Constant.MAX_RANDOM_NUM);
    }

    public static String createMarkString(int distance) {
        return Constant.OUTPUT_CAR_MOVE_MARK.repeat(distance);
    }
}
