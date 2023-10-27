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
            printMessage(raceCar + FIELD_SEPARATOR + raceCar.getCurrentPositions());
        }
        printMessage(VERTICAL_WHITESPACE);
    }

    public static void printWinner(Iterator<RaceCar> iterator) {
        StringBuilder builder = new StringBuilder();

        while (iterator.hasNext()) {
            RaceCar raceCar = iterator.next();
            builder.append(raceCar).append(RESULTS_DELIMITER);
        }

        Output.printMessage(FINAL_WINNER_MESSAGE + builder);
    }
}
