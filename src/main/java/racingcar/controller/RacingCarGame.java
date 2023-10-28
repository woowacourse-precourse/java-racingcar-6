package racingcar.controller;

import racingcar.model.MovingCar;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGame {
    private MovingCar movingCar;

    public RacingCarGame() {
        movingCar = new MovingCar();
    }
    public

    public void moveCarForward() {
        if (movingCar.isCarMovingForward() == true) {
            OutputView.printExecutionResult();
        }
    }
}
