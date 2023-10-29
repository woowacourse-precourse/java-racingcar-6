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

    /*
    private final CarService carService = new CarService();
    private final RacingGameService game = new RacingGameService();
     */

    public void play() {
        String carName = InputView.inputCarName();
        String testedCarName = exception.checkCarName(carName);
        racingGame.setCarList(testedCarName);

        String raceCount = InputView.inputRaceCount();
        String testedRaceCount = exception.checkRaceCount(raceCount);
        racingGame.setRaceCount(testedRaceCount);
        racingGame.startRace();
        racingGame.setWinnerList();

        //showWinner();
    }

    public static void showRaceResult(String carName, int position) {
        OutputView.printCarPosition(carName, position);
    }

    public static void markRaceEnd() {
        OutputView.markRaceEnd();
    }






    /*
    private void showWinner() {
        game.selectWinner();
        String winnerList = String.join(",", game.getWinnerList());
        OutputView.printWinner(winnerList);
    }
     */
}
