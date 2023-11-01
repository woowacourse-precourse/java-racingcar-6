package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class GameOutputView {
    public static void printRacingProcess(List<Car> cars) {
        cars.forEach(car -> {
            System.out.print(car.getName() + " : ");
            printHyphen(car.getNowNum());
            System.out.println();
        });
    }

    private static void printHyphen(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("-");
        }
    }
}
