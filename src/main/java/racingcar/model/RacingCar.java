package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {

    private final String carName;
    private int currentPosition;

    public RacingCar(String carName) {
        this.carName = carName;
        this.currentPosition = 0;
    }

    public String getCarName() {
        return this.carName;
    }

    public int getCurrentPosition() {
        return this.currentPosition;
    }

    public void moveForwordOrNot() {
        if (canMoveForward()) {
            this.currentPosition += 1;
        }
    }

    private boolean canMoveForward() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber >= 4;
    }
}