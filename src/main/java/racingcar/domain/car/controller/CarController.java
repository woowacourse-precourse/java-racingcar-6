package racingcar.domain.car.controller;

import racingcar.domain.car.Car;
import racingcar.domain.car.service.CarService;
import racingcar.domain.car.view.CarInputView;
import racingcar.domain.car.view.CarOutputView;

import java.util.List;
import java.util.stream.IntStream;

public class CarController {

    private final CarInputView carInputView;
    private final CarOutputView carOutputView;
    private final CarService carService;

    public CarController(CarInputView carInputView, CarOutputView carOutputView, CarService carService) {
        this.carInputView = carInputView;
        this.carOutputView = carOutputView;
        this.carService = carService;
    }

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

        IntStream.range(0, tryCount)
                .forEach(i -> carOutputView.printRoundResult(carService.startRacingCar()));
    }

    private void saveCarsProcess() {
        List<String> carNames = carInputView.getCarNames();
        carService.saveCars(carNames);
    }
}
