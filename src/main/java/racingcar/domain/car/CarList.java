package racingcar.domain.car;

import java.util.List;
import java.util.stream.Collectors;

import static racingcar.Constant.*;

public class CarList {
    private final List<Car> carList;

    public CarList(List<Car> carList) {
        this.carList = carList;
    }

    //==비즈니스 로직==//
    public void move() {
        carList.forEach(Car::move);
    }

    public String winners() {
        int winnerPoint = winnerPoint();

        return MESSAGE_WINNER + IS +
                carList.stream()
                        .filter(car -> isWinner(car, winnerPoint))
                        .map(Car::getName)
                        .collect(Collectors.joining(OUTPUT_DELIM));
    }

    private int winnerPoint() {
        return carList.stream()
                .mapToInt(Car::getPoint)
                .max()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_WINNER_POINT));
    }

    private boolean isWinner(Car car, int winnerPoint) {
        return car.getPoint() == winnerPoint;
    }

    //==출력==//
    @Override
    public String toString() {
        return carList.stream()
                .map(car -> car + "\n")
                .collect(Collectors.joining());
    }

}
