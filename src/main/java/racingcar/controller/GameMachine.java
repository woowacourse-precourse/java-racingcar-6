package racingcar.controller;

import static racingcar.message.MessageConstants.LINE_BREAK;
import static racingcar.message.MessageConstants.ZERO;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.PowerGenerator;
import racingcar.domain.RandomPowerGenerator;
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

    public Cars getCars() {
        List<String> nameList = inputView.inputCarName();
        return new Cars(nameList);
    }

    public int getTryCount() {
        return inputView.inputTryCount();
    }

    public void runRaceAndPrintResult(Cars cars, int tryCount) {
        outputView.runResultMessage();

        for (int i = ZERO; i < tryCount; i++) {
            cars.move(powerGenerator);
            System.out.println(cars.statusMessage() + LINE_BREAK);
        }

        outputView.winnerCarsMessage(cars);
    }
}
