package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class CarCondition {

    public boolean isMove() {
        return makeRandom() >= 4;
    }

    public int makeRandom() {
        return Randoms.pickNumberInRange(0, 9);
    }
}