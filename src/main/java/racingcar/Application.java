package racingcar;

import racingcar.game.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RacingGame racingGame = new RacingGame(inputView, outputView);
        racingGame.start();
    }
}
