package racingcar.controller;

import racingcar.service.CarService;
import racingcar.view.OutputView;

public class RacingGameController {
    CarService carService = new CarService();
    OutputView outputView = new OutputView();

    public void gameStart() {
        int tryCount = carService.getCarNameAndTryCount();
        printGameResult(tryCount);
    }

    private void printGameResult(int tryCount) {
        outputView.printEmptyLine();
        outputView.printGameResultTitle();
        for (int i = 0; i < tryCount; i++) {
            outputView.printCarPosition(carService.game());
        }
    }
}
