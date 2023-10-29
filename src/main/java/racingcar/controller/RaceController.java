package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;

public class RaceController {
    private static final int MOVING_NUM = 4;

    public static boolean isMoving(Car car) {
        return createRandomNum() >= MOVING_NUM;
    }

    private static int createRandomNum() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
