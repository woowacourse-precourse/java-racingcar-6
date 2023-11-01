package racingcar;

import racingcar.controller.GameController;
import racingcar.model.repository.CarRepository;
import racingcar.model.service.GameService;

public class Application {
    public static void main(String[] args) {
        CarRepository carRepository = new CarRepository();
        GameService gameService = new GameService(carRepository);
        GameController gameController = new GameController(gameService);
        gameController.run();
    }
}
