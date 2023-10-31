package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private List<Car> cars = new ArrayList<>();

    private boolean isMoveForward() {
        return CreateRandomNumber.getNumber() >= 4;
    }

    private void setCars(String[] names) {
        for (String name : names) {
            Car car = new Car(name);
            cars.add(car);
        }
    }
}
