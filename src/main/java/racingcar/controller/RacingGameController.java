package racingcar.controller;

import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.game.RacingGame;
import racingcar.dto.RacingGameRequest;
import racingcar.dto.StatusResponse;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    public void run() {
        RacingGame racingGame = init();
        playGame(racingGame);
        endGame(racingGame);
    }

    private void endGame(RacingGame racingGame) {
        List<String> winner = racingGame.getWinner();
        OutputView.printWinner(winner);
    }

    private static void playGame(RacingGame racingGame) {
        OutputView.printPlayResultMessage();
        while (!racingGame.isEnd()) {
            racingGame.doRace();
            List<Car> status = racingGame.getStatus();
            OutputView.printStatus(new StatusResponse(status));
        }
    }

    private static RacingGame init() {
        String names = InputView.readCarNames();
        String count = InputView.readCount();

        RacingGameRequest request = new RacingGameRequest(names, count);
        return new RacingGame(request);
    }
}
