package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.util.Validator;

public class RacingCars {
    private final List<Car> cars;

    public RacingCars(List<String> inputCarNameList) {
        validateNameList(inputCarNameList);
        this.cars = createCars(inputCarNameList);
    }

    private List<Car> createCars(List<String> carNameList) {
        List<Car> createdCars = new ArrayList<>();
        for (String carName : carNameList) {
            createdCars.add(new Car(carName));
        }
        return createdCars;
    }

    private void validateNameList(List<String> nameList) {
        Validator.validateDuplicateNames(nameList);
    }

    public List<Car> getAllCars() {
        return Collections.unmodifiableList(cars);
    }
}