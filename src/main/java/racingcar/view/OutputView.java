package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {

    public static void printRaceStartMessage() {
        System.out.println("\n실행 결과");
    }

    public static void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            printCarPosition(car);
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        String winnersString = String.join(", ", winners);
        System.out.println("최종 우승자 : " + winnersString);
    }

    private static void printCarPosition(Car car) {
        System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
    }
}
