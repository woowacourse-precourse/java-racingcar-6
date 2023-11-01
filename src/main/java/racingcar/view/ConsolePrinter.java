package racingcar.view;

import static racingcar.constant.ConsoleMessages.CAR_NAME_MESSAGE;
import static racingcar.constant.ConsoleMessages.RESUILT_MESSAGE;
import static racingcar.constant.ConsoleMessages.ROUND_MESSAGE;

import java.util.List;
import racingcar.domain.Car;

public class ConsolePrinter {
    private static final String JOIN_DELIMITER = ", ";
    public static void printCarNameMessage() {
        System.out.println(CAR_NAME_MESSAGE);
    }

    public static void printRoundMessage() {
        System.out.println(ROUND_MESSAGE);
    }

    public static void printResultMessage() {
        System.out.println(RESUILT_MESSAGE);
    }

    public static void printCarPosition(Car car) {
        System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
    }

    public static void printFinalWinner(List<String> names) {
        System.out.println("최종 우승자 : " + String.join(JOIN_DELIMITER, names));
    }
}
