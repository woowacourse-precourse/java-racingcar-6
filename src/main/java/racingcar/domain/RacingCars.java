package racingcar.domain;

import java.util.List;
import racingcar.domain.car.Car;

public final class RacingCars {
    private static final int MIN_CAR_COUNT = 2;
    private static final String CAR_COUNT_EXCEPTION_MESSAGE =
            String.format("Error: 자동차의 개수는 %d대 이상이어야 합니다.", MIN_CAR_COUNT);

    private final List<Car> racingCars;

    public RacingCars(List<Car> racingCars) {
        this.racingCars = racingCars.stream()
                .map(Car::create)
                .toList();

        validateCarCount();
    }

    private void validateCarCount() {
        if (racingCars.size() < MIN_CAR_COUNT) {
            throw new IllegalArgumentException(CAR_COUNT_EXCEPTION_MESSAGE);
        }
    }

    public void driveCars() {
        racingCars.forEach(Car::drive);
    }

    public List<Car> getCars() {
        return racingCars.stream()
                .map(Car::create)
                .toList();
    }
}
