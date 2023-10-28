package racingcar;

import java.util.List;

public class CarGenerator {
    public Car generate(String name) {
        return new Car(name);
    }

    public List<Car> generate(List<String> names) {
        return names.stream()
                .map(this::generate)
                .toList();
    }
}
