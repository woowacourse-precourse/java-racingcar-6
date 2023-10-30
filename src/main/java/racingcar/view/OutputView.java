package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {
    private static final String NAME_POSITION_SEPARATOR = " : ";
    private static final String SKID_MARK = "-";
    private static final String WINNER = "최종 우승자";
    private static final String WINNER_DELIMITER = ", ";
    private static final String RACE_RESULT = "실행 결과";

    public void printRaceResultMessage() {
        System.out.println();
        System.out.println(RACE_RESULT);
    }

    public void printCarsPosition(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + NAME_POSITION_SEPARATOR + SKID_MARK.repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        String winner = String.join(WINNER_DELIMITER, winners);
        System.out.println(WINNER + NAME_POSITION_SEPARATOR + winner);
    }
}
