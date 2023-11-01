package racingcar.view;

import static racingcar.configurations.Messages.*;

import java.util.List;
import racingcar.model.Car;

public class Printer {

    private static class SingletonPrinter {
        private static final Printer PRINTER = new Printer();
    }

    public static Printer getInstance() {
        return SingletonPrinter.PRINTER;
    }

    private Printer() {
    }

    public void printInputCarNamesMessage() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE.get());
    }

    public void printInputNumberOfRoundsMessage() {
        System.out.println(INPUT_NUMBER_OF_ROUNDS_MESSAGE.get());
    }

    public void printRoundStateMessage() {
        System.out.println(ROUND_STATE_MESSAGE.get());
    }

    public void printRoundState(List<Car> carList) {
        for (Car car : carList) {
            System.out.print(car.getName() + COLON.get());
            printMovedDistance(car.getLocation());
            System.out.println();
        }
        System.out.println();
    }

    private void printMovedDistance(Integer location) {
        for (int i = 0; i < location; i++) {
            System.out.print(WHEEL_MARK.get());
        }
    }

    public void printResult(List<Car> winners) {
        Integer numberOfWinners = winners.size();
        System.out.print(WINNER_MESSAGE.get() + COLON.get());
        if (numberOfWinners == 1) {
            printSoloWinner(winners.get(0));
        }
        if (numberOfWinners > 1) {
            printMultiWinner(winners);
        }
    }

    private void printSoloWinner(Car winner) {
        System.out.println(winner.getName());
    }

    private void printMultiWinner(List<Car> winners) {
        Car lastWinner = winners.get(winners.size() - 1);
        for (Car winner : winners) {
            System.out.print(winner.getName());
            if (!winner.equals(lastWinner)) {
                System.out.print(COMMA.get());
            }
        }
    }
}
