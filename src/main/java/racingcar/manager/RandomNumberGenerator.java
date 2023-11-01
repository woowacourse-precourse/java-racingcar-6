package racingcar.manager;

import camp.nextstep.edu.missionutils.Randoms;
import static racingcar.Vars.MIN_RANDOM_NUMBER;
import static racingcar.Vars.MAX_RANDOM_NUMBER;

public class RandomNumberGenerator {
    public static int generate() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
    }
}