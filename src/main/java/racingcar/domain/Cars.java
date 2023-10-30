package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars;

    private Cars(List<Car> list) {
        this.cars = list;
    }

    public static Cars createdByName(List<String> carNames) {
        List<Car> list = carNames.stream()
            .map(Car::new)
            .collect(Collectors.toList());

        return new Cars(list);
    }
}
