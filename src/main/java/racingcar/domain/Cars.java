package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> names, MovingStrategy movingStrategy) {
        this.cars = createCars(names, movingStrategy);
    }

    private List<Car> createCars(List<String> names, MovingStrategy movingStrategy) {
        return names.stream()
                .map(name -> new Car(movingStrategy, name, 0))
                .collect(Collectors.toList());
    }


}
