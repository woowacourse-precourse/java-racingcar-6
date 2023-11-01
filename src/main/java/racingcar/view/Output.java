package racingcar.view;

import racingcar.domain.Car;
import racingcar.constant.SystemMessage;

import java.util.List;

public class Output {
    public static void printEmptySpace() {
        System.out.println();
    }

    public static void displayRaceProgressMessage() {
        System.out.println(SystemMessage.RESULT_MESSAGE.getMessage());
    }
    public static void displayRaceProgress(String name, int position) {
        System.out.print(name + " : ");
        System.out.println("-".repeat(Math.max(0, position)));
    }

    public static void displayRaceWinner(List<Car> cars) {
        System.out.print(SystemMessage.WINNER_MESSAGE.getMessage());
        int maxPosition = cars.stream().mapToInt(Car::getPosition)
                .max().orElse(0);
        List<String> winners = cars.stream().filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName).toList();
        System.out.println(String.join(", ", winners));
    }
}
