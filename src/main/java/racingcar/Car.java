package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    public boolean canMove() {
        int random = Randoms.pickNumberInRange(0, 9);
        if (random >= 4) {
            return true;
        }
        return false;
    }
}
