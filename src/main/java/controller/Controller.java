package controller;

import service.GameManager;
import service.GameResult;
import service.UserInput;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Controller {

    public static UserInput userInput = new UserInput();
    public static GameManager gameManager = new GameManager();
    public static GameResult gameResult = new GameResult();
    public static InputView inputView = new InputView();
    public static OutputView outputView = new OutputView();

    public void playGame() {
        getUserInput();
        startGame();
        endGame();
    }

    private void getUserInput() {
        outputView.printRequestCarsName();
        String inputString = inputView.requestCarsName();
        userInput.setCarsName(inputString);

        outputView.printRequestPlayTime();
        int inputNum = inputView.requestPlayTime();
        userInput.setPlayTime(inputNum);
    }

    private void startGame() {
        outputView.printStartGame();
        gameManager.setCarIdxNamePosList(userInput.getCarsName());

        int playTime = userInput.getPlayTime();
        for (int time = 0; time < playTime; time++) {
            moveCars();
            outputView.printCarsMove(gameManager.getCarIdxNamePosList());
        }
    }

    private void moveCars() {
        int carCount = userInput.getCarCount();
        for (int idx = 0; idx < carCount; idx++) {
            gameManager.setCarsMove(idx);
        }
    }

    private void endGame() {
        gameResult.setWinnersList(gameManager.getCarIdxNamePosList());
        outputView.printWinners(gameResult.getWinnersList());
        cleanup();
    }

    private void cleanup() {
        userInput.cleanup();
        gameManager.cleanup();
        gameResult.cleanup();
    }
}
