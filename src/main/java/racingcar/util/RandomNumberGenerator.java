package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    public int pickRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
