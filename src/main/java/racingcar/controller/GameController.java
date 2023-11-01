package racingcar.controller;

import java.util.StringJoiner;
import racingcar.domain.CarGroup;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    public void run() {
        CarGroup carGroup = new CarGroup();
        InputView.inputCars(carGroup);

        int tryCount = InputView.inputTryCount();
        raceStart(tryCount, carGroup);

        StringJoiner raceWinners = carGroup.getWinners();
        OutputView.printWinners(raceWinners);
    }

    private static void raceStart(int tryCount, CarGroup carGroup) {
        OutputView.printResultMessage();
        for (int i = 0; i < tryCount; i++) {
            carGroup.moveCars();
            OutputView.printProgress(carGroup);
        }
    }
}
