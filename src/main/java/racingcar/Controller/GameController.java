package racingcar.Controller;

import java.util.stream.IntStream;

import racingcar.model.RacingCars;
import racingcar.view.OutputView;

public class GameController {
    private RacingCars racingCars;
    private int roundNum;

    public GameController() {
        set();
        play();
        showWinners();
    }

    public void set() {
        racingCars = racingcar.Controller.InputController.setRacingCars();
        roundNum = racingcar.Controller.InputController.setRoundNum();
    }

    public void play() {
        OutputView.printPlayMessage();
        IntStream.range(0, roundNum).forEach(i -> racingCars.playRound());
    }

    public void showWinners() {
        racingCars.showWinners();
    }
}