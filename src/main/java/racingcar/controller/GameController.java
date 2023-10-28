package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Game;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    public void run() {
        Game game = initGame();
        game.moveCars();

        OutputView.printGameResult(game.getResults());
        OutputView.printWinner(game.getWinner());
    }

    private static Game initGame() {
        return new Game(
                new RandomNumberGenerator(),
                Cars.from(InputView.readCarNames()),
                InputView.readANumberOfAttempts()
        );
    }
}
