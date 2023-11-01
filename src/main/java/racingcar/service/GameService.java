package racingcar.service;


import static racingcar.domain.Game.createGame;
import static racingcar.domain.dto.GameResult.createGameResult;

import java.util.List;
import racingcar.domain.dto.GameResult;
import racingcar.domain.Car;
import racingcar.domain.Game;


public class GameService {
    private final CarService carService;

    public GameService(CarService carService) {
        this.carService = carService;
    }

    public Game settingGame(List<String> carNameList, int count) {
        List<Car> carList = carService.createCarList(carNameList);
        return createGame(carList, count);
    }


    public List<GameResult> startGame(Game game) {
        game.updateCarsMove();
        return createGameResults(game.getCarList());
    }

    private List<GameResult> createGameResults(List<Car> carList) {
        return carList.stream()
                .map(car -> createGameResult(car.getName(), car.getDistances()))
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
                .map(car -> car.getName())
                .toList();
    }

}
