package racingcar.domain;

import java.util.List;

public class CarController {
    private final List<Car> carList;

    private int moveChance;

    public CarController(List<Car> carList, int moveChance) {
        this.carList = carList;
        this.moveChance = moveChance;
    }

    public void moveCars() {
        carList.forEach(Car::move);
        moveChance--;
    }

    public boolean checkChance() {
        return moveChance != 0;
    }
}
