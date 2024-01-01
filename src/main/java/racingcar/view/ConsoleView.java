package racingcar.view;

import racingcar.model.Car;
import java.util.List;

public class ConsoleView {
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printRaceStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.getPositionString());
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
