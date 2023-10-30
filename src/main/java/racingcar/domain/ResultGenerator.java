package racingcar.domain;

import java.util.List;

public class ResultGenerator {

    private ResultGenerator() {}

    public static List<Car> generate(List<Car> cars) {
        int max = cars.stream()
                .mapToInt(Car::getPosition)
                .max().getAsInt();
        return cars.stream().filter(car -> car.getPosition() >= max).toList();
    }
}
