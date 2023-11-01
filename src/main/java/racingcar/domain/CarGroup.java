package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarGroup {
    List<Car> cars = new ArrayList<>();

    public void addCar(Car car) {
        this.cars.add(car);
    }

    public int getCarGroupSize() {
        return cars.size();
    }
}
