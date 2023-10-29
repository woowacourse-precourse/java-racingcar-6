package racingcar;

import java.util.List;
import racingcar.util.CarListMaker;

public record Cars(List<Car> carList) {
    public static Cars getCarsFromNames(String names) {
        return new Cars(CarListMaker.makeCarList(names));
    }

    public Cars race() {
        List<Car> result = carList.stream()
                .map(Car::moveForward)
                .toList();

        return new Cars(result);
    }

    public List<Car> findWinners() {
        return carList.stream()
                .filter(this::isWinner)
                .toList();
    }

    private int getMaxLocation() {
        return carList.stream()
                .mapToInt(Car::location)
                .max()
                .orElse(0);
    }

    private boolean isWinner(Car car) {
        return car.location() == getMaxLocation();
    }
}
