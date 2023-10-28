package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Cars;
import racingcar.parser.Parser;
import racingcar.view.View;

import java.util.List;

import static racingcar.view.constants.Message.RESPONSE_RESULT_MESSAGE;
import static racingcar.view.constants.Message.RESPONSE_WINNER_MESSAGE;

public class Game {
    public static void start() {
        String carsNameRequest = View.requestCarsName();
        Cars cars = Cars.create(carsNameRequest);

        String roundCountRequest = View.requestRoundCount();
        int roundCount = Parser.parseRoundCount(roundCountRequest);

        View.printNotice(RESPONSE_RESULT_MESSAGE);
        for (int i = 0; i < roundCount; i++) {
            playOneRound(cars);
        }
        String winnerNames = cars.getWinnerNames();
        System.out.println(String.format(RESPONSE_WINNER_MESSAGE.getMessage(), winnerNames));
        Console.close();
    }

    private static void playOneRound(final Cars cars) {
        cars.playRound();
        List<String> roundResults = cars.generateRoundResult();
        View.printRoundResults(roundResults);
    }
}
