package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Game;
import racingcar.service.GameService;
import racingcar.view.GameView;

public class GameController {

    private final GameService gameService;

    public GameController() {
        this.gameService = new GameService();
    }

    public void playGame() {
        String carNames = GameView.printStartMessage();
        List<Car> carList = gameService.createCars(carNames);
        carList = gameService.validateInput(carList);
        GameView.printCarNames(carList);
        String tryCountString = GameView.printTryCountMessage();
        int tryCount = Integer.parseInt(tryCountString);
        for (int i = 0; i < tryCount; i++) {
            gameService.decideMovement(carList);
        }
        GameView.printResultMessage();
        for (Car car : carList) {
            GameView.printCarStatus(car, car.moveCount() );
        }
        List<Car> winner = gameService.winRacing(carList);
        GameView.printWinMessage(winner);
    }
}
