package racingcar.domain;

import racingcar.util.RandomNumberGenerator;

/**
 * 컨트롤러가 같이 Race 하는 Cars 들을 보내면
 * Race 는 Cars 들을 데리고, 1 라운드 Racing 을 시킨다.
 */

public class Race {

    private static final int MIN_FORWARD_THRESHOLD = 4;
    private static final int ONE_STEP = 1;

    public void runOneRound(final Cars cars) {
        for (Car car : cars.cars()) {
            int randomValue = RandomNumberGenerator.generateRandomNumber();
            if (randomValue >= MIN_FORWARD_THRESHOLD) {
                car.forward(ONE_STEP);
            }
        }
    }
}
