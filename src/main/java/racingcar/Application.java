package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(final String[] args) {
        final InputView inputView = InputView.getInstance();
        final OutputView outputView = OutputView.getInstance();
        final RacingGameController racingGameController = new RacingGameController(inputView, outputView);
        racingGameController.play();
    }
}
