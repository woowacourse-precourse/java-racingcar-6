package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.config.GameConfig.RANDOM_NUMBER_RANGE_END;
import static racingcar.config.GameConfig.RANDOM_NUMBER_RANGE_START;

public class RandomUtil {

    private RandomUtil() {

    }

    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_NUMBER_RANGE_START.getNumber(), RANDOM_NUMBER_RANGE_END.getNumber());
    }
}
