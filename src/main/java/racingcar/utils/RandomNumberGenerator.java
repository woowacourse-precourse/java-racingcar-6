package racingcar.utils;

import static racingcar.constant.PositionConstant.LOW_BOUND;
import static racingcar.constant.PositionConstant.HIGH_BOUND;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(LOW_BOUND.getValue(), HIGH_BOUND.getValue());
    }
}
