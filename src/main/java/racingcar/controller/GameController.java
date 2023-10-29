package racingcar.controller;

import racingcar.service.RacingGame;
import racingcar.view.InputView;
import racingcar.service.Exception;
import racingcar.view.OutputView;

public class GameController {

    private Exception exception;
    private RacingGame racingGame;

    public GameController() {
        exception = new Exception();
        racingGame = new RacingGame();
    }

    public void play() {
        setRacingCar();
        setRacing();
        startRace();
        showWinner();
    }

    public void setRacingCar() {
        String carName = InputView.inputCarName();
        String testedCarName = exception.checkCarName(carName);
        racingGame.setCarList(testedCarName);
    }

    public void setRacing() {
        String raceCount = InputView.inputRaceCount();
        String testedRaceCount = exception.checkRaceCount(raceCount);
        racingGame.setRaceCount(testedRaceCount);
    }

    public void startRace() {
        OutputView.printRaceResultMessage();
        racingGame.startRace();
    }

    public static void showRaceResult(String carName, int position) {
        OutputView.printCarPosition(carName, position);
    }

    public static void markRaceEnd() {
        OutputView.markRaceEnd();
    }

    private void showWinner() {
        racingGame.setWinnerList();
        String winnerList = String.join(",", racingGame.getWinnerList());
        OutputView.printWinner(winnerList);
    }
}
