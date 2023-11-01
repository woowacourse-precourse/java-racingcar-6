package controller;

import service.InputValidator;
import service.CarService;
import view.OutputView;

public class RacingGame {
    private final CarService carService;

    public RacingGame() {
        this.carService = new CarService();
    }

    public void gameSetAndStart() {
        String carListInput = InputValidator.carListInputSetAndValidate();
        carService.init(carListInput);

        int rounds = InputValidator.roundInputSetAndValidate();
        carService.playRound(rounds);
    }
}
