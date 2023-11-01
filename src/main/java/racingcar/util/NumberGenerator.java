package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {

    public static int[] generateRandomNumbers(int size) {
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = Randoms.pickNumberInRange(1, 9);
        }

        return numbers;
    }

}
