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

        showGameResult(cars);
    }

    private List<String> getNameList() {
        String carNames = getCarNamesInput();
        return convertNamesToList(carNames);
    }

    private String getCarNamesInput() {
        return gameView.getCarNamesInput();
    }

    private List<String> convertNamesToList(String carNames) {
        return inputHandler.convertNamesToNameList(carNames);
    }

    private int getAttempts() {
        String inputAttempts = getAttemptsInput();
        return convertAttemptsToInt(inputAttempts);
    }

    private String getAttemptsInput() {
        return gameView.getAttemptsInput();
    }

    private int convertAttemptsToInt(String inputAttempts) {
        return inputHandler.convertAttemptsToInt(inputAttempts);
    }

    private void playGame(int attempts, Cars cars) {
        showRaceResult();
        for (int i = 0; i < attempts; i++) {
            executeRound(cars);
            showRoundResult(cars);
        }
    }

    private void showRaceResult() {
        gameView.showRaceResult();
    }

    private void executeRound(Cars cars) {
        cars.move();
    }

    private void showRoundResult(Cars cars) {
        List<String> carStatusList = getCarStatusList(cars);
        showCarStatusList(carStatusList);
    }

    private List<String> getCarStatusList(Cars cars) {
        return cars.getCarStatusList();
    }

    private void showCarStatusList(List<String> carStatusList) {
        gameView.showCarStatus(carStatusList);
    }

    private void showGameResult(Cars cars) {
        List<String> winnerList = getWinnerList(cars);
        showWinnerList(winnerList);
    }

    private List<String> getWinnerList(Cars cars) {
        return cars.getWinnerList();
    }

    private void showWinnerList(List<String> winnerList) {
        gameView.showWinnerList(winnerList);
    }
}
