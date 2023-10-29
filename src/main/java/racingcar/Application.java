package racingcar;

import racingcar.domain.Attempt;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.domain.Winner;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Car car = new Car();
        List<String> carNames = car.getNames();

        Attempt attempt = new Attempt();
        int attemptCount = attempt.getCount();

        RacingGame racingGame = new RacingGame();
        List<String> progressResults = racingGame.race(carNames, attemptCount);

        Winner winner = new Winner();
        winner.findWinners(carNames, progressResults);
    }
}
