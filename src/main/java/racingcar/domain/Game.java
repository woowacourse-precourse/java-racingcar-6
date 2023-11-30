package racingcar.domain;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Game {
    private final InputView inputView;
    private final OutputView outputView;
    public Game(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }
    public void playGame() {
        Cars cars = inputView.getCarsFromUser();
        TrialNumber trialNumber = inputView.getTrialNumber();
        trialNumber.playTurnAsMuchAsTrialNumber(cars);
        Winners winners = cars.getWinners();
        winners.print();
    }
}
