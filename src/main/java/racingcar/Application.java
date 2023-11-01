package racingcar;

import racingcar.controller.CarController;
import racingcar.service.GameService;
import racingcar.validator.InputValidator;
import racingcar.domain.RandomNumberGenerator;

public class Application {
    public static void main(String[] args) {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        CarController carController = new CarController(new GameService(), new InputValidator());
        carController.run();

    }
}
