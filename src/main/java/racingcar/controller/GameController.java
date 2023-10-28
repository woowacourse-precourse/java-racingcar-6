package racingcar.controller;

import racingcar.handler.InputHandler;
import racingcar.model.Cars;
import racingcar.view.GameView;

import java.util.List;

public class GameController {
    private final GameView gameView;
    private final InputHandler inputHandler;

    public GameController(GameView gameView, InputHandler inputHandler) {
        this.gameView = gameView;
        this.inputHandler = inputHandler;
    }

    public void startGame() {
        List<String> nameList = getNameList();
        int attempts = getAttempts();

        Cars cars = Cars.of(nameList);

        playGame(attempts, cars);

        List<String> winnerList = cars.getWinnerList();
        gameView.showWinnerList(winnerList);
    }

    private List<String> getNameList() {
        String carNames = gameView.getCarNamesInput();
        List<String> nameList = inputHandler.convertNamesToNameList(carNames);
        return nameList;
    }

    private int getAttempts() {
        String inputAttempts = gameView.getAttemptsInput();
        int attempts = inputHandler.convertAttemptsToInt(inputAttempts);
        return attempts;
    }

    private void playGame(int attempts, Cars cars) {
        gameView.showRaceResult();
        for (int i = 0; i < attempts; i++) {
            cars.move();

            List<String> carStatusList = cars.getCarStatusList();
            gameView.showCarStatus(carStatusList);
        }
    }
}
