package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
    public void init() {
        Cars cars = enrollCars();
    }

    public Cars enrollCars() {
        OutputView.printRequestInputCars();
        return InputView.getCarsInput();
    }

    public void enrollCounts() {

    }
}
