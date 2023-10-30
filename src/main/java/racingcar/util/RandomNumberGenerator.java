package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.RandomNumberUtil;

public class RandomNumberGenerator implements RandomNumberUtil {

    @Override
    public int generate(int startRangeNumber, int endRangeNumber) {
        return Randoms.pickNumberInRange(startRangeNumber, endRangeNumber);
    }
}
