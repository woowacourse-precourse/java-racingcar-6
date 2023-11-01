package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Model {
    public static void moveCar(Car car) {
        if (canMove()) {
            car.setCarPosition();
        }
    }

    public static Boolean canMove() {
        int randomNum = Randoms.pickNumberInRange(0, 9);

        return randomNum >= 4;
    }
}
