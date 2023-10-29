package racingcar;

import racingcar.validator.AttemptCountValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private Game game;

    public void play() {
        this.game = new Game(InputView.getCarNames());
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
