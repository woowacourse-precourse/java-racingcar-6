package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final String carName;
    private final int position;

    public Car(String carName, int position) {
        this.carName = carName;
        this.position = position;
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
            return new Car(carName, position + 1);
        }
        return new Car(carName, position);
    }
}
