package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Rounds;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
    InputView inputView;
    OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void init() {
        Cars cars = enrollCars();
        Rounds rounds = enrollCounts();
        race(cars, rounds);
    }

    public Cars enrollCars() {
        outputView.printRequestInputCars();
        return inputView.getCarsInput();
    }

    public Rounds enrollCounts() {
        outputView.printRequestInputRounds();
        return inputView.getRoundsInput();
    }

    public void race(Cars cars, Rounds rounds) {
        int currentRound = 0;
        outputView.printResultMessage();
        while (rounds.isNotOver(currentRound++)) {
            cars.moveCars();
            outputView.printCarsStatus(cars.getCars());
        }
        outputView.printWinners(cars);
    }
}
