package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars = new ArrayList<>();

    public Cars(String[] carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }
}
