package racingcar.controller;

import racingcar.model.Cars;
import racingcar.util.validator.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGameController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    InputValidator inputValidator = new InputValidator();
    Cars cars = new Cars();

    public void gameStart() {
        getCarName();
        printGameResult(getUserTryCount());
        printGameWinner();
    }

    private int getUserTryCount() {
        return inputValidator.checkTryCountInputValidation(inputView.getTryCount());
    }

    private void getCarName() {
        List<String> carNameList = cars.splitCarNames(inputView.getCarNames());
        inputValidator.checkCarNameInputValidation(carNameList);
        cars.saveCarNameList(carNameList);
    }

    private void printGameResult(int tryCount) {
        outputView.printEmptyLine();
        outputView.printGameResultTitle();
        for (int i = 0; i < tryCount; i++) {
            outputView.printCarPosition(cars.game());
        }
    }

    private void printGameWinner() {
        outputView.printWinners(cars.getGameWinner());
    }
}
