package racingcar.domain.car;

import java.util.function.Supplier;
import racingcar.domain.car.carcomponent.TotalNumberToMove;

public class CarMovement {
    private final Cars cars;
    private final TotalNumberToMove totalNumberToMove;

    public CarMovement(Cars cars, TotalNumberToMove totalNumberToMove) {
        this.cars = cars;
        this.totalNumberToMove = totalNumberToMove;
    }

    public String moveCarsAndGetResult(Supplier<Boolean> moveOrNot) {
        String result = cars.moveCarAndGetResult(moveOrNot);
        totalNumberToMove.moveCar();
        return result;
    }

    public boolean isMovable() {
        return this.totalNumberToMove.canMoveCar();
    }

    public String getWinner() {
        return cars.getWinner();
    }
}
