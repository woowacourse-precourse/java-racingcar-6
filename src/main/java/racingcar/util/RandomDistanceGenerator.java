package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomDistanceGenerator {
    public static int generateDistance() {
        int minValue = Integer.parseInt(Constants.GENERATE_RANDOM_MIN_VALUE.constant);
        int maxValue = Integer.parseInt(Constants.GENERATE_RANDOM_MAX_VALUE.constant);
        return Randoms.pickNumberInRange(minValue, maxValue);
    }
}
