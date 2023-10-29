package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class ResultView {
    public static void printRace(List<Car> cars) {
        for (Car car : cars) {
            printRace(car);
        }
        System.out.println();
    }
}
