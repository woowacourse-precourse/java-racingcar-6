package racingcar.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.util.Validator;

public class RacingCars {
    private final List<Car> cars;

    public RacingCars(List<String> inputCarNameList) {
        validateNameList(inputCarNameList);
        this.cars = createCars(inputCarNameList);
    }

    private List<Car> createCars(List<String> carNameList) {
        return carNameList.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }


    private void validateNameList(List<String> nameList) {
        Validator.validateDuplicateNames(nameList);
    }

    public List<Car> getAllCars() {
        return Collections.unmodifiableList(cars);
    }
}