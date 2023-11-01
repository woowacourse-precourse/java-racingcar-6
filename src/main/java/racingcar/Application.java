package racingcar;

import racingcar.controller.Racing;
import racingcar.model.movement.Movement;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        Movement movement = new Movement();
        Racing racing = new Racing(inputView, outputView, movement);
        racing.run();
    }
}
