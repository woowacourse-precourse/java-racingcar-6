package racingcar;

import racingcar.controller.CarGameController;
import racingcar.view.UserInputOutput;

public class Application {
    public static void main(String[] args) {
        CarGameController carGameController = new CarGameController(new UserInputOutput());
        carGameController.run();
    }

}
