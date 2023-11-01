package racingcar.view;

import racingcar.domain.Cars;
import racingcar.utility.FormatConverter;

public class PrintHandler {

    public static void printResultOfGame(Cars cars) {
        for (int i = 0; i < cars.size(); i++) {
            String carName = cars.get(i).getName();
            String dashPosition = FormatConverter.convertNumberToDash(cars.get(i).getPosition());
            Printer.printResultMessage(carName, dashPosition);
        }

        System.out.println();
    }

}
