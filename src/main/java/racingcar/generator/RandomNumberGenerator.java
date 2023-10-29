package racingcar.generator;

import static racingcar.enums.RacingConfig.*;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {
    @Override
    public int generateNumber() {
        return Randoms.pickNumberInRange(RANDOM_NUMBER_MIN.getValue(), RANDOM_NUMBER_MAX.getValue());
    }
}
