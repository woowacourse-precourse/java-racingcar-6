package racingcar;

import java.util.List;

public class Printer {
    private static void movement(Integer score) {
        for (Integer progress = 0; progress < score; progress++) {
            System.out.print("-");
        }
    }

    public static void cars(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            movement(car.getScore());
            System.out.println();
        }

        System.out.println();
    }
}
