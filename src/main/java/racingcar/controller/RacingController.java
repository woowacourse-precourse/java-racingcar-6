package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.service.MoveForward;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;
    private final MoveForward moveForward;
    private final Cars cars;

    public RacingController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.cars = new Cars(inputView.readRacingCarName());
        this.moveForward = new MoveForward(inputView.readTrialCount());
    }

    public void run() {
        outputView.executionResultMessage();
        int count = 0;

        while(count < moveForward.getTrialCount()) {
            count++;
            cars.moveCars();
            outputView.printMoveResults(cars.getCars());
        }
        outputView.finalWinnerMessage(cars.winnerJudge());
    }
}
