package racingcarFPMVC;

import java.util.List;

public class OutputView {
    public static void printCarDistances(List<Car> cars) {
        cars.forEach(car -> {
            System.out.println(car.getName() + " : " + "-".repeat(car.getDistance()));
        });
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        String result = String.join(", ", winners);
        System.out.println("최종 우승자 : " + result);
    }
}