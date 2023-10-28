package racingcar.domain.car.controller;

import racingcar.domain.car.service.CarService;
import racingcar.domain.car.view.CarInputView;
import racingcar.domain.car.view.CarOutputView;

import java.util.List;

public class CarController {

    private final CarInputView carInputView = new CarInputView();
    private final CarOutputView carOutputView = new CarOutputView();
    private final CarService carService = new CarService();

    public void process() {
        saveCarsProcess();
        loopRacingCarProcess();
    }

    private void loopRacingCarProcess() {
        int tryCount = carInputView.getTryCount();
        carService.loopCarRacing();
    }

    private void saveCarsProcess() {
        List<String> carNames = carInputView.getCarNames();
        carService.saveCars(carNames);
    }

    public void receiveTryCount() {
        CarInputView.printTryCount();
        String userInput = CarInputView.receiveUserInput();
        System.out.println();
        carService.startGame(Integer.parseInt(userInput));
    }

    public void endGame() {
        CarOutputView.printEndGame();
        List<String> winners = carService.getWinner();
        String result = String.join(", ", winners);
        System.out.print(result);
    }
}
