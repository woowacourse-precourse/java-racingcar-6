package racingcar.model;

import java.util.Random;

public class RandomGenerator {
    private static final Random random = new Random();

    public static int generateNumber(int min, int max) {
        validateInput(min, max);
        return generateRandomNumberInRange(min, max);
    }

    private static void validateInput(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("최소값은 최대값보다 크지 않아야 합니다.");
        }
    }

    private static int generateRandomNumberInRange(int min, int max) {
        if (min == max) {
            return min;
        }
        return generateRandomNumberInRange(min, max);
    }
}