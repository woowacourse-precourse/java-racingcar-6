package racingcar;

import racingcar.controller.CarRacingGameController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        CarRacingGameController.of(new InputView(), new OutputView())
                .playGame();

    }
}
