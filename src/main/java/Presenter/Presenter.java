package Presenter;

import Model.GameManager;
import Model.GameResult;
import Model.UserInput;
import view.InputView;
import view.OutputView;

public class Presenter {

    private final static Presenter instance = new Presenter();

    private Presenter() {
    }

    public static Presenter getInstance() {
        return instance;
    }

    private final UserInput userInput = UserInput.getInstance();
    private final GameManager gameManager = GameManager.getInstance();
    private final GameResult gameResult = GameResult.getInstance();
    private final InputView inputView = InputView.getInstance();
    private final OutputView outputView = OutputView.getInstance();

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
