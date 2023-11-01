package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private final List<Car> cars;

    public RacingCars(List<String> inputCarNameList) {
        this.cars = createCars(inputCarNameList);
    }

    private List<Car> createCars(List<String> carNameList) {
        return carNameList.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
