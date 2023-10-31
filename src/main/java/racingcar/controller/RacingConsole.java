package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.RacingGame;
import racingcar.domain.dto.RaceResult;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;


public class RacingConsole {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingConsole(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printRequestCarNames();
        String requestCarNames = Console.readLine();

        List<String> carNames = inputView.receiveCarNames(requestCarNames);
        outputView.printRequestTotalRound();

        String requestTotalRound = Console.readLine();
        int round = inputView.receiveTotalRound(requestTotalRound);

        RacingGame racingGame = new RacingGame(carNames);

        RaceResult raceResult = racingGame.start(round);
        outputView.printRaceResult(raceResult);
    }
}
