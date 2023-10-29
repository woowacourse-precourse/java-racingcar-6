package racingcar.controller;

import java.util.ArrayList;
import racingcar.model.GameModel;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private InputView inputView;
    private OutputView outputView;
    private GameModel gameModel;

    public void runGame() {
        initGame();
        do {
            processGame();
        }
        while (isRacing());
    }


    public void initGame() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        String userCarNames = this.inputView.inputCarNames();
        String raceTimes = this.inputView.inputRaceTimes();

        this.gameModel = new GameModel(userCarNames, raceTimes);
        this.outputView.printGameStart();

    }

    public void processGame() {
        ArrayList<String> roundScoreBoard = this.gameModel.aggregateRoundScore();
        this.outputView.printRoundScore(roundScoreBoard);
    }

    public boolean isRacing() {
        return this.gameModel.raceTimeRemain();
    }

}