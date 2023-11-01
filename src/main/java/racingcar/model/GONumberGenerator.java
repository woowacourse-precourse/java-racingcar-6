package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.util.Constants;

public class GONumberGenerator implements NumberGenerator {
    @Override
    public int generate() {
        return Randoms.pickNumberInRange(Constants.GO_NUM_START, Constants.RANDOM_NUM_END);
    }
}
