package racingcar.car;

import static racingcar.car.CarSetting.MAX_LENGTH_OF_NAME;

public class Car {
    private String name;
    private int distance;
    private boolean canMove;

    public Car(String name) throws IllegalArgumentException {
        if (checkValidCarName(name)) throw new IllegalArgumentException();

        this.name = name;
        this.distance = 0;
        this.canMove = false;
    }

    public String getCarName() {
        return this.name;
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
}
