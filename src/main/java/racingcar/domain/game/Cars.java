package racingcar.domain.game;

import java.util.Arrays;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    private Cars(String input) {
        this.cars = convertToCarList(input);
    }

    public static Cars of(String input) {
        return new Cars(input);
    }

    private List<Car> convertToCarList(String input) {
        return Arrays.stream(input.split(","))
                .map(Car::of)
                .toList();
    }
}
