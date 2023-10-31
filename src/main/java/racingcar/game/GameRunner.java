package racingcar.game;

import racingcar.io.InputManager;
import racingcar.io.OutputManager;

import java.util.List;

public class GameRunner {
    private InputManager inputManager = new InputManager();
    private OutputManager outputManager = new OutputManager();
    private GameManager gameManager;
    private int gameRound;

    public GameRunner() {
        outputManager.printReamNames();
        List<String> nameList = inputManager.readNames();

        outputManager.printReadTrial();
        int trial = inputManager.readTrial();

        this.gameManager = new GameManager(nameList);
        this.gameRound = trial;
    }

    public void run() {
        int round = 1;
        outputManager.printResult();

        while(round <= gameRound) {
            gameManager.proceedRound();
            outputManager.printRoundResult(gameManager.getCarList());
            round++;
        }

        List<String> winnerList = gameManager.getWinner();
        outputManager.printWinner(winnerList);
    }
}
