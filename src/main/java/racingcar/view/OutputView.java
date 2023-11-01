package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {
    private static final String RACE_START_MSG = "\n실행 결과";
    private static final String WINNER_MSG = "최종 우승자 : ";

    public static void printRaceStartMessage() {
        System.out.println(RACE_START_MSG);
    }

    public static void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            printCarPosition(car);
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        String winnersListString = String.join(", ", winners);
        System.out.print(WINNER_MSG + winnersListString);
    }

    private static void printCarPosition(Car car) {
        System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
    }
}
