package racingcar.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(String carNames) {

        this.cars = parseCarNames(carNames);
    }

    public Cars(List<Car> cars) {

        this.cars = cars;
    }

    public List<Car> getCars() {

        return Collections.unmodifiableList(this.cars);
    }

    public void move(CarMovementStrategy carMovementStrategy) {

        this.cars.stream()
                .filter(car -> carMovementStrategy.isMovable())
                .forEach(Car::move);
    }

    public Cars findWinners() {

        int winnersPosition = getCarPosition();

        return new Cars(cars.stream()
                .filter(car -> car.getPosition() == winnersPosition)
                .collect(Collectors.toList()));
    }

    private List<Car> parseCarNames(String carNames) {

        return Arrays.stream(carNames.split(","))
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private int getCarPosition() {

        return cars.stream()
                .mapToInt(Car::getPosition)
                .max().orElse(0);
    }
}
