package controller;

import java.util.stream.IntStream;
import model.RacingCars;
import service.InputService;
import view.InputView;
import view.OutputView;

public class RacingController {
    private RacingCars racingCars;
    private int roundNum;


    public RacingController() {
        setRace();
        playRace();
        showWinners();
    }

    public void setRace() {
        racingCars = InputService.setRacingCars(InputView.carInput());
        roundNum = InputService.setRoundNum(InputView.roundInput());
    }

    public void playRace() {
        OutputView.printPlayMessage();
        IntStream.range(0, roundNum).forEach(i -> racingCars.playRound());
    }

    public void showWinners() {
        racingCars.showWinners();
    }
}
