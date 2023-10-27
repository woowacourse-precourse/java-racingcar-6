package racingcar.domain.car;

import java.util.List;
import racingcar.domain.game.CarsFinishedDto;
import racingcar.domain.move.Coordinate;

public final class CarsFinished extends Cars {
    private CarsFinished(final List<? extends Car> cars) {
        super(cars);
    }

    public static CarsFinished from(final CarsRacing carsRacing) {
        return new CarsFinished(carsRacing.cars);
    }

    public CarsFinishedDto toWinnersResult() {
        final List<String> winnerNames = getWinnerNames();
        return new CarsFinishedDto(winnerNames);
    }

    private List<String> getWinnerNames() {
        final Coordinate max = getMaxCoordinate();

        return cars.stream()
                .filter(car -> car.coordinate.isSameAs(max))
                .map(car -> car.carName.carName())
                .toList();
    }

    private Coordinate getMaxCoordinate() {
        return cars.stream()
                .max((c1, c2) -> c2.coordinate.subtractAsInt(c1.coordinate))
                .get().coordinate;
    }
}
