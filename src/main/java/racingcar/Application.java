package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.model.RacingCarService;
import racingcar.model.car.RandomNumber;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        RacingCarController controller = new RacingCarController(new InputView(),
                new RacingCarService(new RandomNumber()));
        controller.racing();
    }
}
