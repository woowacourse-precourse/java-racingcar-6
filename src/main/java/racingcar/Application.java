package racingcar;

import racingcar.controller.GameController;
import racingcar.repository.CarRepository;
import racingcar.repository.GameRepository;
import racingcar.service.CarService;
import racingcar.service.GameService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameRepository gameRepository = new GameRepository();
        CarRepository carRepository = new CarRepository();
        CarService carService = new CarService(carRepository);
        GameService gameService = new GameService(gameRepository,carService);

        GameController gameController = new GameController(gameService, carService);
        gameController.gameStart();

    }
}
