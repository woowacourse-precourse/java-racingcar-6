package racingcar.controller;

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
        Racer racer = new Racer(inputView.readCars());
        Round round = Round.of(inputView.readRound());
        RacingGame racingGame = new RacingGame(racer, round);
        outputView.printExecutionMessage();
        while (racingGame.isEnd()) {
            Racer race = racingGame.race();
            outputView.printResult(race.toString()); //TODO: 여기 race 대신 다른 객체를 던져 출력해달라는 메시지를 전하자.
        }
        outputView.printFinalWinner(racer.winnerToString());
    }
}
