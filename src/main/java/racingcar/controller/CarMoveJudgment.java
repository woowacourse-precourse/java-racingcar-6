package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.CarObject;

public class CarMoveJudgment {
    public static void setCarOnceMoveDistance() {
        do {
            CarObject.carOnceMove = Randoms.pickNumberInRange(0, 9);
        } while (CarObject.carOnceMove <= CarObject.MOVE_CONDITION);
    }
}
