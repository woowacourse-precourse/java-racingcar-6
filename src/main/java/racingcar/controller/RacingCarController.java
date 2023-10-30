package racingcar.controller;

import racingcar.dto.Result;
import racingcar.model.Racer;
import racingcar.model.Round;
import racingcar.service.RacingGame;
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
        Racer racer = Racer.of(inputView.readCars());
        Round round = Round.of(inputView.readRound());
        RacingGame racingGame = new RacingGame(racer, round);
        outputView.printExecutionMessage();
        while (racingGame.isEnd()) {
            Result result = racingGame.race();
            outputView.printResult(result);
        }
        outputView.printFinalWinner(racingGame.winner());
    }
}
