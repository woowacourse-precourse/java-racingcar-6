package racingcar.controller;

import static racingcar.message.MessageConstants.LINE_BREAK;
import static racingcar.message.MessageConstants.ZERO;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.PowerGenerator;
import racingcar.domain.RandomPowerGenerator;
import racingcar.domain.TryCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameMachine {
    private final PowerGenerator powerGenerator;
    private final InputView inputView;
    private final OutputView outputView;

    public GameMachine() {
        this.powerGenerator = new RandomPowerGenerator();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        Cars cars = getCars();
        int tryCount = getTryCount();

        runRaceAndPrintResult(cars, tryCount);
    }

    private Cars getCars() {
        List<String> names = inputView.inputCarName();
        return new Cars(names);
    }

    private int getTryCount() {
        String inputTryCount = inputView.inputTryCount();
        TryCount tryCount = new TryCount(inputTryCount);
        return tryCount.getValue();
    }

    private void runRaceAndPrintResult(Cars cars, int tryCount) {
        outputView.runResultMessage();

        for (int i = ZERO; i < tryCount; i++) {
            cars.move(powerGenerator);
            System.out.println(cars.statusMessage() + LINE_BREAK);
        }

        outputView.winnerCarsMessage(cars);
    }
}
