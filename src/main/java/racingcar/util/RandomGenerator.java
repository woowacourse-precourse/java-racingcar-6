package racingcar.util;

import static racingcar.constant.Exception.OUT_OF_RANGE;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator {

    private static final int MINIMUM_NUMBER = 0;
    private static final int MAXIMUM_NUMBER = 9;

    public static int generateNumber() {
        int randomNumber = Randoms.pickNumberInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER);
        validateRange(randomNumber);

        return randomNumber;
    }

    private static void validateRange(int randomNumber) {
        if (randomNumber < MINIMUM_NUMBER || randomNumber > MAXIMUM_NUMBER) {
            throw new IllegalArgumentException(OUT_OF_RANGE.getMessage());
        }
    }

}

