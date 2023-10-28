package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.common.Size;
import racingcar.entity.Car;

public class Moving {

    public void moveOrStop(Car car) {
        int condition = Randoms.pickNumberInRange(Size.ROLL_MIN.getValue(), Size.ROLL_MAX.getValue());
        if (condition >= Size.MOVING_BOUNDARY.getValue()) {
            car.move();
        }
    }

}
