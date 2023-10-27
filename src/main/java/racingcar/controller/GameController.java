package racingcar.controller;

import racingcar.model.Cars;
import racingcar.view.input.InputView;
import racingcar.view.output.AskView;

public class GameController {

    private final AskView askView;
    private final InputView inputView;
    private Cars cars;

    public GameController(final AskView askView, final InputView inputView) {
        this.askView = askView;
        this.inputView = inputView;
    }

    public void play() {
        askView.askCarNames();
        joinCars();
    }

    private void joinCars() {
        String carNamesInput = inputView.receiveCarNames();
        cars = Cars.from(carNamesInput);
    }
}
