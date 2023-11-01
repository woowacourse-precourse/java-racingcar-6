package racingcar.control;

import java.util.stream.IntStream;

import racingcar.model.RacingCars;
import racingcar.view.OutputView;


public class GameControl {
    private RacingCars racingCars;
    private int roundNum;

    public GameControl() {
        set();
        play();
        showWinners();
    }

    public void set() {
        racingCars = InputControl.setRacingCars();
        roundNum = InputControl.setRoundNum();
    }

    public void play() {
        OutputView.printPlayMessage();
        IntStream.range(0, roundNum).forEach(i -> racingCars.playRound());
    }

    public void showWinners() {
        racingCars.showWinners();
    }
}
