package racingcar.view;

import static racingcar.view.constants.GameNotice.FINAL_WINNER;

import java.util.List;
import racingcar.domain.Car;
import racingcar.view.constants.GameNotice;

public class OutputView {
    public static void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.combineCarNameAndPosition());
        }
        System.out.print("\n");
    }

    public static void printWinners(List<Car> winners) {
        printGameNotice(FINAL_WINNER);
        System.out.println(winners.toString().replaceAll("[\\[\\]]",""));
    }

    public static void printGameNotice(GameNotice gameNotice) {
        System.out.print(gameNotice.getMessage());
    }
}
