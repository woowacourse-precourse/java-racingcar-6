package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private final static List<Car> racingCars = new ArrayList<>();

    public static void createCars(List<String> cars) {
        for (String car : cars) {
            racingCars.add(new Car(car, 0));
        }
    }
}
