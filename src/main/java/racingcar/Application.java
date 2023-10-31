package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.factory.ComponentFactory;

public class Application {
    public static void main(String[] args) {
        final ComponentFactory componentFactory = ComponentFactory.getInstance();
        final RacingCarController racingCarController = componentFactory.racingCarController();
        racingCarController.run();
    }
}
