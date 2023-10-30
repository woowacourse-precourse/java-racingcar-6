package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class CarList {
    private final List<Car> carList;

    public CarList(List<Car> carList) {
        this.carList = carList;
    }

    private void validate(List<Car> carList) {
        List<String> carNames = carList.stream()
                .map(car -> car.getName())
                .collect(Collectors.toList());
        CarNameValidator.validate(carNames);
    }

}
