package controller;

import domain.CarService;
import view.InputView;
import view.OutputView;

public class RacingcarController {
    private final InputView inputView;
    private final OutputView outputView;
    private final CarService carService = new CarService();

    private int remainingRounds;

    public RacingcarController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startGame() {
        outputView.inputCarName();
        carService.add(inputView.carName());
        outputView.inputRoundNumber();
        remainingRounds = inputView.roundNumber();
    }

    public void playRound() {

    }

    public boolean isEnd() {
        return true;
    }

    public void endGame() {

    }
}
