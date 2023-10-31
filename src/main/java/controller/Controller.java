package controller;

import model.GameManager;
import model.GameResult;
import model.UserInput;
import view.InputView;
import view.OutputView;

public class Controller {

    private static Controller instance;

    private final UserInput userInput;
    private final GameManager gameManager;
    private final GameResult gameResult;
    private final InputView inputView;
    private final OutputView outputView;

    private Controller() {
        userInput = UserInput.getInstance();
        gameManager = GameManager.getInstance();
        gameResult = GameResult.getInstance();
        inputView = InputView.getInstance();
        outputView = OutputView.getInstance();
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public void playGame() {
        getUserInput();
        startGame();
        endGame();
    }

    private void getUserInput() {
        outputView.printRequestCarsName();
        String inputString = inputView.requestCarsName();
        userInput.setCarsName(inputString);
        outputView.printCarsName(userInput.getCarsName());

        outputView.printRequestPlayTime();
        int inputNum = inputView.requestPlayTime();
        userInput.setPlayTime(inputNum);
        outputView.printPlayTime(userInput.getPlayTime());
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
