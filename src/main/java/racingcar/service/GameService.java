package racingcar.service;


import static racingcar.domain.Game.createGame;
import static racingcar.domain.dto.GameResult.createGameResult;

import java.util.List;
import racingcar.domain.dto.GameResult;
import racingcar.resolver.InputResolver;
import racingcar.domain.Car;
import racingcar.domain.Game;


public class GameService {
    private final InputResolver inputResolver;
    private final CarService carService;

    public GameService(InputResolver inputResolver, CarService carService) {
        this.inputResolver = inputResolver;
        this.carService = carService;
    }

    public Game settingGame() {
        List<Car> carList = carService.createCarList();
        int count = inputResolver.preprocessCount();
        return createGame(carList, count);
    }


    public List<GameResult> startGame(Game game) {
        game.playGame();
        return createGameResults(game.getCarList());
    }

    private List<GameResult> createGameResults(List<Car> carList) {
        return carList.stream()
                .map(car -> createGameResult(car.getName(), car.getDistances()))
                .toList();
    }
}
