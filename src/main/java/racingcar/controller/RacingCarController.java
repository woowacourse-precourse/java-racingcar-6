package racingcar.controller;

import racingcar.model.Racer;
import racingcar.model.Round;
import racingcar.service.Accelerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private final Accelerator accelerator;
    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarController(Accelerator accelerator, InputView inputView, OutputView outputView) {
        this.accelerator = accelerator;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Racer racer = new Racer(inputView.readCars());
        Round round = Round.of(inputView.readRound());
        outputView.printExecutionMessage();
        while (round.hasRound()) {
            play(racer);
            round.turn();
        }
        outputView.printFinalWinner(racer.winnerToString());
    }

    private void play(Racer racer) {
        racer.play(accelerator);
        outputView.printResult(racer.toString());
    }
}
