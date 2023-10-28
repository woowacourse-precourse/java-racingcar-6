package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingCars {
    private final List<Car> cars;

    public RacingCars(List<String> inputCarNameList) {
        this.cars = createCars(inputCarNameList);
    }

    private List<Car> createCars(List<String> carNames) {
        List<Car> createdCars = new ArrayList<>();
        for (String carName : carNames) {
            createdCars.add(new Car(carName));
        }
        return createdCars;
    }

    public List<Car> getAllCars() {
        return Collections.unmodifiableList(cars);
    }
}