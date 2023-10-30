package racingcar.tdd.model;

import static racingcar.tdd.config.RacingConfig.RANDOM_NUMBER_MAX;
import static racingcar.tdd.config.RacingConfig.RANDOM_NUMBER_MIN;
import static racingcar.tdd.config.RacingConfig.RANDOM_NUMBER_PASS_MIN;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberChecker {
    public static boolean generateRandomNumber() {
        int min = RANDOM_NUMBER_MIN.getValue();
        int max = RANDOM_NUMBER_MAX.getValue();
        int passMin = RANDOM_NUMBER_PASS_MIN.getValue();

        return Randoms.pickNumberInRange(min, max) >= passMin;
    }
}
