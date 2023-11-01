package racingcar.domain.car;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars = new ArrayList<>();

    public Cars(final List<String> names) {
        names.forEach(name -> cars.add(new Car(name)));
    }
}
