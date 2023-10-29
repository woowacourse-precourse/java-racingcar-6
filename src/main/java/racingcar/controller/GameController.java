package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
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
        registerRacingCar();
        registerNumberOfRaces();
        startRace();
        showWinner();
    }

    public void registerRacingCar() {
        String inputValue = InputView.enterCarName();
        String checkedInputValue = exception.checkCarName(inputValue);
        racingGame.setCarList(checkedInputValue);
    }

    public void registerNumberOfRaces() {
        String inputValue = InputView.enterRaceCount();
        String checkedInputValue = exception.checkRaceCount(inputValue);
        racingGame.setNumberOfRaces(checkedInputValue);
    }

    public void startRace() {
        OutputView.printRaceResultMessage();
        racingGame.startRace();
    }

    public static void showRaceResult(List<Car> carList) {
        OutputView.printRaceResult(carList);
    }

    private void showWinner() {
        racingGame.setWinnerList();
        String winnerList = String.join(",", racingGame.getWinnerList());
        OutputView.printWinner(winnerList);
    }
}
