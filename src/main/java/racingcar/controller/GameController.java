package racingcar.controller;

import racingcar.model.RacingCars;
import racingcar.view.OutputView;

import java.util.stream.IntStream;

public class GameController {
    private RacingCars racingCars;
    private int roundNum;

    public GameController() {
        set();
        play();
        showWinner();
    }
    public void set() {
        racingCars = InputController.setRacingCars();
        roundNum = InputController.setRoundNum();
    }
    public void play() {
        OutputView.printResultMessage();
        IntStream.range(0, roundNum).forEach(i -> racingCars.playRound());
    }
}
