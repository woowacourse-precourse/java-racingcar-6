package racingcar.controller;

import racingcar.model.Cars;
import racingcar.util.NumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final NumberGenerator numberGenerator;

    public GameController(InputView inputView, OutputView outputView, NumberGenerator numberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.numberGenerator = numberGenerator;
    }

    public void play() {
        Cars cars = inputView.readCarName();
        int count = inputView.readCount();

        outputView.printResultGuide();
        for (int i = 0; i < count; i++) {
            cars.forward(numberGenerator);
            outputView.printResult(cars);
        }
        outputView.printWinner(cars);
    }
}
