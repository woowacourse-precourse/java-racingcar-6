package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

    private RandomNumberGenerator() {}

    static public int generateRandomNumber() {
        return Randoms.pickNumberInRange(0,9);
    }
}
