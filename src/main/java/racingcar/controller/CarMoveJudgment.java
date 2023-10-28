package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.CarObject;

public class CarMoveJudgment {
    public static int result() {
        int moveNum;
        do {
            moveNum = Randoms.pickNumberInRange(0, 9);
        } while (moveNum <= CarObject.MOVE_CONDITION);
        return moveNum;
    }
}
