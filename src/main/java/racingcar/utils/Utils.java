package racingcar.utils;

import static racingcar.config.Constants.RANGE_MAX;
import static racingcar.config.Constants.RANGE_MIN;

import camp.nextstep.edu.missionutils.Randoms;

public class Utils {
    public static int generateRandomNumber() {
        return Randoms.pickNumberInRange(RANGE_MIN, RANGE_MAX);
    }

}
