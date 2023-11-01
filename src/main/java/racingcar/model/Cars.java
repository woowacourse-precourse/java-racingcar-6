package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.movement.MovementStrategy;

public class Cars {

    private static final int DEFAULT_DISTANCE = 0;
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars fromNames(List<String> carNames, MovementStrategy movementStrategy) {
        List<Car> cars = carNames.stream()
            .map(carName -> new Car(carName, DEFAULT_DISTANCE, movementStrategy))
            .collect(Collectors.toList());
        return new Cars(cars);
    }

    public Cars playRound() {
        List<Car> movedCars = new ArrayList<>();
        for (Car car : cars) {
            movedCars.add(car.attemptMove());
        }
        return new Cars(movedCars);
    }

    public int getMaxDistance() {
        return cars.stream()
            .mapToInt(Car::distance)
            .max()
            .orElse(0);
    }

    public List<Car> toList() {
        return Collections.unmodifiableList(cars);
    }

}
