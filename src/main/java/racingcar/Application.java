package racingcar;

import racingcar.controller.RacingGame;
import racingcar.view.ConsoleInputView;
import racingcar.view.ConsoleOutputView;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new ConsoleInputView();
        OutputView outputView = new ConsoleOutputView();
        RacingGame racingGame = new RacingGame(inputView, outputView);
        racingGame.run();
    }
}
