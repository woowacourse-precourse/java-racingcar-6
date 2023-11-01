package view;

import java.util.ArrayList;
import java.util.List;
import model.Car;

public class OutputView {
    public static void printProceeding(List<Car> carList) {
        for (Car car : carList) {
            printCarLocation(car);
        }
        System.out.println();
    }

    public static void printCarLocation(Car car) {
        String name = (String) car.getCarLocation().get("name");
        int location = (Integer) car.getCarLocation().get("location");

        System.out.print(name + " : ");
        for (int i = 0; i < location; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printResult(List<Car> winnerList) {
        List<String> winners = new ArrayList<>();
        for (Car car : winnerList) {
            winners.add(car.getName());
        }

        System.out.printf("최종 우승자 : %s", String.join(",", winners));
    }
}
