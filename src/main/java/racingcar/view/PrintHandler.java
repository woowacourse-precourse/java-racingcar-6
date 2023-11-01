package racingcar.view;

import racingcar.domain.Cars;
import racingcar.domain.Winners;
import racingcar.utility.FormatConverter;

public class PrintHandler {

    public static void printResultOfGame(Cars cars) {
        for (int i = 0; i < cars.size(); i++) {
            String carName = cars.get(i).getName();
            String dashPosition = FormatConverter.convertNumberToDash(cars.get(i).getPosition());
            Printer.printResultMessage(carName, dashPosition);
        }

        Printer.printLineBreak();
    }

    public static void printFinalResultOfGame(Winners winners) {
        Printer.printWinnerHeadMessage();

        if (winners.size() == 1) {
            Printer.printLastWinnerMessage(winners.get(0));
            return;
        }

        for (int i = 0; i < winners.size(); i++) {
            printJointWinners(winners, i);
        }
    }

    private static void printJointWinners(Winners winners, int i) {
        if (i == winners.size() - 1) {
            Printer.printLastWinnerMessage(winners.get(i));
            return;
        }

        Printer.printWinnerMessage(winners.get(i));
    }

}
