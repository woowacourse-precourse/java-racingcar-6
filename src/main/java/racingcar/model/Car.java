package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public record Car(String carName, int distance) {

    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
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
}
