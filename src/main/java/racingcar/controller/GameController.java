package racingcar.controller;

import racingcar.service.CarService;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.service.ExceptionService;
import racingcar.view.OutputView;

public class GameController {

    private ExceptionService exception;
    private RacingGameService racingGame;

    public GameController() {
        exception = new ExceptionService();
        racingGame = new RacingGameService();
    }

    /*
    private final CarService carService = new CarService();
    private final RacingGameService game = new RacingGameService();
     */

    public void play() {
        String carName = InputView.inputCarName();
        exception.checkCarName(carName);
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
