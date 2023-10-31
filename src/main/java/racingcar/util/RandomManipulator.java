package racingcar.util;

import static racingcar.constant.Constants.CONDITION_RANDOM_VALUE;
import static racingcar.constant.Constants.MAX_RANDOM_VALUE;
import static racingcar.constant.Constants.MIN_RANDOM_VALUE;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomManipulator {
    public boolean isMove() {
        int randNum = Randoms.pickNumberInRange(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);

        return randNum >= CONDITION_RANDOM_VALUE;
    }
}
