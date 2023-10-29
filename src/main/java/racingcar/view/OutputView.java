package racingcar.view;

import static racingcar.utils.Message.*;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {
    public static void printStartGameMessage() {
        System.out.println(StartGameMessage.getMessage());
    }

    public static void printAttempNumMessage() {
        System.out.println(AttempNumMessage.getMessage());
    }

    public static void printResultMessage() {
        System.out.println();
        System.out.println(ResultMessage.getMessage());
    }

    public static void printAttempResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            System.out.println(car.printProgressBar());
        }
        System.out.println();
    }

    public static void printWinners(List<Car> winners) {
        System.out.print(WINNERPRINTMESSAGE.getMessage());

        List<String> winnerNames = winners.stream().map(Car::getName).toList();
        System.out.println(String.join(", ", winnerNames));
    }

}
