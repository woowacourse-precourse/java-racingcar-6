package racingcar;

import racingcar.controller.Game;
import racingcar.service.CarService;

public class Application {
    public static void main(String[] args) {
        createGameController().racing();
    }

    private static Game createGameController() {
        CarService carService = new CarService();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        return new Game(carService, inputView, outputView);
    }
}
