package racingcar.view;

import java.util.List;
import racingcar.model.Car;
import util.Announcement;

public class OutputView {
    private static final String CAR_MOVEMENT_EQUALIZER = " : ";
    private static final String FINAL_WINNER_SEPARATOR = ", ";
    private static final String CAR_MOVEMENT_HYPHEN = "-";

    public static void displayInitCarNames() {
        System.out.println(Announcement.ENTER_CAR_NAMES.getMessage());
    }

    public static void displayInitNumberOfAttempts() {
        System.out.println(Announcement.ENTER_NUMBER_OF_ATTEMPTS.getMessage());
    }

    public static void displayResult() {
        System.out.println(Announcement.EXECUTION_RESULT.getMessage());
    }

    public static void displayCarMovements(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + CAR_MOVEMENT_EQUALIZER);
            printHyphens(car.getPosition());
        }
        System.out.println();
    }

    public static void displayWinners(List<String> winners) {
        System.out.print(Announcement.FINAL_WINNER.getMessage());
        String winnerNames = String.join(FINAL_WINNER_SEPARATOR, winners);
        System.out.println(winnerNames);
    }

    private static void printHyphens(int count) {
        String hyphens = CAR_MOVEMENT_HYPHEN.repeat(count);
        System.out.println(hyphens);
    }
}

