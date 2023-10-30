package racingcar.domain;

import java.util.List;

public class CarController {
    private final List<Car> carList;

    private int moveChance;

    public CarController(CarFactory carFactory, int moveChance) {
        this.carList = carFactory.getCarList();
        this.moveChance = moveChance;
    }

    public void moveCars() {
        carList.forEach(Car::move);
        moveChance--;
    }

    public boolean checkMoveChance() {
        return moveChance != 0;
    }
}
