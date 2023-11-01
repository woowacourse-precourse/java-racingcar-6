package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
