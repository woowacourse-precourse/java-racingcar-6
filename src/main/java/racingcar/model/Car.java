package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String carName;
    private Integer moveDistance;

    public Car(String inputName, Integer inputScore) {
        this.carName = inputName;
        this.moveDistance = inputScore;
    }

    public void move() {
        if (canMove()) {
            this.moveDistance++;
        }
    }

    public String getCarNameDistance() {
        return this.carName + "," + this.moveDistance;
    }

    private boolean canMove() {
        return 3 < Randoms.pickNumberInRange(0, 9);
    }
}
