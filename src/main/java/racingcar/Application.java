package racingcar;

import racingcar.domain.*;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Car car = new Car();
        List<String> carNames = car.getNames();

        Attempt attempt = new Attempt();
        int attemptCount = attempt.getCount();

        MovingCondition movingCondition = new MovingCondition();

        RacingGame racingGame = new RacingGame(movingCondition);
        List<String> progressResults = racingGame.race(carNames, attemptCount);

        Winner winner = new Winner();
        List<String> winners = winner.findWinners(carNames, progressResults);
    }
}
