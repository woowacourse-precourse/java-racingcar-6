package racingcar.domain;

import racingcar.view.InputView;

public class Game {
    public void playGame() {
        Cars cars = InputView.getCarsFromUser();
        TrialNumber trialNumber = InputView.getTrialNumber();
        trialNumber.playTurnAsMuchAsTrialNumber(cars);
        Winners winners = cars.getWinners();
        winners.print();
    }
}
