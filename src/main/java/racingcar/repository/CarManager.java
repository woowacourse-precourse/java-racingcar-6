package racingcar.repository;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class CarManager {
    private final List<Car> racingCars = new ArrayList<>();

    public void createCarList(List<String> inputCarNames) {
        for (final String carName : inputCarNames) {
            racingCars.add(new Car(carName));
        }
    }

    public List<Car> readCarList() {
        return racingCars;
    }
}