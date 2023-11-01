package racingcar.domain;

import racingcar.domain.validator.Validator;

public class CarController {
    private Cars cars;

    private int moveChance;

    public void setStatus(Cars cars, int moveChance) {
        this.cars = cars;
        Validator.moveNumber(moveChance);
        this.moveChance = moveChance;
    }

    public void moveCars() {
        cars.move();
        moveChance--;
    }

    public boolean checkMoveChance() {
        return moveChance != 0;
    }
}
