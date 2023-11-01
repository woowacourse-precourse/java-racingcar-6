package racingcar.domain.car;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.Constant.*;

public class CarController {

    public void moveCars(Cars cars) {
        cars.getCars().forEach(this::move);
    }

    private boolean canForward() {
        int randomNumber = Randoms.pickNumberInRange(START, END);
        return randomNumber >= MOVING_FORWARD;
    }

    private void move(Car car) {
        if (canForward())
            car.forward();
    }
}
