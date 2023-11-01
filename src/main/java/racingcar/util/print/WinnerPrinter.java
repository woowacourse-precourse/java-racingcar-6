package racingcar.util.print;

import static racingcar.util.print.constants.RacingGameConstants.WINNER;

import java.util.List;
import racingcar.car.Car;

public abstract class WinnerPrinter {

    private WinnerPrinter() {
    }

    public static void printRacingWinner(List<Car> winner) {
        System.out.println(WINNER+formatToString(winner));
    }
    private static String formatToString(List<Car> winner) {
        String[] winnerName = toArrayWinner(winner);
        return String.join(", ", winnerName);
    }
    private static String[] toArrayWinner(List<Car> winner) {
        return winner.stream()
                .map(car -> car.getCarName())
                .toArray(String[]::new);
    }
}
