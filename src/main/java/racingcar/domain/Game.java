package racingcar.domain;

import racingcar.view.InputView;

public class Game {
    InputView inputView = new InputView();

    public void playGame() {
        Cars cars = inputView.getCarsFromUser();
        TrialNumber trialNumber = inputView.getTrialNumber();
        trialNumber.playTurnAsMuchAsTrialNumber(cars);
        Winners winners = cars.getWinners();
        winners.print();
    }
}
