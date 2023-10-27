package racingcar.view;

import java.util.Iterator;
import racingcar.RaceCar;

public class Output {
    private static final String VERTICAL_WHITESPACE = "";
    private static final String FIELD_SEPARATOR = " : ";
    private static final String FINAL_WINNER_MESSAGE = "최종 우승자 : ";
    private static final String RESULTS_DELIMITER = ", ";

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printAllCar(Iterator<RaceCar> iterator) {
        while (iterator.hasNext()) {
            RaceCar raceCar = iterator.next();
            printMessage(concat(raceCar, FIELD_SEPARATOR, raceCar.getCurrentPositions()));
        }
        printMessage(VERTICAL_WHITESPACE);
    }

    public static void printWinner(Iterator<RaceCar> iterator) {
        StringBuilder builder = new StringBuilder();

        while (iterator.hasNext()) {
            RaceCar raceCar = iterator.next();
            builder.append(raceCar).append(RESULTS_DELIMITER);
        }

        Output.printMessage(concat(FINAL_WINNER_MESSAGE, builder));
    }

    private static String concat(Object... objects) {
        StringBuilder builder = new StringBuilder();
        for (Object object : objects) {
            builder.append(object.toString());
        }
        return builder.toString();
    }
}
