package racingcar.converter;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.game.car.Car;
import racingcar.domain.game.car.CarName;
import racingcar.domain.game.car.Cars;

public class InputConverter {
    public Cars convertStringToCars(String input) {
        List<Car> cars = Arrays.stream(input.split(","))
                .map(CarName::from)
                .map(Car::from)
                .toList();

        return Cars.from(cars);
    }

    public int covertStringToInteger(String input) {
        return Integer.parseInt(input);
    }
}
