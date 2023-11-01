package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator {
    public static int createRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
