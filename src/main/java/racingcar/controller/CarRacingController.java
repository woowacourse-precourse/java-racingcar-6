package racingcar.controller;

import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class CarRacingController {
    private OutputView outputView;
    private InputView inputView;
    private Cars cars;

    public CarRacingController() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
        this.cars = new Cars();
    }

    public void run() {
        inputView.printCarNameMessage();
        List<String> carNames = inputView.inputCarNames();
        cars.createCars(carNames);
        inputView.printTimesInputMessage();
        Integer inputTimes = inputView.inputNumber();
        outputView.printResultMassage();

        for (int i = 0; i < inputTimes; i++) {
            startRacing();
        }

        outputView.printFinalWinner(cars.getFinalWinner());
    }

    private void startRacing() {
        outputView.printRoundGameResult(cars.roundCarResult());
    }

}
