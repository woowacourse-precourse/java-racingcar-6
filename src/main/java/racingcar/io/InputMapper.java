package racingcar.io;

import java.util.Arrays;
import java.util.stream.Collectors;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;

public class InputMapper {

    private static final String RACING_CAR_NAMES_DELIMITER = ",";

    public RacingCars toRacingCars(final String input) {
        return Arrays.stream(input.split(RACING_CAR_NAMES_DELIMITER))
                .map(RacingCar::new)
                .collect(Collectors.collectingAndThen(Collectors.toList(), RacingCars::new));
    }
}
