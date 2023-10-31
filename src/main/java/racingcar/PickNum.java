package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class PickNum {
    public static int pickNum() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
