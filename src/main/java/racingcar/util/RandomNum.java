package racingcar.util;

import static racingcar.util.GameNumber.RANDOM_END;
import static racingcar.util.GameNumber.RANDOM_START;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNum {

    public static int generate() {
        return Randoms.pickNumberInRange(RANDOM_START, RANDOM_END);
    }
}
