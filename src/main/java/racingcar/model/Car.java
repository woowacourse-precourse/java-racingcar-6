package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private String forwardMovementState;
    private int randomNumber;

    public Car(String name) {
        this.name = name;
        this.forwardMovementState = "";
    }

    public void pickRandomNumber() {
        this.randomNumber = Randoms.pickNumberInRange(0, 9);
    }

    public boolean checkRandomNumber() {
        return this.randomNumber >= 4;
    }

    public void forward() {
        this.forwardMovementState += "-";
    }
}
