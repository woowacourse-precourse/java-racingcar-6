package racingcar.controller;

import racingcar.config.Config;
import racingcar.service.CarService;
import racingcar.service.GameService;
import racingcar.view.PrintView;

public class GameController {
    Config config = new Config();
    PrintView printView = new PrintView();
    GameService gameService = new GameService(config);
    CarService carService = new CarService();

    public void play() {
        inputCarNameProcessing();
        inputTryNumProcessing();
        carsProcessing();
        resultProcessing();
    }

    public void inputCarNameProcessing() {
        printView.inputCarNameView();
        gameService.getInputCar();
    }

    public void inputTryNumProcessing() {
        printView.inputTryNumView();
        gameService.getInputTryNum();
    }

    public void carsProcessing() {
        for (int i = 0; i < gameService.tryNum; i++) {
            carService.carForward(gameService.carList);
            printView.carForwardView(gameService.carList);
        }
    }

    public void resultProcessing() {
        gameService.findWinner();
        printView.winnerView(gameService.winnerList);
    }


}
