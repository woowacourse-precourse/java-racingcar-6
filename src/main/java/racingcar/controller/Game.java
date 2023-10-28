package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Cars;
import racingcar.dto.FinalResponse;
import racingcar.dto.RoundResponses;
import racingcar.parser.Parser;
import racingcar.view.View;

import static racingcar.view.constants.ConstantMessage.RESPONSE_RESULT_MESSAGE;

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

        FinalResponse finalResponse = cars.buildFinalResponse();
        System.out.println(finalResponse.toEntity());

        Console.close();
    }

    private static void playOneRound(final Cars cars) {
        cars.playRound();

        RoundResponses roundResponses = cars.buildRoundResponses();
        View.printRoundResults(roundResponses.toResponseList());
    }
}
