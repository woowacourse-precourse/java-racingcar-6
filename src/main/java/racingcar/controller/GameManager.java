package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.TryCount;
import racingcar.service.CarsService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameManager {

    public void startRacingGame() {
        RacingGame racingGame = new RacingGame(generateCarsService(), generateTryCount());
        OutputView.printResultMessage();
        racingGame.run();
    }

    private Cars generateCars() {
        OutputView.printCarNamesInputMessage();
        String[] carArray = InputView.getCarsByUser();
        return new Cars(carArray);
    }

    private CarsService generateCarsService() {
        return new CarsService(generateCars());
    }

    private TryCount generateTryCount() {
        OutputView.printTryCountInputMessage();
        return new TryCount(InputView.getTryCountByUser());
    }
}
