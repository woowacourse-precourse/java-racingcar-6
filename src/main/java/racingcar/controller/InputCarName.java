package racingcar.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import racingcar.model.CarObject;

public class InputCarName {
    public CarObject inputCarName() {
        String carName = readLine();
        CarObject.nameOf(Arrays.asList(carName.split(",")));

        //자동차 이름 예외처리

        return cars;
    } //Car class instance return

    public void selectCarCondition() {
        do {
            CarObject.carCondition = Randoms.pickNumberInRange(0, 9);
        } while (CarObject.carCondition <= CarObject.MOVE_CONDITION);
    }
}
