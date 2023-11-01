package racingcar.view;

import static racingcar.utils.Constants.START_RESULT;
import static racingcar.utils.Constants.WINNER;

import java.util.List;
import racingcar.model.Cars;

public class OutputView {
    public static void printGameStartMessage() {
        System.out.println(START_RESULT);
    }

    public static void printOneGameResult(Cars cars) {
        cars.getCars().forEach(car -> {
            System.out.print(car.getName() + " : ");
            System.out.println("-".repeat(car.getDistance()));
        });
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        String winner = String.join(",", winners);
        System.out.println(WINNER + winner);
    }
}
