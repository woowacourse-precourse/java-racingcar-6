package racingcar.controller;

import racingcar.handler.InputHandler;
import racingcar.model.Cars;
import racingcar.service.CarService;
import racingcar.view.GameView;

import java.util.List;

public class GameController {
    private final GameView gameView;
    private final InputHandler inputHandler;
    private final CarService carService;

    public GameController(GameView gameView, InputHandler inputHandler, CarService carService) {
        this.gameView = gameView;
        this.inputHandler = inputHandler;
        this.carService = carService;
    }

    public void startGame() {
        String carNames = gameView.inputCarNames();
        List<String> nameList = inputHandler.convertNamesToNameList(carNames);
        Cars cars = carService.createCars(nameList);

        String inputAttempts = gameView.inputAttempts();
        int attempts = inputHandler.convertAttemptsToInt(inputAttempts);

        gameView.showRaceResult();
        for (int i = 0; i < attempts; i++) {
            cars.move();

            List<String> carStatusList = cars.getCarStatusList();
            gameView.showCarStatus(carStatusList);
        }


    }
}
