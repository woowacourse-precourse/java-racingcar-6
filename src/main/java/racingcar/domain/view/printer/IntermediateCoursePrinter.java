package racingcar.domain.view.printer;

import java.util.List;
import racingcar.domain.entity.Car;

public class IntermediateCoursePrinter {
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

    public static void printChallenge() {
        System.out.println("시도할 회수는 몇회인가요?");
    }
}
