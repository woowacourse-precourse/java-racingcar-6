package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Cars;
import racingcar.dto.FinalResponse;
import racingcar.dto.RoundResponses;
import racingcar.parser.Parser;
import racingcar.view.View;

import static java.util.stream.IntStream.range;
import static racingcar.view.constants.ConstantMessage.ROUND_RESULT_MESSAGE;

public class Game {
    public static void start() {
        String carsNameRequest = View.requestCarsName();
        Cars cars = Cars.create(carsNameRequest);

        String roundCountRequest = View.requestRoundCount();
        int roundCount = Parser.parseRoundCount(roundCountRequest);

        play(cars, roundCount);
        publishFinalResult(cars);
        Console.close();
    }

    private static void publishFinalResult(Cars cars) {
        FinalResponse finalResponse = cars.buildFinalResponse();
        System.out.println(finalResponse.toResponse());
    }

    private static void play(Cars cars, int roundCount) {
        View.printConstantMessage(ROUND_RESULT_MESSAGE);
        range(0, roundCount)
                .mapToObj(round -> cars)
                .forEach(Game::executeOneRound);
    }

    private static void executeOneRound(final Cars cars) {
        cars.moveAll();

        RoundResponses roundResponses = cars.buildRoundResponses();
        View.printListWithNewLine(roundResponses.toResponseList());
    }
}
