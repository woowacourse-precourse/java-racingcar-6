package racingcar.common;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator {
    public static Integer getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
