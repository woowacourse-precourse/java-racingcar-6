package controller;

import service.GameManager;
import service.GameResult;
import service.UserInput;

public class Controller {

    public static UserInput userInput = new UserInput();
    public static GameManager gameManager = new GameManager();
    public static GameResult gameResult = new GameResult();

    public void playGame() {
        getUserInput();
        startGame();
        endGame();
    }

    public void getUserInput() {
        userInput.getCarsName();
        userInput.getPlayTime();
    }

    public void startGame() {
        for (int i = 0; i < UserInput.playTime; i++) {
            moveCars();
            gameManager.printCarsMove();
        }
    }

    public void moveCars() {
        for (int idx = 0; idx < UserInput.carCount; idx++) {
            int randomNum = gameManager.setRandomNum();
            boolean goOrStop = gameManager.chkCarGoOrStop(randomNum);
            gameManager.setCarsMove(goOrStop);
        }
    }

    public void endGame() {
        gameResult.chkWinners();
        gameResult.printWinners();
    }
}
