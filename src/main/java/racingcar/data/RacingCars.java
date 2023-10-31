package racingcar.data;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private final List<Car> cars;
    private static final int INIT_POS = 0;

    public RacingCars() {
        this.cars = new ArrayList<>();
    }

    public void createCar(String name) {
        Car newCar = new Car(name, INIT_POS);
        cars.add(newCar);
    }

    public int isTotal() {
        return cars.size();
    }
}
