package racingcar.service;

import java.util.Arrays;
import racingcar.model.RacingCars;

public class RacingCarService {
    public static final String COMMA_SEPARATOR = ",";
    private final RacingCars racingCars;

    public RacingCarService(String carNames) {
        this.racingCars = new RacingCars(Arrays.asList(carNames.split(COMMA_SEPARATOR)));
    }
    
}
