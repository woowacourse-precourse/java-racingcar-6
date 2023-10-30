package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.util.Utils;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.stream.IntStream;


public class RaceController {

    private final InputView inputView;
    private final OutputView outputView;
    private final Utils utils;

    public RaceController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.utils = new Utils();
    }

    private void startMove(Cars cars, int tryNumber) {
        outputView.printExecutionResult();
        IntStream.range(0, tryNumber)
                .forEach(i -> {
                    cars.moveCars();
                    outputView.printCarDistanceAll(cars.getCars());
                });
    }

}
