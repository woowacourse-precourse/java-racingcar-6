package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Rounds;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
    InputView inputView = new InputView();

    public void init() {
        Cars cars = enrollCars();
        Rounds rounds = enrollCounts();

    }

    public Cars enrollCars() {
        OutputView.printRequestInputCars();
        return inputView.getCarsInput();
    }

    public Rounds enrollCounts() {
        OutputView.printRequestInputRounds();
        return inputView.getRoundsInput();
    }
}
