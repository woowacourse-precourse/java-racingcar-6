package racingcar.model;

import racingcar.util.NumberGenerator;

public class RandomSingleNumber {
    private final int number;

    private RandomSingleNumber(int number) {
        this.number = number;
    }

    public static RandomSingleNumber of(int min, int max) {
        int number = NumberGenerator.getRandomDigit(min, max);

        return new RandomSingleNumber(number);
    }

    public boolean isAtLeast(int threshold) {
        return this.number >= threshold;
    }

    public int getNumber() {
        return number;
    }
}
