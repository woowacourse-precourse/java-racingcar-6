package racingcar.domain.car;

import java.util.List;
import racingcar.domain.car.dto.input.CreateCarsRacing;
import racingcar.domain.car.dto.output.CarsRacingDto;
import racingcar.domain.move.MoveCommander;

public final class CarsRacing extends Cars {
    private CarsRacing(final List<CarRacing> cars) {
        super(cars);
    }

    public static CarsRacing from(final List<CarRacing> cars) {
        return new CarsRacing(cars);
    }

    public static CarsRacing from(final CreateCarsRacing createCarsRacing) {
        final List<CarRacing> cars = createCarsRacing
                .carNames()
                .stream()
                .map(CarRacing::new)
                .toList();

        return new CarsRacing(cars);
    }

    public CarsFinished toFinished() {
        return new CarsFinished(
                cars.stream()
                        .map(car -> ((CarRacing) car).toFinished())
                        .toList()

        );
    }

    public CarsRacingDto toCarsRacingDto() {
        return new CarsRacingDto(
                cars.stream()
                        .map(c -> ((CarRacing) c).toDto())
                        .toList()
        );

    }

    public void moveAllBy(final MoveCommander moveCommander) {
        for (final Car car : cars) {
            final CarRacing carRacing = (CarRacing) car;
            carRacing.moveBy(moveCommander.nextCommand());
        }
    }
}
