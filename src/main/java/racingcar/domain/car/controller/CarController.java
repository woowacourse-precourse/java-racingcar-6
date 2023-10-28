package racingcar.domain.car.controller;

import racingcar.domain.car.Car;
import racingcar.domain.car.service.CarService;
import racingcar.domain.car.view.CarInputView;
import racingcar.domain.car.view.CarOutputView;

import java.util.List;
import java.util.stream.IntStream;

public class CarController {

    private final CarInputView carInputView = new CarInputView();
    private final CarOutputView carOutputView = new CarOutputView();
    private final CarService carService = new CarService();

    public void process() {
        saveCarsProcess();
        racingCarProcess();
        announceResultProcess();
    }

    private void announceResultProcess() {
        List<String> winner = carService.getWinner();
        carOutputView.printWinner(winner);
    }

    private void racingCarProcess() {
        int tryCount = carInputView.getTryCount();
        loopRacingCar(tryCount);
    }

    private void loopRacingCar(int tryCount) {
        carOutputView.printResult();

        for (int i = 0; i < tryCount; i++) {
            List<Car> cars = carService.startRacingCar();
            carOutputView.printRoundResult(cars);
        }
    }

    private void saveCarsProcess() {
        List<String> carNames = carInputView.getCarNames();
        carService.saveCars(carNames);
    }
}
