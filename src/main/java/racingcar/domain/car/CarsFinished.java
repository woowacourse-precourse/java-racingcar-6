package racingcar.domain.car;

import java.util.List;
import racingcar.domain.car.dto.output.WinnerNamesDto;
import racingcar.domain.coordinate.Coordinate;

public final class CarsFinished extends Cars {
    private CarsFinished(final List<? extends Car> cars) {
        super(cars);
    }

    public static CarsFinished from(final CarsRacing carsRacing) {
        return new CarsFinished(carsRacing.cars);
    }

    public WinnerNamesDto toWinnerNamesDto() {
        final List<String> winnerNames = getWinnerNames();
        return new WinnerNamesDto(winnerNames);
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
                .max((c1, c2) -> c1.coordinate.subtractAsInt(c2.coordinate))
                .get().coordinate;
    }
}
