package racingcar.controller;

import racingcar.models.GameStatus;
import racingcar.service.Referee;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGame {

    private final Referee referee = new Referee();

    public void start() {
        List<String> carNames = InputView.readCarNames();
        int tryCount = InputView.readTryCount();

        referee.addCars(carNames);
        referee.startGame(tryCount);

        List<GameStatus> gameStatuses = referee.getGameStatuses();
        OutputView.printPerGameStatusesMessage(gameStatuses);

        List<String> winners = referee.getWinners();
        OutputView.printGameWinnersMessage(winners);
    }

}
