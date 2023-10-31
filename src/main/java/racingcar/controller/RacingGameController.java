package racingcar.controller;

import racingcar.domain.game.RacingGame;
import racingcar.dto.RacingGameRequest;
import racingcar.dto.StatusResponse;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    public void run() {
        RacingGame racingGame = initRacingGame();
        playGame(racingGame);
        endGame(racingGame);
    }

    private RacingGame initRacingGame() {
        return new RacingGame(new RacingGameRequest(InputView.readCarNames(), InputView.readCount()));
    }

    private void playGame(RacingGame racingGame) {
        OutputView.printPlayResultMessage();
        while (isNotEnd(racingGame)) {
            racingGame.doRace();
            OutputView.printStatus(new StatusResponse(racingGame.getStatus()));
        }
    }

    private static boolean isNotEnd(RacingGame racingGame) {
        return !racingGame.isEnd();
    }

    private void endGame(RacingGame racingGame) {
        OutputView.printWinner(racingGame.getWinner());
    }
}
