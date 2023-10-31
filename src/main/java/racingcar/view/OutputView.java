package racingcar.view;

import static racingcar.utils.ViewMessages.OUTPUT_POSITION_FORMAT;
import static racingcar.utils.ViewMessages.OUTPUT_RESULT;
import static racingcar.utils.ViewMessages.OUTPUT_RESULT_FORMAT;
import static racingcar.utils.ViewMessages.OUTPUT_WINNER_DELIMITER;
import static racingcar.utils.ViewMessages.OUTPUT_WINNER_FORMAT;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Name;
import racingcar.domain.WinnerNames;

public class OutputView {

    public static void printRacingResult() {
        System.out.println();
        System.out.println(OUTPUT_RESULT);
    }

    public static void printRacingStatus(Cars cars) {
        cars.getCars().forEach(OutputView::printStatus);
        System.out.println();
    }

    private static void printStatus(Car car) {
        String position = OUTPUT_POSITION_FORMAT.repeat(car.getPosition());
        System.out.printf(OUTPUT_RESULT_FORMAT + "%n", car.getName(), position);
    }

    public static void printRacingWinners(WinnerNames winnerNames) {
        String winners = String.join(OUTPUT_WINNER_DELIMITER, winnerNames.getNames());
        System.out.printf(OUTPUT_WINNER_FORMAT, winners);
    }
}
