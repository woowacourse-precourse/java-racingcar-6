package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberUtilImp implements RandomNumberUtil {

    @Override
    public int generate(final int startRangeNumber, final int endRangeNumber) {
        return Randoms.pickNumberInRange(startRangeNumber, endRangeNumber);
    }
}
