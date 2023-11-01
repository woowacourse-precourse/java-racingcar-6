package racingcar.utils;

import static racingcar.utils.Constants.LOWER_LIMIT_OF_DIGIT;
import static racingcar.utils.Constants.UPPER_LIMIT_OF_DIGIT;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumbers {
    private RandomNumbers() {
    }

    public static int generateZeroToNineDigit() {
        return Randoms.pickNumberInRange(LOWER_LIMIT_OF_DIGIT, UPPER_LIMIT_OF_DIGIT);
    }
}
