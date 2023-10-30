package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.view.ConsoleInputView;
import racingcar.view.ConsoleOutputView;
import racingcar.view.IOView;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.View;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new ConsoleInputView();
        OutputView outputView = new ConsoleOutputView();
        View view = new IOView(inputView, outputView);
        RacingGameController racingGameController = new RacingGameController(view);
        racingGameController.play();
    }
}
