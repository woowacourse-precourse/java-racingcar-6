package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberUtilImp implements RandomNumberUtil {

    @Override
    public int generate(int startRangeNumber, int endRangeNumber) {
        return Randoms.pickNumberInRange(startRangeNumber, endRangeNumber);
    }
}
