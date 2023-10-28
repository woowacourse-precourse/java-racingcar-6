package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Cars;
import racingcar.domain.WinnerResult;
import racingcar.parser.Parser;
import racingcar.view.View;

import java.util.List;

import static racingcar.view.constants.Message.RESPONSE_RESULT_MESSAGE;

public class Game {
    public static void start() {
        String carNamesRequest = View.requestCarNames();
        Cars cars = Cars.create(carNamesRequest);

        String roundCountRequest = View.requestRoundCount();

        View.printNotice(RESPONSE_RESULT_MESSAGE);
        int roundCount = Parser.parseRoundCount(roundCountRequest);

        playRounds(cars, roundCount);
    }

    private static void playRounds(
            final Cars cars,
            final int roundCount
    ) {
        for (int i = 0; i < roundCount; i++) {
            List<String> roundResults = cars.playOneRound();
            View.printRoundResults(roundResults);
        }

        WinnerResult winnerResult = cars.createWinnerResult();
        View.printWinnerResult(winnerResult.getWinnerNames());

        Console.close();
    }
}
