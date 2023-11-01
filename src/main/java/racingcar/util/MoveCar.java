package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;

public class MoveCar {

    public static void moveCar(Car car) {
        if (isMove()) {
            car.move();
        }
    }

    public static int makeRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public static boolean isMove() {
        return makeRandomNumber() >= 4;
    }
}
