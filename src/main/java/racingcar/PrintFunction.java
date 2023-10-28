package racingcar;

import java.util.ArrayList;
import java.util.List;

public class PrintFunction {

    void printScore(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.name + " : " + "-".repeat(car.score));
        }
        System.out.println();
    }
}
