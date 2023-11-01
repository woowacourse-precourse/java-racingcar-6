package racingcar;

import racingcar.controller.RacingController;
import racingcar.utils.CarMovement;
import racingcar.utils.Movement;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Movement movement = new CarMovement();

        RacingController racingController = new RacingController(inputView, outputView, movement);
        racingController.run();
    }
}
