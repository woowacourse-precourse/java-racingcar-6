package racingcar;

import racingcar.Controller.RacingGame;
import racingcar.Model.GameModel;
import racingcar.View.InputView;
import racingcar.View.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        GameModel gameModel = new GameModel();
        InputView inputView = new InputView();

        RacingGame racingGame = new RacingGame(gameModel, inputView, outputView);
        racingGame.startGame();
    }
}
