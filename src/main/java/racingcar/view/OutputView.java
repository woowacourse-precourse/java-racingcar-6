package racingcar.view;

import static racingcar.utils.Console.*;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {
    private static final String NAME_POSITION_SEPARATOR = " : ";
    private static final String SKID_MARK = "-";
    private static final String WINNER = "최종 우승자";
    private static final String WINNER_DELIMITER = ", ";
    private static final String RACE_RESULT = "실행 결과";

    public void printRaceResultMessage() {
        println();
        println(RACE_RESULT);
    }

    public void printCarsPosition(List<Car> cars) {
        for (Car car : cars) {
            println(car.getName() + NAME_POSITION_SEPARATOR + SKID_MARK.repeat(car.getPosition()));
        }
        println();
    }

    public void printWinners(List<String> winners) {
        String winner = String.join(WINNER_DELIMITER, winners);
        println(WINNER + NAME_POSITION_SEPARATOR + winner);
    }
}
