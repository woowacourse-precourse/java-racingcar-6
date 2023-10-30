package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.view.InputView;

public class Application {

    public static void main(String[] args) {
        // setting
        InputView inputView = new InputView();
        RacingGameController racingGameController = new RacingGameController();

        // start application
        // input car name event
        String carNames = inputView.inputCarNames();
        racingGameController.setCarName(carNames);

        // input attempt event
        String attempts = inputView.inputAttempts();
        racingGameController.setAttempts(attempts);

        // start event
        racingGameController.startGame();
    }
}
