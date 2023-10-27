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

    public static void printWinners(List<Car> winners) {
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i).getName());
            if (i != winners.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
