package racingcar.view;

import java.util.Iterator;
import racingcar.RaceCar;

public class Output {
    private static final String VERTICAL_WHITESPACE = "";
    private static final String FIELD_SEPARATOR = " : ";

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
}
