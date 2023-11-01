package racingcar.controller;

import java.util.List;
import racingcar.model.Game;
import racingcar.model.GameFactory;
import racingcar.util.CarNamesInputConverter;
import racingcar.util.NumberOfAttemptsInputConverter;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final GameFactory gameFactory;
    private Game game;

    public GameController(InputView inputView, OutputView outputView, GameFactory gameFactory) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.gameFactory = gameFactory;
    }

    public void run() {
        initializeGame();
        playGame();
        displayWinners();
    }

    private void initializeGame() {
        List<String> carNames = inputCarNames();
        int numberOfAttempts = inputNumberOfAttempts();
        this.game = gameFactory.createGame(carNames, numberOfAttempts);
    }

    private List<String> inputCarNames() {
        outputView.displayInputCarNames();
        String input = inputView.inputCarNames();
        return CarNamesInputConverter.convert(input);
    }

    private int inputNumberOfAttempts() {
        outputView.displayInputNumberOfAttempts();
        String input = inputView.inputNumberOfAttempts();
        return NumberOfAttemptsInputConverter.convert(input);
    }

    private void playGame() {
        outputView.displayRoundResultHeader();
        while (game.hasRemainingRounds()) {
            game.playOneRound();
            outputView.displayRoundResult(game.getCars());
        }
    }

    private void displayWinners() {
        List<String> winnerNames = game.getWinnerNames();
        outputView.displayFinalWinner(winnerNames);
    }
}
