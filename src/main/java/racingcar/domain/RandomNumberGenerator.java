package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.utils.Constants;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(
                Constants.MIN_NUMBER_RANGE, Constants.MAX_NUMBER_RANGE);
    }
}
