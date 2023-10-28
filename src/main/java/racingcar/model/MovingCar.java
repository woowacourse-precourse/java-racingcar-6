package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import static constant.MessgeList.MOVING_FORWARD;

public class MovingCar {
    public MovingCar() {
    }

    public boolean movingForward() {
        int random = Randoms.pickNumberInRange(0, 9);
        if (random >= MOVING_FORWARD) {
            return true;
        }
        return false;
    }
}
