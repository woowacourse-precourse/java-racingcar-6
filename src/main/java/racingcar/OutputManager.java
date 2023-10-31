package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class OutputManager {
    private static boolean isFirstRound = true;

    public static void printRoundResult(int round, List<Car> cars) {
        if (isFirstRound) {
            System.out.println("\n실행 결과");
            isFirstRound = false;
        }
        cars.forEach(car -> System.out.println(car.getName() + " : " + createPositionString(car.getPosition())));
        System.out.println();
    }

    private static String createPositionString(int position) {
        return "-".repeat(position);
    }

    public static void printWinners(List<Car> winners) {
        System.out.print("최종 우승자: ");
        System.out.println(winners.stream().map(Car::getName).collect(Collectors.joining(", ")));
    }
}
