package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.model.MovementCondition;
import racingcar.model.NumberGenerator;
import racingcar.model.RandomMovementCondition;
import racingcar.model.RandomNumberGenerator;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        MovementCondition movementCondition = new RandomMovementCondition(numberGenerator);
        InputView inputView = InputView.getInstance();
        RacingGameController racingGameController = new RacingGameController(inputView, movementCondition);
        racingGameController.run();
    }
}
