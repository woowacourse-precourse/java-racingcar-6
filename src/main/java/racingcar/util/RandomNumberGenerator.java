package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {
    public int createRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
