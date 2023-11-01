package racingcar;

import racingcar.Controller.RaceController;
import racingcar.View.InputView;
import racingcar.View.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView.printGetCarNamesMsg();
        String carNames = InputView.getCarNamesString();

        OutputView.printGetTryCountMsg();
        int tryCount = InputView.getTryCount();

        RaceController raceController = new RaceController(carNames, tryCount);
        raceController.run();
    }
}
