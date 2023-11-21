package racingcar.domain.car;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import racingcar.controller.dto.CarDto;
import racingcar.controller.dto.RoundDto;
import racingcar.controller.dto.WinnerDto;
import racingcar.controller.dto.WinnersDto;
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

    public void moveAllBy(final MovePicker movePicker) {
        for (final Car car : cars) {
            final Move move = movePicker.pick();
            car.moveBy(move);
        }
    }

    private int maxPosition() {
        return cars.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .orElseThrow(IllegalStateException::new)
                .getPosition();
    }

    public RoundDto toRoundDto() {
        final List<CarDto> carsDto = cars.stream()
                .map(Car::toCarDto)
                .toList();

        return new RoundDto(carsDto);
    }

    public WinnersDto toWinnersDto() {
        final int maxPosition = maxPosition();

        final List<WinnerDto> winners = cars.stream()
                .filter(c -> c.getPosition() == maxPosition)
                .map(Car::toWinnerDto)
                .toList();

        return new WinnersDto(winners);
    }
}
