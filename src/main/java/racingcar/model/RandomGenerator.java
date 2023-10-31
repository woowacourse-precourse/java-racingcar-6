package racingcar.model;

import java.util.Random;

public class RandomGenerator {
    private static final Random random = new Random();
    public static int generateNumber(int min, int max) {
        if (min == max) {
            return min;
        }
        return min + random.nextInt(max - min);
    }

    public static int[] generateNumbers(int cnt, int min, int max) {
        return generateNumbersRecursively(new int[cnt], 0, min, max);
    }

    private static int[] generateNumbersRecursively(int[] numbers, int index, int min, int max) {
            if (index == numbers.length) {
                return numbers;
            }
            numbers[index] = generateNumber(min, max);
            return generateNumbersRecursively(numbers, index + 1, min, max);
    }
}