package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.Match;
import racingcar.domain.Winner;
import racingcar.view.RacingInput;
import racingcar.view.RacingOutput;

import java.util.List;

public class RacingService {

    private Match match;

    public void play() {
        List<String> carNames = inputCarNames();
        int tryCount = inputRacingTryCount();

        match = new Match(carNames);

        RacingOutput.printRacingResultMessage();

        for (int i = 0; i < tryCount; i++) {
            match.start();
            RacingOutput.printRacingResult(match);
        }

        getResult(match);
    }

    private static int inputRacingTryCount() {
        RacingOutput.printRacingTryInputMessage();
        return RacingInput.readTryCount(Console.readLine());
    }

    private static List<String> inputCarNames() {
        RacingOutput.printCarNameInputMessage();
        return RacingInput.readCarNames(Console.readLine());
    }

    private static void getResult(Match match) {
        Winner winner = new Winner(match.getCars());
        RacingOutput.printWinner(winner);
    }
}
