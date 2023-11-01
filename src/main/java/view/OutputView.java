package view;

import java.util.List;
import model.Car;

public class OutputView {
    public static void printProceeding(List<Car> carList) {
        System.out.println("실행 결과");
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
    }

    public static void printResult(List<String> winnerList) {
        String winners = String.join(", ", winnerList);
        System.out.printf("최종 우승자 : %s", winners);
    }
}
