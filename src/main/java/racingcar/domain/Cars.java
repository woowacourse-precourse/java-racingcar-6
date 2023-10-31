package racingcar.domain;

import racingcar.controller.dto.Result;
import racingcar.policy.MovingPolicy;
import racingcar.policy.NumberGeneratePolicy;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public Cars playGame(MovingPolicy movingPolicy, NumberGeneratePolicy numberGeneratePolicy) {
        return new Cars(cars.stream().map(car -> car.move(movingPolicy, numberGeneratePolicy))
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

}
