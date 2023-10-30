package racingcar.model;

import static racingcar.common.Constant.RAND_NUM_MAX_RANGE;
import static racingcar.common.Constant.RAND_NUM_MIN_RANGE;

import racingcar.util.NumberGenerator;

public class RandomSingleNumber {
    private final int number;

    private RandomSingleNumber(int number) {
        this.number = number;
    }

    public static RandomSingleNumber create() {
        int number = NumberGenerator.getRandomDigit(RAND_NUM_MIN_RANGE, RAND_NUM_MAX_RANGE);

        return new RandomSingleNumber(number);
    }

    public boolean isAtLeast(int threshold) {
        return this.number >= threshold;
    }
}
