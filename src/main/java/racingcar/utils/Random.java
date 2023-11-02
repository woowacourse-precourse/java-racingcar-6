package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Config;

public class Random {
    public static int setRandNum() {
        int randomNumber = Randoms.pickNumberInRange(Config.MIN_VALUE, Config.MAX_VALUE);
        return randomNumber;
    }
}
