package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.config.Config;

public class RandomUtil {

    public static int getRandomNumber() {
        int RandomNum = Randoms.pickNumberInRange(Config.MIN_VALUE, Config.MAX_VALUE);
        return RandomNum;
    }
}
