package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
    InputView inputView = new InputView();

    public void init() {
        Cars cars = enrollCars();
    }

    public Cars enrollCars() {
        OutputView.printRequestInputCars();
        return inputView.getCarsInput();
    }

    public void enrollCounts() {

    }
}
