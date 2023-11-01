package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Match;
import racingcar.domain.Winner;
import racingcar.view.RacingInput;
import racingcar.view.RacingOutput;

import java.util.List;

public class RacingService {

    private Match match;
    private int tryCount;

    public void play() {
        init();

        progress(tryCount);

        quit(match);
    }

    private void init() {
        List<String> carNames = inputCarNames();
        match = new Match(carNames);
        tryCount = inputRacingTryCount();
    }

    private void progress(int tryCount) {
        RacingOutput.printRacingResultMessage();

        for (int i = 0; i < tryCount; i++) {
            match.start();
            RacingOutput.printRacingResult(match);
        }
    }

    private static void quit(Match match) {
        Winner winner = new Winner(match.getCars());
        RacingOutput.printWinner(winner);
    }

    private static int inputRacingTryCount() {
        RacingOutput.printRacingTryInputMessage();
        return RacingInput.readTryCount(Console.readLine());
    }

    private static List<String> inputCarNames() {
        RacingOutput.printCarNameInputMessage();
        return RacingInput.readCarNames(Console.readLine());
    }
}
