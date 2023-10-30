package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.validator.AttemptCountValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private Game game;

    public void play(List<Car> cars) {
        this.game = new Game(cars);
        int attemptCount = AttemptCountValidator.validateAttemptCount(InputView.getAttemptCount());
        OutputView.printResultMessage();
        playAllRounds(attemptCount);
        OutputView.printWinnerMessage(game.getWinners());
    }

    private void playAllRounds(int attemptCount) {
        for (int i = 0; i < attemptCount; i++) {
            game.playOneRound();
            OutputView.printResult(game.getCars());
        }
    }
}
