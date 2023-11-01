package racingcar;

import racingcar.client.GameClient;
import racingcar.controller.GameController;
import racingcar.dto.GameDto;
import racingcar.repository.CarRepository;
import racingcar.repository.GameRepository;
import racingcar.service.CarService;
import racingcar.service.GameService;

public class Application {
    public static void main(String[] args) {

        GameRepository gameRepository = new GameRepository();
        CarRepository carRepository = new CarRepository();
        CarService carService = new CarService(carRepository);
        GameService gameService = new GameService(gameRepository,carService);
        GameController gameController = new GameController(gameService);
        GameClient gameClient = new GameClient(gameController);


        gameClient.gameRun();
    }
}
