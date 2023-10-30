package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

    private RandomNumberGenerator() {
    }

    public static int generate() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
