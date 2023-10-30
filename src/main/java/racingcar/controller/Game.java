package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Game {
    private final InputView inputView;
    private final OutputView outputView;

    public Game(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        List<Car> cars = inputView.inputCarName();
        int count = inputView.inputCount();
        outputView.play(cars, count);
        outputView.printWinner(cars);
    }
}
