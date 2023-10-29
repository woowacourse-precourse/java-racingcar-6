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

    public void getUserInput() {
        outputView.printRequestCarsName();
        String inputString = inputView.requestCarsName();
        userInput.getCarsName(inputString);


        outputView.printRequestPlayTime();
        int inputNum = inputView.requestPlayTime();
        userInput.getPlayTime(inputNum);
    }

    public void startGame() {
        outputView.printStartGame();
        gameManager.makeCarIdxNamePosList();
        for (int time = 0; time < userInput.playTime; time++) {
            moveCars();
            outputView.printCarsMove(gameManager.carIdxNamePosList);
        }
    }

    public void moveCars() {
        for (int idx = 0; idx < userInput.carCount; idx++) {
            int randomNum = gameManager.setRandomNum();
            boolean goOrStop = gameManager.chkCarGoOrStop(randomNum);
            gameManager.setCarsMove(goOrStop, idx);
        }
    }

    public void endGame() {
        gameResult.chkWinners();
        outputView.printWinners(gameResult.winnersList);
    }
}
