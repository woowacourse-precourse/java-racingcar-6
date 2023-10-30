package racingcar.io;

import java.util.List;
import racingcar.domain.Car;

public class OutputPrinter {
    public static void printCarsPosition(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getPosition(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }
}
