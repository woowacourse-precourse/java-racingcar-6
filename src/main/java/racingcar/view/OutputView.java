package racingcar.view;

import java.util.List;
import racingcar.NumberGenerator;
import racingcar.domain.Cars;
import racingcar.domain.RaceRound;

public class OutputView {
    private static final String RACE_RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";
    private static final String DELIMITER = ", ";


    public void printRacingResult(Cars cars, RaceRound raceRound, NumberGenerator numberGenerator) {
        System.out.println(RACE_RESULT_MESSAGE);
        for (int i = 0; i < raceRound.getRounds(); i++) {
            cars.racing(numberGenerator);
            cars.printCarsStatus();
            System.out.println();
        }
    }

    public void printWinner(List<String> winner) {
        System.out.print(WINNER_MESSAGE);
        System.out.println(String.join(DELIMITER, winner));
    }
}
