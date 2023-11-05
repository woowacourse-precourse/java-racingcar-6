package racingcar.data.attempt;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumbers {
    private final List<Integer> numbers;
    private final int totalSize;
    private static final int RANGE_MIN = 0;
    private static final int RANGE_MAX = 9;
    private static final String OUT_OF_RANGE_EXCEPTION = "InputNumber should be between ";

    public RandomNumbers(int totalSize) {
        this.numbers = new ArrayList<>();
        this.totalSize = totalSize;
    }

    public void init() {
        for (int i = 0; i < totalSize; i++) {
            int randomNumber = Randoms.pickNumberInRange(RANGE_MIN, RANGE_MAX);
            validateRandomNumber(randomNumber);
            numbers.add(randomNumber);
        }
    }

    public int toIntByIndex(int index) {
        return numbers.get(index);
    }

    public static void validateRandomNumber(int number) {
        if (number < RANGE_MIN || RANGE_MAX < number) {
            throw new IllegalArgumentException(OUT_OF_RANGE_EXCEPTION + RANGE_MIN + " and " + RANGE_MAX + ".");
        }
    }
}
