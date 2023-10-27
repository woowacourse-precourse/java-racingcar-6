package racingcar.domain.car;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import racingcar.domain.car.carcomponent.TotalNumberToMove;

public class Cars {
    private final List<Car> cars;
    private final TotalNumberToMove totalNumberToMove;

    public Cars(List<Car> cars, TotalNumberToMove totalNumberToMove) {
        this.cars = cars;
        this.totalNumberToMove = totalNumberToMove;
    }

    public String moveCarsAndGetResult(Supplier<Boolean> moveOrNot) {
        cars.forEach(car -> car.move(moveOrNot.get()));
        totalNumberToMove.moveCar();
        return this.toString();
    }

    public boolean isMovable() {
        return this.totalNumberToMove.canMoveCar();
    }

    public String getWinner() {
        WinCars winCars = new WinCars();
        cars.forEach(winCars::checkCarWinGame);
        return winCars.getWinCars();
    }

    @Override
    public String toString() {
        return cars.stream()
                .map(Car::toString)
                .collect(Collectors.joining("\n"));
    }
}
