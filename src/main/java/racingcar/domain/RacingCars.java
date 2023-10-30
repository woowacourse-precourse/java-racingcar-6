package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private static final String EMPTY_CAR_EXCEPTION = "존재하는 차가 없습니다.";
    private final List<RacingCar> racingCars;

    public RacingCars(List<String> carNames) {
        validate(carNames);
        racingCars = carNames.stream()
                .map(RacingCar::new)
                .collect(Collectors.toList());
    }

    private void validate(List<String> carNames) {
        if(carNames.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_CAR_EXCEPTION);
        }
    }
}
