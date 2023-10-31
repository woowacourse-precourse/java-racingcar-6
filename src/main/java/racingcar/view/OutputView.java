package racingcar.view;

import static racingcar.utils.ViewMessages.OUTPUT_POSITION_FORMAT;
import static racingcar.utils.ViewMessages.OUTPUT_RESULT;
import static racingcar.utils.ViewMessages.OUTPUT_RESULT_FORMAT;
import static racingcar.utils.ViewMessages.OUTPUT_WINNER_DELIMITER;
import static racingcar.utils.ViewMessages.OUTPUT_WINNER_FORMAT;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Name;

public class OutputView {

    public static void printRacingResult() {
        System.out.println();
        System.out.println(OUTPUT_RESULT);
    }

    public static void printRacingStatus(List<Car> cars) {
        cars.forEach(OutputView::printStatus);
        System.out.println();
    }

    private static void printStatus(Car car) {
        String position = OUTPUT_POSITION_FORMAT.repeat(car.getPosition());
        System.out.printf(OUTPUT_RESULT_FORMAT + "%n", car.getName(), position);
    }

    public static void printRacingWinners(List<Name> winners) {
        String[] names = winners.stream().map(Name::toString).toArray(String[]::new);
        String winnerNames = String.join(OUTPUT_WINNER_DELIMITER, names);
        System.out.printf(OUTPUT_WINNER_FORMAT, winnerNames);
    }
}
