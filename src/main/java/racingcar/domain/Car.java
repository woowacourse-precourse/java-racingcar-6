package racingcar.domain;

import static racingcar.constant.Constant.CAR_MOVE_MARK;

public class Car {

    private String moveDistance;

    public Car() {
        this.moveDistance = "";
    }

    public void moving() {
        this.moveDistance += CAR_MOVE_MARK;
    }

    public String getMoveDistance() {
        return this.moveDistance;
    }

}
