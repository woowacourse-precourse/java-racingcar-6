package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.TryCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameManager {

    public void startRacingGame() {
        OutputView.printCarNamesInputMessage();
        String[] carArray = InputView.getCarsByUser();
        Cars cars = new Cars(carArray);
        OutputView.printTryCountInputMessage();
        TryCount tryCount = new TryCount(InputView.getTryCountByUser());
        RacingGame racingGame = new RacingGame(cars, tryCount);

        OutputView.printResultMessage();
        racingGame.run();
    }
}
