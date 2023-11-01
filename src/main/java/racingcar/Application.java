package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.view.ConsoleInputView;
import racingcar.view.ConsoleOutputView;
import racingcar.view.View;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new ConsoleInputView();
        OutputView outputView = new ConsoleOutputView();
        View view = new View(inputView, outputView);
        RacingGameController racingGameController = new RacingGameController(view);
        racingGameController.play();
    }
}
