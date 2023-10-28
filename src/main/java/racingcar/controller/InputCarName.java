package racingcar.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import racingcar.model.CarObject;

public class InputCarName {
    public void inputCarName() {
        String carName = readLine();
        CarObject.nameOf(CarNameJudgment.splitOf(carName));
    }

    public void selectCarCondition() {
        do {
            CarObject.carCondition = Randoms.pickNumberInRange(0, 9);
        } while (CarObject.carCondition <= CarObject.MOVE_CONDITION);
    }
}
