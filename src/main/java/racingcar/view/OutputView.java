package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {

    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";
    private static final String COUNT_SYMBOL = "-";

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printResult(List<Car> cars) {
        for (Car car : cars) {
            printCarName(car);
            printCarMoveNum(car);
        }
        System.out.println();
    }

    private static void printCarName(Car car) {
        System.out.print(car.getName() + " : ");
    }

    private static void printCarMoveNum(Car car) {
        for (int i = 0; i < car.getMoveNum(); i++) {
            System.out.print(COUNT_SYMBOL);
        }
        System.out.println();
    }

    public static void printWinnerMessage(List<String> winners) {
        System.out.print(WINNER_MESSAGE);
        System.out.println(String.join(",", winners));
    }
}
