package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {

    private static final String EXECUTE_OUTPUT_MESSAGE = "실행 결과";

    public static void printExecuteMessage() {
        System.out.println(EXECUTE_OUTPUT_MESSAGE);
    }

    public static void printResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName());
            System.out.print(" : ");
            System.out.println("-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void printWinner(List<String> winners) {
        System.out.print("최종 우승자 : ");
        System.out.println(String.join(",", winners));
    }
}
