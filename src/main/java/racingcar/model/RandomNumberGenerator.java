package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {
    @Override
    public int generate() {
        return Randoms.pickNumberInRange(Constants.RANDOM_NUM_START, Constants.RANDOM_NUM_END);
    }
}
