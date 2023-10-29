package racingcar.generator;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.enums.RacingConfig.RANDOM_NUMBER_MAX;
import static racingcar.enums.RacingConfig.RANDOM_NUMBER_MIN;

public class RandomNumberGenerator implements NumberGenerator {
    @Override
    public int generateNumber() {
        return Randoms.pickNumberInRange(RANDOM_NUMBER_MIN.getValue(), RANDOM_NUMBER_MAX.getValue());
    }
}
