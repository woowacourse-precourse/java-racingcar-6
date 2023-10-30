package racingcar.gameLogic;

import racingcar.models.Car;
import racingcar.utils.RandomNumbers;

public class Driver {
    Car car = new Car();

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

        return randomNumber >= 4;
    }

    private int requestRandomNumber() {
        return RandomNumbers.generateZeroToNineDigit();
    }
}
