package racingcar;

import java.util.List;

public class OutputView {
    public static void showResult(List<Car> raceCarList) {
        for (Car car : raceCarList) {
            System.out.println(car.getName() + " : " + car.getDistance());
        }
        System.out.println();
    }
}
