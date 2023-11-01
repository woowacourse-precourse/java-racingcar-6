package racingcar.car;

import racingcar.game.Referee;

public class Car {
    private String carName;
    private Referee referee;
    private boolean isMoving;
    public Car(String carName, Referee referee) {
        this.carName = carName;
        this.referee = referee;
        this.isMoving = referee.isMovingCondition();
    }

    public String isMoveForward() {
        String step = "";
        if (isMoving) {
            step = "-";
        }
        return step;
    }

    public String getCarName() {
        return carName;
    }


}
