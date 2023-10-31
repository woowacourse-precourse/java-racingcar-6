package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Round;
import racingcar.utils.Parser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {
    private Cars cars;
    private Round round;

    public void play() {
        start();
        OutputView outputView = new OutputView();
        outputView.printResult(cars);
        while (!round.isMaxRound()) {
            cars.run();
            outputView.printCars(cars);
        }
        outputView.printWinner(cars);
    }

    private void start() {
        InputView inputView = new InputView();
        List<String> names = Parser.stringToList(inputView.inputCarNames());
        int tryNumber = inputView.inputTryNumber();
        this.cars = new Cars(names);
        this.round = new Round(tryNumber);
    }
}
