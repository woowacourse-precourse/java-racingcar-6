package racingcar.controller;

import racingcar.Constants;
import racingcar.car.RacingCar;

import java.util.stream.IntStream;

public class PlayController {
    private RacingCar racingCars;
    private int tryCnt;

    public PlayController() {
        setGame();
        play();
        showFinalWinner();
    }

    public void setGame(){
        racingCars = InputController.setRacingCars();
        tryCnt = InputController.setTryCnt();
    }

    public void play(){
        System.out.println(Constants.ROUND_RESULT);
        // tryCnt만큼 실행
        IntStream.range(0, tryCnt).forEach(i -> racingCars.playRound());
    }

    public void showFinalWinner() {
        racingCars.showWinners();
    }
}
