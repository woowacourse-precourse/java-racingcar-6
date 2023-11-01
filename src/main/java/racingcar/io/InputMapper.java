package racingcar.io;

import racingcar.constant.Delimiter;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;
import racingcar.domain.TryCount;

import java.util.Arrays;
import java.util.stream.Collectors;

public class InputMapper {

    public RacingCars toRacingCars(final String input) {
        return Arrays.stream(input.split(Delimiter.COMMA.toExpression()))
                .map(RacingCar::new)
                .collect(Collectors.collectingAndThen(Collectors.toList(), RacingCars::new));
    }

    public TryCount toTryCount(final String input) {
        return new TryCount(Integer.parseInt(input));
    }
}
