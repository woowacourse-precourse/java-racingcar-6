package controller;

import service.InputValidator;
import service.CarService;
import view.InputView;

public class RacingGame {
    private final CarService carService;

    public RacingGame() {
        this.carService = new CarService();
    }

    public void gameSetAndStart() {
        String carListInput = InputView.setCarNames();
        InputValidator.carListValidate(carListInput);
        carService.init(carListInput);

        String userRoundInput = InputView.setTryNumber();
        int rounds = InputValidator.roundInputSetAndValidate(userRoundInput);
        carService.playRound(rounds);
    }
}
