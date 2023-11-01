package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarManager {
    public List<String> giveName(String inputNames) {
        Verification verification = new Verification();

        List<String> cars = new ArrayList<>();
        for (String car : inputNames.split(",")) {
            if (verification.isFiveOrLess(car)) {
                cars.add(car);
            } else {
                throw new IllegalArgumentException();
            }
        }

        verification.duplicate(cars);
        return cars;
    }
}
