package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Random {
    public static int getRandom() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            return 1;
        }
        return 0;
    }
}
