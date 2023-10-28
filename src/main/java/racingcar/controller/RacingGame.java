package racingcar.controller;

import racingcar.view.CarName;
import racingcar.view.OutputView;

public class RacingGame {
    OutputView outputView = new OutputView();
    CarName carName = new CarName();
    public void play() {
        outputView.racingStart();
        String[] carNames = carName.input().split(",");
        outputView.rotateCount();
    }
}
