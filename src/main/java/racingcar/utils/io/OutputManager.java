package racingcar.utils.io;

import racingcar.domain.Car;
import racingcar.utils.Referee;

import java.util.List;

public class OutputManager {
    private static final String OUTPUT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";

    public static void printResultMessage() {
        System.out.println(OUTPUT_MESSAGE);
    }

    public static void printRoundResult(List<Car> cars) {
        cars.forEach(System.out::println);
        System.out.println();
    }

    public static void printWinner(String winners) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(WINNER_MESSAGE);
        stringBuilder.append(winners);

        System.out.println(stringBuilder);
    }
}
