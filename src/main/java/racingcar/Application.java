package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RacingGameController racingGameController = new RacingGameController(inputView, outputView);
        racingGameController.runRacingGame();
    }
}
