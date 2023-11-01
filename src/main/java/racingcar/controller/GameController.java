package racingcar.controller;

import racingcar.service.GameService;
import racingcar.view.GameView;
import racingcar.view.Message;

public class GameController {
    private GameView gameView;
    private GameService gameService;

    public GameController() {
        gameView = new GameView();
        gameService = new GameService();
    }

    public void play() {
        initializeFromInput();
        race();
        showWinners();
    }

    private void initializeFromInput() {
        String inputCarNames = gameView.requestInput(Message.INPUT_CAR_NAME);
        gameService.initCarsFromInput(inputCarNames);

        String inputRaceCount = gameView.requestInput(Message.INPUT_RACE_COUNT);
        gameService.initRaceCountFromInput(inputRaceCount);
    }

    private void race() {
        gameView.printlnMessage(Message.RACE_START);
        while (!gameService.isAllRaceDone()) {
            String raceResult = gameService.runSingleRace();
            gameView.printlnMessage(raceResult);
        }
    }

    private void showWinners() {
        String winnerNames = gameService.getWinnerNames();
        gameView.printMessage(Message.WINNER);
        gameView.printlnMessage(winnerNames);
    }
}
