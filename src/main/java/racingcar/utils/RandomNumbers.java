package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumbers {
    private RandomNumbers() {
    }

    public static int generateZeroToNineDigit() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
