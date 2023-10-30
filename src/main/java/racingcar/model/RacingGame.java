package racingcar.model;

import java.util.ArrayList;
import java.util.List;

import racingcar.dto.CarDto;

public class RacingGame {
    private final List<Car> carList = new ArrayList<>();

    public void addCar(final Car car) {
        carList.add(car);
    }

    public void moveCar() {
        for (final Car car : carList) {
            car.moveForward();
        }
    }

    public List<CarDto> getResult() {
        return carList.stream()
                .map(CarDto::from)
                .toList();
    }

    public List<CarDto> getWinners() {
        final int winnerPosition = findWinnerPosition();
        return carList.stream()
                .filter(car -> car.isWinner(winnerPosition))
                .map(CarDto::from)
                .toList();
    }

    private int findWinnerPosition() {
        return carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
