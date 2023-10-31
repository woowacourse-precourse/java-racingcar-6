package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private List<Car> cars = new ArrayList<>();
    private final int numberAttempts;

    private int countAttempts = 0;

    public Race(List<String> carNames, int numberAttempts) {
        if (numberAttempts < 0) {
            throw new IllegalArgumentException("numberAttempts must not be less than 0");
        }
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        this.numberAttempts = numberAttempts;
    }
}
