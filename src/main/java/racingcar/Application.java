package racingcar;

import racingcar.controller.RacingCarGameController;
import racingcar.model.RacingCarGameModel;
import racingcar.view.input.InputView;
import racingcar.view.output.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView userInputView = new InputView();
        OutputView userOutputView = new OutputView();
        RacingCarGameModel racingCarGameModel = new RacingCarGameModel();


        RacingCarGameController game = new RacingCarGameController(
                userInputView,
                userOutputView,
                racingCarGameModel
        );
        game.start();
    }
}
