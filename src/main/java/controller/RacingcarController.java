package controller;

import domain.CarManager;
import view.InputView;
import view.OutputView;

public class RacingcarController {
    private final InputView inputView;
    private final OutputView outputView;
    private final CarManager carManager = new CarManager();

    private int remainingRounds;

    public RacingcarController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startGame() {
        outputView.inputCarName();
        carManager.add(inputView.carName());
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
