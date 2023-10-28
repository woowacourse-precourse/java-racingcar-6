package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public static Cars fromNames(List<String> carNames) {
        List<Car> cars = carNames.stream()
            .map(carName -> new Car(carName, 0))
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

    public List<Car> toList() {
        return Collections.unmodifiableList(cars);
    }

}
