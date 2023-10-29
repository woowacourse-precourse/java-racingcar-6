package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.view.InputView;

public class CarNamesController {
    private List<String> carNames;

    public CarNamesController() {
        this.carNames = inputNames();
    }

    private List<String> inputNames() {
        String inputName = InputView.inputName();
        return Arrays.asList(inputName.split(","));
    }

    public List<String> getCarNames() {
        return carNames;
    }
}
