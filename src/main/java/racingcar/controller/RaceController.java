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

    public void startRacing() {
        Cars cars = new Cars();

        String names = inputView.insertCarName();
        cars.makeCars(utils.convertStringToList(names));

        int tryNumber = utils.convertStringToNumber(inputView.insertTryTimes());
        startMove(cars, tryNumber);

        outputView.printWinner(cars.findWinner());
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
