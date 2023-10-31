package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.RacingGame;
import racingcar.domain.dto.RaceResult;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;


public class RacingConsole {
    public void run() {
        OutputView.printRequestCarNames();
        String requestCarNames = Console.readLine();

        List<String> carNames = InputView.receiveCarNames(requestCarNames);
        OutputView.printRequestTotalRound();

        String requestTotalRound = Console.readLine();
        int round = InputView.receiveTotalRound(requestTotalRound);

        RacingGame racingGame = new RacingGame(carNames);

        RaceResult raceResult = racingGame.start(round);
        OutputView.printRaceResult(raceResult);
    }
}
