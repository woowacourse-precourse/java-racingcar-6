package racingcar;

import java.util.List;

public class GameResult {
    public static void result(List<Car> cars) {
        for (Car car : cars) {
            System.out.printf("%s : ", car.getName());
            printDashes(car.getMovingCount());
        }
    }

    public static void finalResult(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(",", winners));
    }

    public static void printDashes(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
