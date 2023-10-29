package racingcar.generator;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.enums.RacingConfig;

public class RandomNumberGenerator implements NumberGenerator {
    @Override
    public int generateNumber() {
        return Randoms.pickNumberInRange(
                RacingConfig.RANDOM_NUMBER_MIN.getValue(), RacingConfig.RANDOM_NUMBER_MAX.getValue()
        );
    }
}
