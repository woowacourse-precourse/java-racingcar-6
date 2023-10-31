package racingcar.domain.car;

import java.util.List;
import racingcar.domain.car.dto.output.WinnersDto;

public final class CarsFinished extends Cars {
    public CarsFinished(final List<? extends Car> cars) {
        super(cars);
    }

    public WinnersDto toWinnersDto() {
        final List<? extends Car> reversed = reversed();
        final CarFinished leadingCar = (CarFinished) reversed.get(0);

        return new WinnersDto(reversed.stream()
                .filter(car -> ((CarFinished) car).isAtSameCoordinate(leadingCar))
                .map(car -> ((CarFinished) car).toWinnerDto())
                .toList()
        );
    }

    private List<? extends Car> reversed() {
        return cars.stream()
                .sorted((o1, o2) -> o2.coordinate.subtract(o1.coordinate))
                .toList();
    }


}
