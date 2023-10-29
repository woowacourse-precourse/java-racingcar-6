package racingcar.controller;

import racingcar.model.Racer;
import racingcar.model.Round;
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
        Round round = new Round(inputView.readRound());
        outputView.printExecutionResult();
        while (round.hasRound()) {
            racer.play();
            outputView.printResult(racer.toString());
        }
        outputView.printFinalWinner(racer.winnerToString());
    }
}
