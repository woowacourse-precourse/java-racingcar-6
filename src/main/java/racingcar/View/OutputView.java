package racingcar.View;

import racingcar.Car.Car;
import java.util.List;

public class OutputView {

    private static boolean hasPrintedHeader = false;
    public static void printCars(List<Car> cars) {
        if(!hasPrintedHeader){
            System.out.println("실행 결과:");
            hasPrintedHeader= true;
        }
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