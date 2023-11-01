package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.service.GameService;
import racingcar.view.GameView;

public class GameController {

    private final GameService gameService;

    public GameController() {
        this.gameService = new GameService();
    }

    private List<Car> gameSetting() {
        String carNames = GameView.printStartMessage();
        List<Car> carList = gameService.createCars(carNames);
        carList = gameService.validateInput(carList);
        GameView.printCarNames(carList);
        return carList;
    }

    private void playRound(List<Car> carList) {
        String tryCountString = GameView.printTryCountMessage();
        int tryCount = Integer.parseInt(tryCountString);
        GameView.printResultMessage();
        for (int i = 0; i < tryCount; i++) {
            gameService.decideMovement(carList);
            for (Car car : carList) {
                GameView.printCarStatus(car, car.moveCount());
            }
            System.out.println();
        }
    }

    private void finishGame(List<Car> carList) {
        List<Car> winner = gameService.winRacing(carList);
        GameView.printWinMessage(winner);
    }

    public void playGame() {
        List<Car> carList = gameSetting();
        playRound(carList);
        finishGame(carList);
    }
}
