package racingcar;

import racingcar.controller.RacingController;
import racingcar.view.CarNameInput;

public class Application {
    public static void main(String[] args) {
        CarNameInput carNameInput = new CarNameInput();
        RacingController controller = new RacingController(carNameInput);
        controller.playRacingGame();
    }
}
