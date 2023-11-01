package racingcar.car;

import racingcar.car.RandomNumber;

public class MoveConditionCar {
    public static boolean isMoving() {
        return RandomNumber.pickRandomNumber() >= 4;
    }
}
