package racingcar;

import java.util.List;

public class Output {

    public static void viewResultOfRound(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.currentStatus());
        }
        System.out.println();
    }
}
