package racingcar.util;

import static racingcar.exception.ExceptionMessage.MIN_EXCEED_MAX;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {

    private final int min;
    private final int max;

    public NumberGenerator(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int getRandomDigit() {
        if (min <= max) {
            return Randoms.pickNumberInRange(min, max);
        }
        throw new IllegalArgumentException(MIN_EXCEED_MAX);
    }
}
