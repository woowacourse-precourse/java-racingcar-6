package racingcar.domain.car.controller;

import racingcar.domain.car.service.CarService;
import racingcar.domain.car.view.CarInputView;
import racingcar.domain.car.view.CarOutputView;

import java.util.List;

public class CarController {

    private final CarService gameService;

    public CarController(CarService gameService) {
        this.gameService = gameService;
    }

    public void startGame() {
        CarInputView.printGameStart();
        String carNames = CarInputView.receiveUserInput();
        gameService.saveCars(carNames);
    }

    public void receiveTryCount() {
        CarInputView.printTryCount();
        String userInput = CarInputView.receiveUserInput();
        System.out.println();
        gameService.startGame(Integer.parseInt(userInput));
    }

    public void endGame() {
        CarOutputView.printEndGame();
        List<String> winners = gameService.getWinner();
        String result = String.join(", ", winners);
        System.out.print(result);
    }
}
