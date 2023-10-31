package racingcar.controller;

import racingcar.service.GameService;
import racingcar.view.GameView;
import racingcar.view.Message;

public class GameController {
    static public void play() {
        initialize();
        race();
        showWinners();
    }

    static private void initialize() {
        String inputCarNames = GameView.requestInput(Message.INPUT_CAR_NAME);
        GameService.initializeCars(inputCarNames);

        String inputRaceCount = GameView.requestInput(Message.INPUT_RACE_COUNT);
        GameService.initializeRaceCount(inputRaceCount);
    }

    static private void race() {
        GameView.printlnMessage(Message.RACE_START);
        while (!GameService.isAllRaceDone()) {
            String raceResult = GameService.runSingleRace();
            GameView.printlnMessage(raceResult);
        }
    }

    static private void showWinners() {
        String winnerNames = GameService.getWinnerNames();
        GameView.printMessage(Message.WINNER);
        GameView.printlnMessage(winnerNames);
    }
}
