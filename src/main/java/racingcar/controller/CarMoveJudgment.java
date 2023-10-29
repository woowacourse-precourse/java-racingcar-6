package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.CarObject;

public class CarMoveJudgment {


    public static boolean isNull() {
        if(CarObject.carsSize == 0) {
            return true;
        }

        return false;
    }
}
