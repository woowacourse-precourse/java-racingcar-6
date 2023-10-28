package racingcar.view;

import static racingcar.message.ViewMessage.WINNER_RESULT_DELIMITER;
import static racingcar.message.ViewMessage.WINNER_RESULT_FORMAT;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class OutputView {

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printMovingResult(Cars cars) {
        System.out.println(cars);
    }

    public static void printWinner(List<Car> winner) {
        String winnerStr = winner.stream()
                .map(Car::getName)
                .collect(Collectors.joining(WINNER_RESULT_DELIMITER));
        System.out.printf(WINNER_RESULT_FORMAT, winnerStr);
    }
}
