package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Round;
import racingcar.view.InputView;

public class RacingGameController {
    private Cars cars;
    private Round round;

    public RacingGameController(){
    }

    public void playGame() {
        cars = new Cars(InputView.inputNames());
        round = new Round(InputView.inputRound());
    }
}
