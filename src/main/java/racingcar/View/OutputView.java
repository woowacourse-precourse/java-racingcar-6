package racingcar.View;

import java.util.List;
import racingcar.Model.Car;

public class OutputView {

    public static void displayPositions(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.carName + " : ");
            displayPosition(car.carPosition);
        }
        System.out.println();
    }

    private static void displayPosition(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void displayWinners(List<String> winners) {
        System.out.print("최종 우승자 : ");
        for (String winner : winners) {
            System.out.print(winner);
            if (winners.indexOf(winner) != winners.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
