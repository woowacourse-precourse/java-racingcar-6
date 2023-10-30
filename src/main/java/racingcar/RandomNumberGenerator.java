package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    public static Integer getRandomNUmber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
