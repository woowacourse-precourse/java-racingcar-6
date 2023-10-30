package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<String> carNames) {
        cars = carNames.stream()
            .map(name -> new Car(name))
            .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
