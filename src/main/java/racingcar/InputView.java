package racingcar;

import java.util.Arrays;

public class InputView {

    public RacingCars inputNameOfRacingCars(String namesOfCars) {
        String[] split = namesOfCars.split(",");
        return new RacingCars(Arrays.asList(split));
    }

    public AttemptNumber attemptNumber(String count) {
        return new AttemptNumber(count);
    }
}