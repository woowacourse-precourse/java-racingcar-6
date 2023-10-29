package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {

    private final List<Car> cars = new ArrayList<>();

    public RacingCars() {}

    public void setCars(String[] names) {
        for(String name : names)
            cars.add(new Car(name));
    }

    public List<Car> getCars() {
        return cars;
    }

}
