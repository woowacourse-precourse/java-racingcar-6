package racingcar;

import racingcar.controller.RacingController;
import racingcar.io.ConsoleIOManager;
import racingcar.view.View;

public class Application {

    public static void main(String[] args) {
        View view = new View(new ConsoleIOManager());
        RacingController racingController = new RacingController(view);
        racingController.run();
    }
}
