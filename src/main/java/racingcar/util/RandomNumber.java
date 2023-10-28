package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {
    private RandomNumber() {
    }

    public static int generateSingleDigit() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
