package racingcar.service;

import racingcar.domain.Cars;
import racingcar.utils.RandomNumberGenerator;

public class RacingService {
    private static final int FORWARD_THRESHOLD = 4;
    private final RandomNumberGenerator randomNumberGenerator;

    public RacingService() {
        this.randomNumberGenerator = new RandomNumberGenerator();
    }

    public void playRacing(Cars cars) {
        cars.moveCars(randomNumberGenerator, FORWARD_THRESHOLD);
    }

}
