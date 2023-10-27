package util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator {

    private static final int MINIMUM_NUMBER = 0;
    private static final int MAXIMUM_NUMBER = 9;
    private static final String OUT_OF_RANGE = "시스템 내부에서 범위를 벗어난 값이 입력되었습니다.";

    public static int generateNumber() {
        int randomNumber = Randoms.pickNumberInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER);
        validateRange(randomNumber);

        return randomNumber;
    }

    private static void validateRange(int randomNumber) {
        if (randomNumber < MINIMUM_NUMBER || randomNumber > MAXIMUM_NUMBER) {
            throw new IllegalArgumentException(OUT_OF_RANGE);
        }
    }

}

