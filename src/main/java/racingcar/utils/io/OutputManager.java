package racingcar.utils.io;

import racingcar.domain.Car;

import java.util.List;

public class OutputManager {
    private static final String OUTPUT_MESSAGE = "실행 결과";

    public static void printResultMessage() {
        System.out.println(OUTPUT_MESSAGE);
    }

    public static void printRoundResult(List<Car> cars) {
        cars.forEach(System.out::println);
        System.out.println();
    }

    public static void printWinner(List<Car> cars) {

    }
}
