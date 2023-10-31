package racingcar.car;

import static racingcar.car.CarSetting.CAN_MOVE_OVER_NUMBER;
import static racingcar.car.CarSetting.MAX_LENGTH_OF_NAME;

public class Car {
    private String name;
    private int distance;

    public Car(String name) throws IllegalArgumentException {
        if (checkValidCarName(name)) throw new IllegalArgumentException();

        this.name = name;
        this.distance = 0;
    }

    public String getCarName() {
        return this.name;
    }

    public int getCarDistance() {
        return this.distance;
    }

    private boolean checkValidCarName(String carName) {
        if (checkLengthOfName(carName)) return false;

        return true;
    }

    private boolean checkLengthOfName(String carName) {
        if (carName.length() == 0) return false;
        if (carName.length() > MAX_LENGTH_OF_NAME) return false;

        return true;
    }

    public void moveForwardOrNot(int random) {
        if (random > CAN_MOVE_OVER_NUMBER) distance++;
    }
}
