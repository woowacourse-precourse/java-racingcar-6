package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.CarList;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGameController {

    private OutputView output;
    private InputView input;

    public RacingGameController() {
        this.output = new OutputView();
        this.input = new InputView();
    }

    public void start(){
        output.askForName();
        String allCarNames = input.carNames();
        CarList cars = new CarList(allCarNames);
    }
}
