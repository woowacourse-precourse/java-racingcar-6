package racingcar.controller;

import racingcar.service.CarService;
import racingcar.service.GameService;
import racingcar.view.PrintView;

public class GameController {
    private final PrintView printView = new PrintView();
    private final GameService gameService = new GameService();
    private final CarService carService = new CarService();



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
        printView.carForwardStartView();
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
