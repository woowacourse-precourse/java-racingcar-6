package racingcar.data;

import camp.nextstep.edu.missionutils.Randoms;

public class InputNumber {
    private int randomNumber;
    private static final int RANGE_MIN = 0;
    private static final int RANGE_MAX = 9;
    private static final String OUT_OF_RANGE = "InputNumber should be between ";

    public void initRandomNumber() {
        int number = Randoms.pickNumberInRange(RANGE_MIN, RANGE_MAX);
        validateInputNumber(number);
        randomNumber = number;
    }

    public static void validateInputNumber(int number) {
        if (number < RANGE_MIN || RANGE_MAX < number) {
            throw new IllegalArgumentException(OUT_OF_RANGE + RANGE_MIN + " and " + RANGE_MAX + ".");
        }
    }
}
