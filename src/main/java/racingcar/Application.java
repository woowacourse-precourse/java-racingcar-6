package racingcar;

import racingcar.controller.ControlConfig;
import racingcar.controller.MainController;

public class Application {
    public static void main(String[] args) {
        new MainController(new ControlConfig()).run();
    }
}
