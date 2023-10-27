package racingcar.View;

import racingcar.Car.Car;
import java.util.List;

public class OutputView {

    public static void printCars(List<Car> cars) {
        System.out.println("실행 결과:");
        for (Car car : cars) {
            printCar(car);
        }
        System.out.println();
    }

    private static String generateDashes(int position) {
        return "-".repeat(position);
    }
    private static void printCar(Car car) {
        System.out.println(car.getName() + " : " + generateDashes(car.getPosition()));
    }


}