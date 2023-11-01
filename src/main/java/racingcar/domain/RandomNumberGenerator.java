package racingcar.domain;

import static racingcar.domain.Constant.MAXIMUM_RANDOM_NUMBER;
import static racingcar.domain.Constant.MINIMUM_RANDOM_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {


    @Override
    public int generate() {
        return Randoms.pickNumberInRange(MINIMUM_RANDOM_NUMBER, MAXIMUM_RANDOM_NUMBER);
    }
}
