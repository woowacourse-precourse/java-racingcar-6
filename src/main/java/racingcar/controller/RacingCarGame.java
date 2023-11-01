package racingcar.controller;

import racingcar.config.GameConfig;
import racingcar.domain.*;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

import static racingcar.util.GameInputReader.readExistLine;
import static racingcar.util.GameInputReader.readInt;
import static racingcar.util.InputConvertUtils.carNamesToNameList;

public class RacingCarGame {

    private MovingStrategy movingStrategy;

    public RacingCarGame(GameConfig gameConfig) {
        this.movingStrategy = gameConfig.getMovingStrategy();
    }

    public void play() {
        Cars cars = getCars();
        Attempt attempt = getAttempt();

        race(cars, attempt);
        OutputView.printWinners(getGameResult(cars));
    }

    private Cars getCars() {
        InputView.printDemandCarNames();
        return new Cars(readCarNames());
    }

    private List<String> readCarNames() {
        return carNamesToNameList(readExistLine());
    }

    private static Attempt getAttempt() {
        InputView.printDemandAttemptCount();
        return new Attempt(readInt());
    }

    private void race(Cars cars, Attempt attempt) {
        OutputView.printStartToShowResult();

        for (int i = 0; i < attempt.count(); i++) {
            cars.tryToMove(movingStrategy);
            OutputView.printMovingResults(cars);
        }
    }

    private GameResult getGameResult(Cars cars) {
        GameReferee referee = new GameReferee();
        return referee.totalGame(cars);
    }
}
