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

//    public void receiveTryCount() {
//        CarInputView.printTryCount();
//        String userInput = CarInputView.receiveUserInput();
//        System.out.println();
//        carService.startGame(Integer.parseInt(userInput));
//    }

    public void endGame() {
        CarOutputView.printEndGame();
        List<String> winners = carService.getWinner();
        String result = String.join(", ", winners);
        System.out.print(result);
    }
}
