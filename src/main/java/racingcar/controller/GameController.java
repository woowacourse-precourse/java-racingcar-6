package racingcar.controller;

import racingcar.model.Car;
import racingcar.service.CarService;
import racingcar.service.GameService;

import java.util.List;

public class GameController {
    private final CarService carService = new CarService();
    private final GameService gameService = new GameService();
    List<Car> cars;
    int attempts;

    public void run(){
        initGame();
        startGame();
    }

    private void initGame(){
        cars = carService.enterCars();
        attempts = gameService.enterAttempts();
        System.out.println();
    }

    private void startGame(){
        gameService.racing(attempts, cars);
    }
}
