package racingcar.util;

import static racingcar.exception.ExceptionMessage.MIN_EXCEED_MAX;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {

    public static int getRandomDigit(int min, int max) {
        if (min <= max) {
            return Randoms.pickNumberInRange(min, max);
        }
        throw new IllegalArgumentException(MIN_EXCEED_MAX);
    }
}
