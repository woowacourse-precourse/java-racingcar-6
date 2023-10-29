package racingcar.controller;

import racingcar.service.RacingGame;
import racingcar.view.InputView;
import racingcar.service.Exception;

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
        setRaceCount();
        startRace();
        showWinner();
    }

    /*
    private void inputCarName() {
        ExceptionService.checkCarName(InputView.inputCarName());
    }


    private void setCar() {
        Car.carList = new ArrayList<>();
        for (String name : Exception.carNames) {
            Car.carList.add(new Car(name));
        }
    }
     */

    /*
    private void setRaceCount() {
        game.setRaceCount(ExceptionService.checkRaceCount(InputView.inputRaceCount()));
    }

    private void startRace() {
        OutputView.printRaceResultMessage();
        game.startRaceCount();
    }

    private void showWinner() {
        game.selectWinner();
        String winnerList = String.join(",", game.getWinnerList());
        OutputView.printWinner(winnerList);
    }
     */
}
