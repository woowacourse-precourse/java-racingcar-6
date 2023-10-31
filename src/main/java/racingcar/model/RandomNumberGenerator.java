package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    public static int makeNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
