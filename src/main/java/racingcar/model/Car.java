package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final String carName;
    private final int distance;

    public Car(String carName, int distance) {
        this.carName = carName;
        this.distance = distance;
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private boolean isCarMoving() {
        int randomNumber = generateRandomNumber();
        return randomNumber > 3;
    }

    public Car attemptMove() {
        if (isCarMoving()) {
            return new Car(carName, distance + 1);
        }
        return new Car(carName, distance);
    }

    public String getCarName() {
        return carName;
    }

    public int getDistance() {
        return distance;
    }
}
