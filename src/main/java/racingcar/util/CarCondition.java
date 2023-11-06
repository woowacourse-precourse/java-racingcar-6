package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class CarCondition {

    public boolean isMove(int seed) {
        return seed >= 4;
    }

    public int makeRandom() {
        return Randoms.pickNumberInRange(0, 9);
    }
}