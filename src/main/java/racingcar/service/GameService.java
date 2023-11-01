package racingcar.service;


import static racingcar.domain.Game.createGame;

import java.util.List;
import racingcar.controller.InputResolver;
import racingcar.domain.Car;
import racingcar.domain.Game;


public class GameService {
    private final InputResolver inputResolver;
    private final CarService carService;

    public GameService(InputResolver inputResolver, CarService carService) {
        this.inputResolver = inputResolver;
        this.carService = carService;
    }

    public void game(){
        Game game = settingGame();
    }

    private Game settingGame() {
        List<Car> carList = carService.createCarList();
        int count = inputResolver.preprocessCount();
        return createGame(carList, count);
    }



}
