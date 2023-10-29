package racingcar;

import racingcar.controller.GameController;
import racingcar.model.CarFactory;
import racingcar.service.CarGameService;
import racingcar.service.RacingCarGameService;

public class Application {
    public static void main(String[] args) {
        CarGameService carGameService = new RacingCarGameService(new CarFactory());

        GameController controller = new GameController(carGameService);

        controller.gameRun();
    }
}
