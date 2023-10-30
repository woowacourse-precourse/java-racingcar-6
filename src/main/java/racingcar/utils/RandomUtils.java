package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.config.RandomConfig;

public class RandomUtils {

    public static String determinePositionByRandomNumber() {
        int randomNumber = makeRandomNumber();
        String position;
        if(randomNumber >= RandomConfig.DETERMINE_VALUE) {
            position = "STRAIGHT";
        }else {
            position = "STOP";
        }
        return position;
    }

    public static int makeRandomNumber() {
        return Randoms.pickNumberInRange(RandomConfig.MIN_VALUE, RandomConfig.MAX_VALUE);
    }

}
