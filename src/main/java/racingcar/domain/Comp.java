package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Comp {

    public void CompCars(List<Car> cars, List<Car> winner) {

        int max = FindMaxValue(cars);

        for (Car car : cars) {
            if (max == car.cnt) {
                winner.add(car);
            }
        }

    }

    private int FindMaxValue(List<Car> cars) {

        int max = 0;

        for (Car car : cars) {
            if (max < car.cnt) {
                max = car.cnt;
            }
        }

        return max;
    }


}
