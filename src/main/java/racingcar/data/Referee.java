package racingcar.data;

import java.util.ArrayList;
import java.util.List;

public class Referee {

    private final List<Car> cars = new ArrayList<>();

    public void addCar(String name) {
        cars.add(new Car(name));
    }

}
