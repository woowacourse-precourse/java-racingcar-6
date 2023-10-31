package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.config.GameRange;

public class RandomsWrapper implements RandomNumberGenerator{
    @Override
    public int pickNumberInRange() {
        return Randoms.pickNumberInRange(GameRange.MIN_RANGE_VALUE.getValue(), GameRange.MAX_RANGE_VALUE.getValue());
    }
}
