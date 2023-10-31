package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class Util {
    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(Constant.MIN_RANDOM_NUM, Constant.MAX_RANDOM_NUM);
    }
}
