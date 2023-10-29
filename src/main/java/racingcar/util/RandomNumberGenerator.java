package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.constants.RacingCarGameConstants.MAX_RANDOM_NUMBER;
import static racingcar.constants.RacingCarGameConstants.MIN_RANDOM_NUMBER;

public class RandomNumberGenerator implements NumberGenerator{

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
    }
}
