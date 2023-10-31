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
        int maxAttempts = getMaxAttempts();

        Cars cars = Cars.of(nameList);

        playGame(maxAttempts, cars);

        showGameResult(cars);
    }

    private List<String> getNameList() {
        String carNamesInput = getCarNamesInput();
        return convertToNameList(carNamesInput);
    }

    private String getCarNamesInput() {
        return gameView.getCarNamesInput();
    }

    private List<String> convertToNameList(String carNamesInput) {
        return inputHandler.toNameList(carNamesInput);
    }

    private int getMaxAttempts() {
        String attemptsInput = getAttemptsInput();
        return convertToInt(attemptsInput);
    }

    private String getAttemptsInput() {
        return gameView.getAttemptsInput();
    }

    private int convertToInt(String attemptsInput) {
        return inputHandler.parseToInt(attemptsInput);
    }

    private void playGame(int maxAttempts, Cars cars) {
        showRaceResult();
        for (int currentAttempts = 0; currentAttempts < maxAttempts; currentAttempts++) {
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
