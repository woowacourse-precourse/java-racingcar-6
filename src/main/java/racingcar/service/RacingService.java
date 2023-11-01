package racingcar.service;

import static racingcar.utils.Constants.FORWARD_THRESHOLD;

import racingcar.domain.Cars;
import racingcar.utils.RandomNumberGenerator;

public class RacingService {
    private final RandomNumberGenerator randomNumberGenerator;

    public RacingService() {
        this.randomNumberGenerator = new RandomNumberGenerator();
    }

    public void playRacing(Cars cars) {
        cars.moveCars(randomNumberGenerator, FORWARD_THRESHOLD);
    }

}
