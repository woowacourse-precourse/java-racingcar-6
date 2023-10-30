package racingcar.domain.car;

import java.util.List;
import java.util.stream.Collectors;

import static racingcar.Constant.*;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        checkEmpty(cars);
        this.cars = cars;
    }

    //==비즈니스 로직==//
    public void move() {
        cars.forEach(Car::move);
    }

    public String getWinnersString() {
        int winnerPoint = getWinnerPoint();

        return MESSAGE_WINNER + IS +
                cars.stream()
                        .filter(car -> isWinner(car.getPoint(), winnerPoint))
                        .map(Car::getName)
                        .collect(Collectors.joining(OUTPUT_DELIM));
    }

    private int getWinnerPoint() {
        return cars.stream()
                .mapToInt(Car::getPoint)
                .max()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_WINNER_POINT));
    }

    private boolean isWinner(int carPoint, int winnerPoint) {
        return carPoint == winnerPoint;
    }

    //==검증 로직==//
    private void checkEmpty(List<Car> cars) {
        if (cars.isEmpty())
            throw new IllegalArgumentException(ERROR_EMPTY_CAR_LIST);
    }

    //==출력==//
    @Override
    public String toString() {
        return cars.stream()
                .map(car -> car + "\n")
                .collect(Collectors.joining());
    }

}
