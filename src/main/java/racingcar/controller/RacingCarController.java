package racingcar.controller;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.NumberGenerator;
import racingcar.domain.RacingMachine;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private final NumberGenerator numberGenerator;

    public RacingCarController(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void run() {
        RacingMachine racingMachine = setting();
        gameStart(racingMachine, numberGenerator);
        selectWinners(racingMachine);
    }

    private RacingMachine setting() {
        Cars cars = generateCar();
        int tryCount = InputView.readTryCount();
        return new RacingMachine(cars, tryCount);
    }

    private void gameStart(RacingMachine racingMachine, NumberGenerator numberGenerator) {
        OutputView.printPlayResultMessage();
        while (racingMachine.canPlay()) {
            racingMachine.gamePlay(numberGenerator);
            Cars cars = racingMachine.getCars();
            OutputView.printResult(cars);
        }
    }

    private void selectWinners(RacingMachine racingMachine) {
        List<String> winners = racingMachine.selectWinner();
        OutputView.printWinner(winners);
    }

    private Cars generateCar() {
        List<String> cars = InputView.readCarNames();
        return Cars.from(cars);
    }
}
