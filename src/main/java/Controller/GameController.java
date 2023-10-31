package Controller;

import Domain.Car;
import Domain.PlayGame;
import Utils.UtilsRandom;
import View.InputView;
import View.OutputView;

import java.util.List;

public class GameController {
    private UtilsRandom exception;
    private PlayGame playGame;

    public GameController() {
        exception = new UtilsRandom();
        playGame = new PlayGame();
    }

    public void playRacingGame() {
        registerRacingCar();
        registerNumberOfRaces();
        startRace();
        showWinner();
    }

    private void registerRacingCar() {
        String inputValue = InputView.InputCarName();
        String checkedInputValue = exception.checkCarName(inputValue);
        playGame.setCarList(checkedInputValue);
    }

    private void registerNumberOfRaces() {
        String inputValue = InputView.InputGameCount();
        String checkedInputValue = exception.checkRaceCount(inputValue);
        playGame.setNumberOfRaces(checkedInputValue);
    }

    private void startRace() {
        OutputView.OutputRaceResultMessage();
        playGame.startRace();
    }

    public static void showRaceResult(List<Car> carList) {
        OutputView.OutputRaceResult(carList);
    }

    private void showWinner() {
        playGame.setWinnerList();
        String winnerList = String.join(", ", playGame.getWinnerList());
        OutputView.OutputWinner(winnerList);
    }
}
