package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.CarList;
import racingcar.model.RandomDrive;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.inputCarName();
        CarList carList = makeCarList(inputView.inputCarNames());
        outputView.inputAttempts();
        int racingNumber = inputView.inputRacingNumber();
    }

    private CarList makeCarList(List<String> names) {
        CarList carList = new CarList();
        for (String name : names) {
            Car car = new Car(name);
            carList.addCar(car);
        }
        return carList;
    }
}
