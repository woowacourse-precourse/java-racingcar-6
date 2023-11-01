package racingcar.model;

import java.util.Random;
import racingcar.exception.CustomException;
import racingcar.message.ErrorMessages;

public class RandomGenerator {
    private static final Random random = new Random();

    public static int generateNumber(int min, int max) {
        validateInput(min, max);
        return generateRandomNumberInRange(min, max);
    }

    private static void validateInput(int min, int max) {
        CustomException.validateMinNotGreaterThanMax(max, min);
    }

    private static int generateRandomNumberInRange(int min, int max) {
        if (min == max) {
            return min;
        }
        return generateRandomNumberInRange(min, max);
    }
}