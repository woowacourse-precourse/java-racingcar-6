package racingcar.service;

import racingcar.domain.Cars;

public class GameService {

    private final Rule rule;

    private final RandomNumberGenerator randomNumberGenerator;

    public GameService() {
        rule = new Rule();
        randomNumberGenerator = new RandomNumberGenerator();
    }

    public void playOnce(Cars cars) {
        cars.moveCars(rule,randomNumberGenerator);
    }
}

