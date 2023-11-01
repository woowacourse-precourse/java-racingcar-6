package racingcar;

import racingcar.controller.RacingController;
import racingcar.util.InputValidation;

public class Application {
    public static void main(String[] args) {
        RacingController controller = new RacingController(new InputValidation());
        controller.startGame();
    }
}
