package racingcar.domain.dto.car;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.move.MovePicker;

public final class Cars {
    private final List<Car> cars;

    private Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(final String input) {
        final List<Car> cars = Arrays.stream(input.split(","))
                .map(Car::from)
                .toList();

        return new Cars(cars);
    }

    // moveAllBy
    public void moveAllBy(final MovePicker movePicker) {

    }
}
