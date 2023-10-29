package racingcar.Controller;

import racingcar.model.Car;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Controller {
    private RacingCars racingCars;
    private int roundNum;

    public Controller() {
              play();
        showWinners();
    }

    public static RacingCars () {
        return
    }

    public void play() {
        OutputView.printPlayMessage();
        IntStream.range(0, roundNum).forEach(i -> racingCars.playRound());
    }

    public void showWinners() {
        racingCars.showWinners();
    }
}