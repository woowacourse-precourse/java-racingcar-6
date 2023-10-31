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

    private void endGame(RacingGame racingGame) {
        OutputView.printWinner(racingGame.getWinner());
    }

    private static void playGame(RacingGame racingGame) {
        OutputView.printPlayResultMessage();
        while (!racingGame.isEnd()) {
            racingGame.doRace();
            OutputView.printStatus(new StatusResponse(racingGame.getStatus()));
        }
    }

    private static RacingGame initRacingGame() {
        return new RacingGame(new RacingGameRequest(InputView.readCarNames(), InputView.readCount()));
    }
}
