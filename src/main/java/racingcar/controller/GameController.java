package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.model.Game;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    Game game;
    InputView inputView;
    OutputView outputView;

    public GameController() {
        inputView = new InputView();
        outputView = new OutputView();
        game = new Game(getCarNames(), getTryCount());
    }

    private List<String> getCarNames() {
        outputView.display(outputView.INPUT_CAR_NAME_MESSAGE);
        return inputView.inputCarNames();
    }

    private int getTryCount() {
        outputView.display(outputView.INPUT_TRY_COUNT_MESSAGE);
        return inputView.inputTryCount();
    }

    public void start() {
        outputView.display(outputView.START_STEP_MESSAGE);
        runGame();
        outputView.displayWinner(getWinnerInfo());
    }

    private void runGame() {
        while (!game.isDone()) {
            game.step();
            outputView.display(game.getRaceInfo() + "\n");
        }
    }

    private String getWinnerInfo() {
        return game.getWinnersList().stream()
                .collect(Collectors.joining(", "));
    }
}
