package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private int getRandom() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public Boolean isGoingForward() {
        if (4 <= getRandom()) {
            return true;
        }
        return false;
    }
}
