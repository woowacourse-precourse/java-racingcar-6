package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {
    private RandomNumber() {
    }

    public static int generateRandomNumber() {
        return Randoms.pickNumberInRange(Constants.MIN_INPUT_RANGE, Constants.MAX_INPUT_RANGE);
    }
}
