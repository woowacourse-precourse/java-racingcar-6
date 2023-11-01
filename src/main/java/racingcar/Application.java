package racingcar;

import racingcar.controller.GameController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        GameController game = GameController.makeGame(new InputView(), new OutputView());
        game.playGame();
    }
}
