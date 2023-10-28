package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingCars {
    private final List<Car> cars;

    public RacingCars(List<String> carNames) {
        this.cars = initializeCars(carNames);
    }

    private List<Car> initializeCars(List<String> carNames) {
        List<Car> participateCars = new ArrayList<>();
        for (String carName : carNames) {
            participateCars.add(new Car(carName, new Engine()));
        }
        return participateCars;
    }

    public List<Car> doRace() {
        for (Car car : this.cars) {
            car.moveCar();
        }
        return Collections.unmodifiableList(cars);
    }
}
