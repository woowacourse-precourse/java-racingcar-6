package racingcar.util;

import static racingcar.constant.NumberConstant.RANDOM_MAX_NUMBER;
import static racingcar.constant.NumberConstant.RANDOM_MIN_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {

    public int generateRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_MIN_NUMBER.getMessage(), RANDOM_MAX_NUMBER.getMessage());
    }
}
