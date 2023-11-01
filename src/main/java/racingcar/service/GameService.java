package racingcar.service;


import static racingcar.domain.Game.createGame;
import static racingcar.dto.CarResult.createCarResult;

import java.util.List;
import racingcar.dto.CarResult;
import racingcar.domain.Car;
import racingcar.domain.Game;


public class GameService {
    private final CarService carService;

    public GameService(CarService carService) {
        this.carService = carService;
    }

    public Game settingGame(List<String> carNameList, int count) {
        List<Car> carList = carService.registerCarList(carNameList);
        return createGame(carList, count);
    }


    public List<CarResult> startGame(Game game) {
        game.updateCarsMove();
        return createCarResults(game.getCarList());
    }

    private List<CarResult> createCarResults(List<Car> carList) {
        return carList.stream()
                .map(car -> createCarResult(car.getName(), car.getDistances()))
                .toList();
    }

    public List<String> determineWinner(Game game) {
        game.determineTopDistance();
        return determineTopCar(game);
    }

    private List<String> determineTopCar(Game game) {
        return game.getCarList().stream()
                .filter(car ->
                        car.getDistances() == game.getTopDistance()
                )
                .map(Car::getName)
                .toList();
    }

}
