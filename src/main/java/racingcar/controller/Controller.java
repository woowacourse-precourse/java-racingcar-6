package racingcar.controller;

import racingcar.function.CheckName;
import racingcar.value.Value;
import racingcar.view.InputView;
import racingcar.function.CheckNumber;

public class Controller {
    private final Value values;

    public Controller() {
        this.values = new Value();
    }

    public void run() {
        carName();
        raceAttempts();
    }

    private void carName() {
        String inputNames = InputView.inputCarNames();
        CheckName.validate(inputNames);
        values.addCarNames(inputNames.split(","));
    }
    private void raceAttempts() {
        String input = InputView.inputNumberOfAttempts();
        int numberOfAttempts = CheckNumber.validate(input);
        values.setNumberOfAttempts(numberOfAttempts);
    }
}