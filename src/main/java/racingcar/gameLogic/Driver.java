package racingcar.gameLogic;

import static racingcar.utils.Constants.MOVING_FORWARD;

import racingcar.models.Car;
import racingcar.utils.RandomNumbers;

public class Driver {
    private final Car car = new Car();

    public Driver(String carName) {
        car.setCarName(carName);
    }

    public String sayCarName() {
        return car.getCarName();
    }

    public int sayMovedDistance() {
        return car.getCarMileage();
    }

    public void pushPedal() {
        if (canMove()) {
            car.moveForward();
        }
    }

    private boolean canMove() {
        int randomNumber = requestRandomNumber();
        return randomNumber >= MOVING_FORWARD;
    }

    private int requestRandomNumber() {
        return RandomNumbers.generateZeroToNineDigit();
    }
}
