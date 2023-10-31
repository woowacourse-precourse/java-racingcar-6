package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.utils.Constants;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(
                Constants.MINIMUM_NUMBER_RANGE, Constants.MAXIMUM_NUMBER_RANGE);
    }
}
