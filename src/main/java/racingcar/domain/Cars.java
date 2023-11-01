package racingcar.domain;

import racingcar.controller.dto.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public Cars playGame(Rule rule) {
        return new Cars(cars.stream().map(car -> car.move(rule))
                .toList());
    }

    public List<Result> getResults() {
        return cars.stream()
                .map(car -> new Result(car.getCarName(), car.getPosition()))
                .toList();
    }

    public List<Result> calculateWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.isWinner(maxPosition))
                .map(car -> new Result(car.getCarName(), car.getPosition()))
                .toList();
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Cars cars1 = (Cars) object;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }

}
