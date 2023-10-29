package racingcar.View;

import java.util.List;
import racingcar.Model.Car;

public class OutputView {

    public static void displayPositions(List<Car> cars) {
        for (Car car : cars) {
            displayPosition(car.carName, car.carPosition);
        }
    }
    private static void displayPosition(String carName, int position) {
        System.out.print(carName + " : ");
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

}
