package racingcar.controller;

import racingcar.model.CarList;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    private OutputView output;
    private InputView input;

    public RacingGameController() {
        this.output = new OutputView();
        this.input = new InputView();
    }

    public void start() {
        output.askForAllCarNames();
        String allCarNames = input.getAllCarNames();
        CarList cars = new CarList(allCarNames);
        output.askForNumberOfRuns();
        int numberOfRounds = input.getNumberOfRounds();

    }
}
