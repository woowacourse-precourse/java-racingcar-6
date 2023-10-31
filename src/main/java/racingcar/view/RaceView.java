package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class RaceView {
    private RaceView() {
    }

    public static void displayRoundResults(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getForwardDistance(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    public static void displayWinner(List<Car> winner) {

    }
}
