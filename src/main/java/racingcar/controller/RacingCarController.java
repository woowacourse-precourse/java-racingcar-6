package racingcar.controller;

import racingcar.dto.Result;
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
            Result result = race(racer, round);
            outputView.printResult(result);
        }
        outputView.printFinalWinner(winner(racer));
    }

    public Result race(Racer racer, Round round) {
        racer.play(accelerator);
        round.turn();
        return racer.getResult();
    }

    public Result winner(Racer racer) {
        return racer.getWinner();
    }
}
