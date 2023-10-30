package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> carList;

    public Cars(List<String> carNames) {
        this.carList = new ArrayList<>();
        for (String name: carNames) {
            carList.add(new Car(name));
        }
    }
}
