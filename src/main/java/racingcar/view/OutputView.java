package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.message.ViewMessage;

import java.util.List;
import java.util.stream.Collectors;

import static racingcar.message.ViewMessage.*;

public class OutputView {
    public static void printMessage(String message) {
        System.out.println(message);
    }
    public static void printMovingResult(Cars cars) {
        System.out.println(cars);
    }
    public static void printWinner(List<Car> winner) {
        String winnerString = winner.stream()
                .map(Car::getName)
                .collect(Collectors.joining(WINNER_RESULT_DELIMITER));
        System.out.printf(WINNER_RESULT_FORMAT, winnerString);
    }


}
