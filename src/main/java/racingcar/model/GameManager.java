package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class GameManager {
    public Cars createCars(List<String> carsName) {
        List<Car> carsTempHolder = carsName
                .stream()
                .map(Car::new)
                .collect(Collectors.toList());
        return new Cars(carsTempHolder);
    }
}
