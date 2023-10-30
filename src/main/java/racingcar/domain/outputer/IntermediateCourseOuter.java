package racingcar.domain.outputer;

import java.util.List;
import racingcar.domain.car.Car;

public class IntermediateCourseOuter {
    public static void printResult(List<Car> carList) {
        for (Car car : carList) {
            System.out.print(car.getName() + " : ");
            printLocation(car);
            System.out.println();
        }
        System.out.println();
    }

    private static void printLocation(Car car) {
        for (int i = 0; i < car.getLocation().getInteger(); i++) {
            System.out.print("-");
        }
    }
}
