package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.CarDto;
import racingcar.model.Cars;
import racingcar.model.TryCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;


public class CarController {

    private Cars cars;
    private TryCount tryCount;
    private final InputView inputView;
    private final OutputView outputView;

    public CarController(Cars cars, InputView inputView, OutputView outputView) {
        this.cars = cars;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        cars = new Cars(inputView.getPlayerNamesInput());
        getTryCountFromInput();
        race();
    }
    private void getTryCountFromInput() {
        inputView.inputTryCount();
    }

    private void race() {
        outputView.printStartMessage();
        raceRecursive(0);
    }

    private void raceRecursive(int nowTryCnt) {
        if (!tryCount.isNotSame(nowTryCnt)) {
            return;
        }

        cars.moveAll();
        outputView.printString(cars.toString());
        raceRecursive(nowTryCnt + 1);
    }

}
