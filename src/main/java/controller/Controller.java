package controller;

import service.GameManager;
import service.GameResult;
import service.UserInput;
import view.InputView;
import view.OutputView;

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
        gameManager.makeCarIdxNamePosList();

        int playTime = userInput.getPlayTime();
        for (int time = 0; time < playTime; time++) {
            moveCars();
            outputView.printCarsMove(gameManager.carIdxNamePosList);
        }
    }

    private void moveCars() {
        int carCount = userInput.getCarCount();
        for (int idx = 0; idx < carCount; idx++) {
            int randomNum = gameManager.setRandomNum();
            boolean goOrStop = gameManager.chkCarGoOrStop(randomNum);
            gameManager.setCarsMove(goOrStop, idx);
        }
    }

    private void endGame() {
        gameResult.chkWinners();
        outputView.printWinners(gameResult.winnersList);
    }
}
