package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {

    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE_FORMAT = "최종 우승자 : %s";
    private static final String WINNER_NAME_DELIMITER = ", ";

    public void printRaceStartMessage() {
        printEmptyLine();
        System.out.println(RESULT_MESSAGE);
    }

    public void printRoundResult(List<Car> racedCars) {
        racedCars.forEach(System.out::println);
        printEmptyLine();
    }

    public void printWinners(List<String> winnerNames) {
        System.out.format(WINNER_MESSAGE_FORMAT, String.join(WINNER_NAME_DELIMITER, winnerNames));
    }

    private void printEmptyLine() {
        System.out.println();
    }
}
