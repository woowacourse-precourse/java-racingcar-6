package racingcar.model;

import java.util.List;
import racingcar.constants.ExceptionMessage;
import racingcar.dto.RoundResult;
import racingcar.dto.Winners;
import racingcar.util.WinnersNameExtractor;

public class RacingGame {
    private Cars cars;

    public void generateCars(String inputNames) {
        cars = new Cars(inputNames);
    }

    public RoundResult playRound() {
        checkGameIsStarted();
        cars.attemptForward();
        return cars.getRoundResult();
    }

    private void checkGameIsStarted() {
        if (isNotStarted()) {
            throw new NullPointerException(ExceptionMessage.NULL_GAME_ACCESS.message());
        }
    }

    private boolean isNotStarted() {
        return cars == null;
    }

    public Winners getWinners() {
        checkGameIsStarted();
        return toWinners(cars.findWinningCars());
    }

    private Winners toWinners(List<Car> winnersCar) {
        return WinnersNameExtractor.INSTANCE.extractName(winnersCar);
    }
}