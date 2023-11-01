package racingcar.controller;


import racingcar.model.RacingCars;
import racingcar.view.OutputView;

import java.util.stream.IntStream;

public class PlayRacingCar {
    private RacingCars racingCars;
    private int roundNum;

    public PlayRacingCar() {
        set();
        play();
        showWinners();
    }

    public void set(){
        racingCars = InputController.setRacingCars();
        roundNum = InputController.setRoundNum();
    }

    public void play(){
        OutputView.printPlayMessage();
        IntStream.range(0,roundNum).forEach(i -> racingCars.playRound());
    }
    public void showWinners() {
        racingCars.getWinners();
    }

}
