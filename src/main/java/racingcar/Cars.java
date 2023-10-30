package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars;

    public Cars(List<String> names) {
        cars = names.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private class Car {
        private String name;
        private int count = 0;

        private Car(String name) {
            this.name = name;
        }
    }
}
