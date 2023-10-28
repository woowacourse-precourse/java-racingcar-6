package racingcar.controller;

import racingcar.model.GameModel;
import racingcar.view.InputView;

public class GameController {
    private InputView inputView;
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
        String userCarNames = inputView.inputCarNames();
        String raceTimes = inputView.inputRaceTimes();

        this.gameModel = new GameModel(userCarNames, raceTimes);

    }

    public void processGame() {
        gameModel.racing();
    }

    public boolean isRacing() {
        return gameModel.raceTimeRemain();
    }

}