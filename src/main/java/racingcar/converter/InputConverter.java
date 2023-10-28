package racingcar.converter;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.game.Car;
import racingcar.domain.game.Cars;

public class InputConverter {
    public Cars convertStringToCars(String input) {
        List<Car> cars = Arrays.stream(input.split(","))
                .map(Car::of)
                .toList();
        return Cars.of(cars);
    }

    public int covertStringToInteger(String input) {
        return Integer.parseInt(input);
    }
}
