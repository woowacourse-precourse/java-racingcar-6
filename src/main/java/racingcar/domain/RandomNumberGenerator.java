package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.RandomNumberRange;

public class RandomNumberGenerator {
    public int getNumber() {
        return Randoms.pickNumberInRange(RandomNumberRange.START_INCLUSIVE.getValue(),
                RandomNumberRange.END_INCLUSIVE.getValue());
    }
}
