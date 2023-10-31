package racingcar.controller.subcontroller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

public class MoveCarController {
    public void moveCar(Car car) {
        int rand = Randoms.pickNumberInRange(0, 9);
        if (rand >= 4) {
            car.addMoveCount();
        }
    }
}