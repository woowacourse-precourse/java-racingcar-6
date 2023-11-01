package racingcar.car;

import racingcar.game.Referee;

public class Car {
    private final String carName;
    private final Referee referee;

    public Car(String carName, Referee referee) {
        this.carName = carName;
        this.referee = referee;
    }

    public String goStep() {
        String step = "";
        if (referee.isMovingCondition()) {
            step = "-";
        }
        return step;
    }

    public String getCarName() {
        return carName;
    }

}
