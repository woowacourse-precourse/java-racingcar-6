package racingcar.controller;

import racingcar.model.RacingCars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    private RacingCars racingCars;
    private int moveCount;

    public void startGame() {
        set();
        play();
        showWinner();
    }

    private void set() {
        racingCars = InputController.toRacingCars(InputView.readCarName());
        moveCount = InputController.toMoveCount(InputView.readMoveCount());
    }

    private void play() {
        OutputView.printStartMessage();
        for (int i = 0; i < moveCount; i++) {
            racingCars.moveOrStop();
            OutputView.printCarsPosition(racingCars);
        }
    }

    private void showWinner() {
        OutputView.printWinner(racingCars.findWinner());
    }

}
