package racingcar.controller;

import racingcar.model.Racer;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Racer racer = new Racer(inputView.readCars());
        int round = Integer.parseInt(inputView.readRound());
        outputView.printExecution();

        for (int i = 0; i < round; i++) {
            racer.play();
            outputView.printResult(racer);
        }
        outputView.printFinalWinner(racer.getWinner());
    }
}
