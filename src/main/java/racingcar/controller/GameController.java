package racingcar.controller;

import java.util.stream.IntStream;
import racingcar.model.Racing;
import racingcar.view.OutputView;

public class GameController {
    private Racing racingCars;
    private int round;

    public void play() {
        init();
        startRace();
        showWinner();
    }

    //초기화
    private void init() {
        racingCars = InputController.setRacing();
        round = InputController.getRound();
    }

    //게임 한판 실행
    private void startRace() {
        OutputView.printPlay();
        IntStream.range(0, round).forEach(i -> racingCars.startLap());
    }

    private void showWinner() {
        racingCars.showWinners();
    }


}
