package racingcar;

import racingcar.domain.Attempt;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Car car = new Car();
        List<String> carNames = car.getNames();

        Attempt attempt = new Attempt();
        int attemptCount = attempt.attemptNum();

        RacingGame racingGame = new RacingGame();
        racingGame.progress(carNames, attemptCount);
    }
}
