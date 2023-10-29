package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

    private RandomNumberGenerator() {}

    public static int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
