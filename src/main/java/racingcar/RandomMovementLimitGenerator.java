package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMovementLimitGenerator {
    public static int value() {
        return Randoms.pickNumberInRange(0,9);
    }
}
