package racingcar.controller;

import racingcar.domain.RacingCars;
import racingcar.domain.Refree;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Game {

    public void start() {
        OutputView.askCarName();
        RacingCars racingcars = RacingCars.stringToRacingCars((InputView.askCarName()));
        final int playTime = InputView.askPlayTime();
        for (int i = 0; i < playTime; i++) {
            Refree.simulate();
        }
        OutputView.showResult();
    }
}