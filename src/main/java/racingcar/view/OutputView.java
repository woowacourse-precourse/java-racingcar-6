package racingcar.view;

import racingcar.vo.Car;

import java.util.List;
import java.util.stream.Collectors;

import static racingcar.global.GameStrConstant.*;
import static racingcar.view.ConstantView.*;

public class OutputView {
    public static void printInputCarNameMessage() {
        printMessage(INPUT_CAR_NAMES.getMessage());
    }

    public static void printInputTriesCountMessage() {
        printMessage(INPUT_TRIES_COUNT.getMessage());
    }

    public static void displayCarsCurrentState(List<Car> racingCars) {
        printMessage();
        printMessage(RESULT.getMessage());
        for (Car car : racingCars) {
            printMessage(getSingleCarMovementString(car));
        }
        printMessage();
    }

    public static void displayWinners(List<Car> winners) {
        printMessage(getWinnersString(winners));
    }

    private static String getSingleCarMovementString(Car car) {
        StringBuilder sb = new StringBuilder();
        sb.append(car.getName()).append(GAME_RESULT_SEPARATOR.getValue());
        for (int moveIndex = 0; moveIndex < car.getCompletedMoves(); moveIndex++) {
            if (car.getMovementFlags().get(moveIndex)) {
                sb.append(CAR_MOVEMENT.getValue());
            }
        }
        return sb.toString();
    }

    private static String getWinnersString(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(CAR_NAME_SEPARATOR.getValue() + SPACE.getValue()));
        return WINNER.getMessage() + GAME_RESULT_SEPARATOR.getValue() + winnerNames;
    }

    private static void printMessage() {
        System.out.println();
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }

}
