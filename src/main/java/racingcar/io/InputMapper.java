package racingcar.io;

import racingcar.domain.Name;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;
import racingcar.domain.TryCount;

import java.util.Arrays;
import java.util.stream.Collectors;

public class InputMapper {

    private static final String RACING_CAR_NAMES_DELIMITER = ",";

    public RacingCars toRacingCars(final String input) {
        return Arrays.stream(input.split(RACING_CAR_NAMES_DELIMITER))
                .map(Name::new)
                .map(RacingCar::new)
                .collect(Collectors.collectingAndThen(Collectors.toList(), RacingCars::new));
    }

    public TryCount toTryCount(final String input) {
        return new TryCount(Integer.parseInt(input));
    }
}
