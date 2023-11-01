package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingGame {

    public void start() {
        String carNames = InputView.getCarNames();
        int rounds = InputView.getRounds();

        Race race = new Race(carNames);
        for (int i = 0; i < rounds; i++) {
            race.run();
            ResultView.showRaceResult(race.getCars());
        }

        ResultView.showWinner(race.getCars());
    }
}