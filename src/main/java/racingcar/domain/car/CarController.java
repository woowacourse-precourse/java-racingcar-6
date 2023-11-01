package racingcar.domain.car;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.Constant.*;

public class CarController {

    private static boolean canForward() {
        int randomNumber = Randoms.pickNumberInRange(START, END);
        return randomNumber >= MOVING_FORWARD;
    }

    public static void move(Car car) {
        if (canForward())
            car.forward();
    }
}
