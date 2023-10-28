package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Cars;
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
            cars.playRound();
            List<String> roundResults = cars.generateResults();
            View.printRoundResults(roundResults);
        }

        List<String> winnerNames = cars.getWinnerNames();
        View.printWinnerNames(winnerNames);

        Console.close();
    }
}
