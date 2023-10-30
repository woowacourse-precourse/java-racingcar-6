package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.constant.Constants.*;

public class RandomManipulator {
    public static boolean isMove() {
        int randNum = Randoms.pickNumberInRange(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);

        return randNum >= CONDITION_RANDOM_VALUE;
    }
}
