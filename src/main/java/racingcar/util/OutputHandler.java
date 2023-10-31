package racingcar.util;

import java.util.List;
import racingcar.domain.Car;

public class OutputHandler {
    public static void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    public static void printResult(List<Car> cars) {
        for (Car car : cars) {
            visualizePosition(car);
        }
        System.out.println();
    }

    private static void visualizePosition(Car car) {
        int carPositionInteger = car.getPosition();
        String carName = car.getName();
        String carPosition = positionToUnderbar(carPositionInteger);
        System.out.println(carName + " : " + carPosition);
    }

    private static String positionToUnderbar(int position) {
        return "-".repeat(position);
    }
}
