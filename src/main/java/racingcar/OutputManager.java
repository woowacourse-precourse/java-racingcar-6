package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class OutputManager {
    public static void printRoundResult(int round, List<Car> cars) {
        System.out.println("실행 결과");
        cars.forEach(car -> System.out.println(car.getName() + " : " + createPositionString(car.getPosition())));
        System.out.println();
    }

    private static String createPositionString(int position) {
        return "-".repeat(position);
    }

    public static void printWinners(List<Car> winners) {
        System.out.print("우승자: ");
        System.out.print(winners.stream().map(Car::getName).collect(Collectors.joining(", ")));
    }
}
