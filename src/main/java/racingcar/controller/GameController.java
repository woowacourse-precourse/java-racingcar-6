package racingcar.controller;

import java.util.List;
import racingcar.model.Game;
import racingcar.model.GameFactory;
import racingcar.model.strategy.MoveStrategy;
import racingcar.util.CarNamesInputConverter;
import racingcar.util.NumberOfAttemptsInputConverter;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final MoveStrategy moveStrategy;
    private Game game;

    public GameController(InputView inputView, OutputView outputView, MoveStrategy moveStrategy) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.moveStrategy = moveStrategy;
    }

    public void run() {
        initializeGame();
    }

    private void initializeGame() {
        List<String> carNames = inputCarNames();
        int numberOfAttempts = inputNumberOfAttempts();
        this.game = GameFactory.createGame(carNames, numberOfAttempts, moveStrategy);
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
}
