package racingcar.controller;

import java.util.List;
import racingcar.domain.Game;
import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private final GameService gameService = new GameService();

    public void run() {
        Game game = setUpGame();
        play(game);
    }

    public Game setUpGame() {
        outputView.printInputRacingCarNames();
        List<String> carNames = inputView.carNameListInput();

        outputView.printInputTotalAttempts();
        int totalAttempts = inputView.totalAttemptsInput();

        return gameService.createGame(carNames, totalAttempts);
    }

    private void play(Game game) {
        outputView.printRunResult();

        while (!game.isGameEnd()) {
            gameService.playSingleRound(game);
            outputView.printGameProgress(game.getRacingCarList());
        }

        List<String> winners = gameService.findWinners(game);
        outputView.printWinners(winners);
    }

}
