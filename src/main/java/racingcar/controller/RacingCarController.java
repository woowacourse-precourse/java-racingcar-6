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
        Racer racer = Racer.of(inputView.readCars());
        Round round = Round.of(inputView.readRound());
        outputView.printExecutionMessage();
        while (round.hasRound()) {
            race(racer, round);
            outputView.printResult(racer.getResult());
        }
        outputView.printFinalWinner(racer.getWinner());
    }

    private void race(Racer racer, Round round) {
        racer.play(accelerator);
        round.turn();
    }
}
