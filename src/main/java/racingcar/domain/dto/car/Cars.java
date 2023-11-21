package racingcar.domain.dto.car;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.dto.CarDto;
import racingcar.domain.dto.RoundDto;
import racingcar.domain.move.Move;
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
        for (final Car car : cars) {
            final Move move = movePicker.pick();
            car.moveBy(move);
        }
    }

    public RoundDto toRoundDto() {
        final List<CarDto> carsDto = cars.stream()
                .map(Car::toCarDto)
                .toList();

        return new RoundDto(carsDto);
    }
}
