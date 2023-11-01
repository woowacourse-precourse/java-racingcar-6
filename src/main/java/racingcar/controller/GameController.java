package racingcar.controller;

import racingcar.model.Car;
import racingcar.service.CarService;
import racingcar.service.GameService;

import java.util.List;

public class GameController {
    private final CarService carService = new CarService();
    private final GameService gameService = new GameService();
    List<Car> cars;

    public void run(){
        initGame();
    }

    private void initGame(){
        cars = carService.enterCars();
        gameService.init();
    }

    private void startGame(){

    }
}
