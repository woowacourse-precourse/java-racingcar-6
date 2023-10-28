package racingcar.domain;

import racingcar.view.InputView;

import java.util.List;

public class Game {
    InputView inputView = new InputView();

    public void playGame() {
        Cars cars = inputView.getCarsFromUser();
        TrialNumber trialNumber = inputView.getTrialNumber();
        trialNumber.playTurnAsMuchAsTrialNumber(cars);
        List<Car> winners = cars.getWinners();

    }
}
