package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public final class RacingCars {
    private static final int MIN_CAR_COUNT = 2;
    private static final String CAR_COUNT_EXCEPTION_MESSAGE =
            String.format("Error: 자동차의 개수는 %d대 이상이어야 합니다.", MIN_CAR_COUNT);

    private final List<Car> racingCars;

    public RacingCars(List<Car> racingCars) {
        validateCarCount(racingCars);
        this.racingCars = new ArrayList<>(racingCars);
    }

    public static void validateCarCount(List<Car> cars) {
        if (cars.size() < MIN_CAR_COUNT) {
            throw new IllegalArgumentException(CAR_COUNT_EXCEPTION_MESSAGE);
        }
    }
}
