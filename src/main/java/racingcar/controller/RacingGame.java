package racingcar.controller;

import racingcar.model.Game;
import racingcar.model.User;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGame {

    private final User user;
    private final Game game;

    public RacingGame() {
        this.user = new User();
        this.game = new Game();
    }

    public void gameStart() {
        user.inputCarNames();

        user.inputTryCount();
    }

    public void executionResult() {
        List<String> carNames = user.getCarNamesList();

        game.StringListChangeCarList(carNames);

        int tryCount = user.getTryCount();

        OutputView.outputRunResult();

        game.showCarAdvancedResult(tryCount);
    }

    public void finalWinner() {
        game.showFinalWinCar();
    }
}
