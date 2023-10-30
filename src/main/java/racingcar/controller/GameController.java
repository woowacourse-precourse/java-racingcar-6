package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Game;
import racingcar.service.GameService;
import racingcar.view.GameView;

public class GameController {

    private final GameService gameService;

    public GameController(){
        this.gameService = new GameService();
    }

    public void playGame() {
        String carNames = GameView.printStartMessage();
        List<Car> carList = gameService.createCars(carNames);
        GameView.printCarNames(carList);
    }
}
