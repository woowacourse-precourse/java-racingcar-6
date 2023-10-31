package racingcar.game.controller;

import racingcar.game.model.Cars;
import racingcar.game.model.RaceCount;
import racingcar.game.model.RaceResult;
import racingcar.game.model.WinnerData;
import racingcar.game.view.GameView;
import racingcar.game.view.Message;

public class GameController {
    public void initializeCars() {
        String input = GameView.requestInput(Message.INPUT_CAR_NAME);
        Cars.initializeByInput(input);
    }

    public void initializeRaceCount() {
        String input = GameView.requestInput(Message.INPUT_RACE_COUNT);
        RaceCount.initializeByInput(input);
    }

    public void race() {
        GameView.printlnMessage(Message.RACE_START);
        while (!RaceCount.equalsTotal()) {
            RaceResult raceResult = Cars.runSingleRace();
            GameView.printlnMessage(raceResult.toString());
            RaceCount.up();
        }
    }

    public void showWinners() {
        WinnerData winnerData = Cars.pickWinners();
        GameView.printMessage(Message.WINNER);
        GameView.printlnMessage(winnerData.concatWinnerNames());
    }
}
