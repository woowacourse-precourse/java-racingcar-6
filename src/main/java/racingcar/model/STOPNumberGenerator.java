package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.util.Constants;

public class STOPNumberGenerator implements NumberGenerator {
    @Override
    public int generate() {
        return Randoms.pickNumberInRange(Constants.RANDOM_NUM_START, Constants.STOP_NUM_END);
    }
}
