package racingcar.generator;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.enums.RacingConfig.MAX_RANDOM_NUMBER;
import static racingcar.enums.RacingConfig.MIN_RANDOM_NUMBER;

public class RandomNumberGenerator implements NumberGenerator {
    @Override
    public int generateNumber() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER.getValue(), MAX_RANDOM_NUMBER.getValue());
    }
}
